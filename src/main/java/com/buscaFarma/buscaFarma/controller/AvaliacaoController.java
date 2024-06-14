package com.buscaFarma.buscaFarma.controller;

import com.buscaFarma.buscaFarma.DTO.AvaliacaoDTO;
import com.buscaFarma.buscaFarma.model.AvaliacaoAtendimento;
import com.buscaFarma.buscaFarma.model.AvaliacaoComentario;
import com.buscaFarma.buscaFarma.model.AvaliacaoProduto;
import com.buscaFarma.buscaFarma.model.AvaliacaoRanking;
import com.buscaFarma.buscaFarma.repository.AvaliacaoAtendimentoRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoComentarioRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoProdutoRepository;
import com.buscaFarma.buscaFarma.repository.AvaliacaoRankingRepository;
import com.buscaFarma.buscaFarma.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;



    @PostMapping()
    public String avaliarProduto(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        avaliacaoDTO.setDataAvaliacao(LocalDateTime.now());
        return this.avaliacaoService.avaliar(avaliacaoDTO);
    }


}
