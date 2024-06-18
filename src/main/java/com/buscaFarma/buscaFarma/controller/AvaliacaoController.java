package com.buscaFarma.buscaFarma.controller;

import com.buscaFarma.buscaFarma.DTO.AvaliacaoCompletaDTO;
import com.buscaFarma.buscaFarma.DTO.AvaliacaoDTO;
import com.buscaFarma.buscaFarma.DTO.AvaliacaoResponseDTO;
import com.buscaFarma.buscaFarma.model.AvaliacaoAtendimento;
import com.buscaFarma.buscaFarma.model.AvaliacaoComentario;
import com.buscaFarma.buscaFarma.model.AvaliacaoProduto;
import com.buscaFarma.buscaFarma.model.AvaliacaoRanking;
import com.buscaFarma.buscaFarma.repository.AvaliacaoAtendimentoRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoComentarioRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoProdutoRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoRankingRepository;
import com.buscaFarma.buscaFarma.service.AvaliacaoService;
import com.buscaFarma.buscaFarma.service.FarmaciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/avaliacao")
@Tag(name="Avaliacao", description = "API para avaliação das farmácias populares")

public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private FarmaciaService farmaciaService;

    @PostMapping()
    @Operation(summary = "Avaliação de farmácoas", description = "Avalia uma farmácia")
    public String avaliarProduto(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        avaliacaoDTO.setDataAvaliacao(LocalDateTime.now());
        return this.avaliacaoService.avaliar(avaliacaoDTO);
    }

    @GetMapping("/{cnpj}")
    public AvaliacaoResponseDTO getAvaliacaoByCnpj(@PathVariable String cnpj) {

        List<AvaliacaoCompletaDTO> avaliacoes = this.farmaciaService.executarAgregacao(cnpj);

        if (avaliacoes.isEmpty()){
            throw new RuntimeException("Nenhuma avaliação encontrada para este cnpj");
        }

        AvaliacaoResponseDTO avaliacao = this.avalicaoCompletaDTOToAvaliacaoResponseDTOParsing(avaliacoes.get(0));
        List<Map<String, Object>> listaProdutos = getProdutos(avaliacoes.get(0));
        avaliacao.setProdutos(listaProdutos);

        return avaliacao;
    }

    public List<Map<String, Object>> getProdutos(AvaliacaoCompletaDTO avaliacaoResponseDTO) {

        List<Map<String, Object>> listaProdutos = new ArrayList<>();
        avaliacaoResponseDTO.getAvaliacaoPrd().forEach(avaliacaoProduto -> {
            Map<String, Object> novoItem = new HashMap<>();
            novoItem.put("produto", avaliacaoProduto.getPrincipioAtivo());
            novoItem.put("dataAvaliacao", avaliacaoProduto.getDataAvaliacao());
            novoItem.put("patologia", avaliacaoProduto.getPatologia());

            boolean itemExistente = false;

            for (int i = 0; i < listaProdutos.size(); i++) {
                Map<String, Object> itemAtual = listaProdutos.get(i);
                if (itemAtual.get("produto").equals(avaliacaoProduto.getPrincipioAtivo())) {
                    // Compara as datas de avaliação
                    LocalDateTime dataAtual = (LocalDateTime) itemAtual.get("dataAvaliacao");
                    LocalDateTime novaDataAvaliacao = (LocalDateTime) avaliacaoProduto.getDataAvaliacao();

                    if (novaDataAvaliacao.isAfter(dataAtual)) {
                        // Substitui o item existente se a nova data for mais recente
                        listaProdutos.set(i, novoItem);
                    }
                    itemExistente = true;
                    break;
                }
            }

            if (!itemExistente) {
                // Adiciona o novo item se não encontrar item existente
                listaProdutos.add(novoItem);
            }

        });
        return listaProdutos;
    }

    public AvaliacaoResponseDTO avalicaoCompletaDTOToAvaliacaoResponseDTOParsing(AvaliacaoCompletaDTO avaliacaoCompletaDTO){
        return   AvaliacaoResponseDTO.builder()
                .id(avaliacaoCompletaDTO.getId())
                .numeroCNPJ(avaliacaoCompletaDTO.getNumeroCNPJ())
                .nomeFantasia(avaliacaoCompletaDTO.getNomeFantasia())
                .municipio(avaliacaoCompletaDTO.getMunicipio())
                .estado(avaliacaoCompletaDTO.getEstado())
                .telefone(avaliacaoCompletaDTO.getTelefone())
                .coordenadaGeo(avaliacaoCompletaDTO.getCoordenadaGeo())
                .endereco(avaliacaoCompletaDTO.getEndereco())
                .build();
    }


}
