package com.buscaFarma.buscaFarma.DTO;

import com.buscaFarma.buscaFarma.model.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AvaliacaoCompletaDTO {

    private String id;
    private String numeroCNPJ;
    private String nomeFantasia;
    private String municipio;
    private String estado;
    private List<String> telefone;
    private CoordenadaGeo coordenadaGeo;
    private Endereco endereco;
    private List<AvaliacaoComentario> avaliacaoCmt;
    private List<AvaliacaoProduto> avaliacaoPrd;
    private List<AvaliacaoRanking> avaliacaoRnk;
    private List<AvaliacaoAtendimento> avaliacaoATD;
}
