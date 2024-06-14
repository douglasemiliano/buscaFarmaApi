package com.buscaFarma.buscaFarma.service;

import com.buscaFarma.buscaFarma.DTO.AvaliacaoDTO;
import com.buscaFarma.buscaFarma.model.AvaliacaoAtendimento;
import com.buscaFarma.buscaFarma.model.AvaliacaoComentario;
import com.buscaFarma.buscaFarma.model.AvaliacaoProduto;
import com.buscaFarma.buscaFarma.model.AvaliacaoRanking;
import com.buscaFarma.buscaFarma.repository.AvaliacaoAtendimentoRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoComentarioRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoProdutoRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoRankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoProdutoRepository avaliacaoProdutoRepository;

    @Autowired
    private AvaliacaoAtendimentoRepository avaliacaoAtendimentoRepository;

    @Autowired
    private AvaliacaoComentarioRepository avaliacaoComentarioRepository;

    @Autowired
    private AvaliacaoRankingRepository avaliacaoRankingRepository;



    public String avaliar(AvaliacaoDTO avaliacaoDTO){
        AvaliacaoProduto avaliacaoProduto = AvaliacaoProduto.builder()
                .dataAvaliacao(avaliacaoDTO.getDataAvaliacao())
                .marcadorAnonimo(avaliacaoDTO.getMarcadorAnonimo())
                .principioAtivo(avaliacaoDTO.getPrincipioAtivo())
                .patologia(avaliacaoDTO.getPatologia())
                .tipoModalidade(avaliacaoDTO.getTipoModalidade())
                .numeroCNPJ(avaliacaoDTO.getNumeroCNPJ())
                .numeroDocumento(avaliacaoDTO.getNumeroDocumento())
                .build();

        AvaliacaoAtendimento avaliacaoAtendimento = AvaliacaoAtendimento.builder()
                .dataPreenchimento(avaliacaoDTO.getDataAvaliacao())
                .marcadorAnonimo(avaliacaoDTO.getMarcadorAnonimo())
                .houveFila(avaliacaoDTO.getHouveFila())
                .horarioAtendimento(avaliacaoDTO.getHorarioAtendimento())
                .numeroCNPJ(avaliacaoDTO.getNumeroCNPJ())
                .numeroDocumento(avaliacaoDTO.getNumeroDocumento())
                .qualidadeAtendimento(avaliacaoDTO.getQualidadeAtendimento())
                .tipoAdquirido(avaliacaoDTO.getTipoAdquirido())
                .build();

        AvaliacaoComentario avaliacaoComentario = AvaliacaoComentario.builder()
                .dataPreenchimento(avaliacaoDTO.getDataAvaliacao())
                .marcadorAnonimo(avaliacaoDTO.getMarcadorAnonimo())
                .texto(avaliacaoDTO.getComentario())
                .numeroCNPJ(avaliacaoDTO.getNumeroCNPJ())
                .numeroDocumento(avaliacaoDTO.getNumeroDocumento())
                .build();

        AvaliacaoRanking avaliacaoRanking = AvaliacaoRanking.builder()
                .dataPreenchimento(avaliacaoDTO.getDataAvaliacao())
                .marcadorAnonimo(avaliacaoDTO.getMarcadorAnonimo())
                .valor(avaliacaoDTO.getNota())
                .numeroCNPJ(avaliacaoDTO.getNumeroCNPJ())
                .numeroDocumento(avaliacaoDTO.getNumeroDocumento())
                .build();

        this.avaliarProduto(avaliacaoProduto);
        this.avaliarAtendimento(avaliacaoAtendimento);
        this.avaliarComentario(avaliacaoComentario);
        this.avaliarRanking(avaliacaoRanking);

        return "Avaliação com sucesso";
    }
    public AvaliacaoProduto avaliarProduto(AvaliacaoProduto avaliacaoProduto) {
        return this.avaliacaoProdutoRepository.save(avaliacaoProduto);
    }

    public AvaliacaoAtendimento avaliarAtendimento(AvaliacaoAtendimento avaliacaoAtendimento) {
        return this.avaliacaoAtendimentoRepository.save(avaliacaoAtendimento);
    }
    public AvaliacaoComentario avaliarComentario(AvaliacaoComentario avaliacaoComentario) {
        return this.avaliacaoComentarioRepository.save(avaliacaoComentario);
    }
    public AvaliacaoRanking avaliarRanking(AvaliacaoRanking avaliacaoRanking) {
        return this.avaliacaoRankingRepository.save(avaliacaoRanking);
    }
}

