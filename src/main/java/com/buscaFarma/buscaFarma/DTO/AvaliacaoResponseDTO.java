package com.buscaFarma.buscaFarma.DTO;

import com.buscaFarma.buscaFarma.model.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class AvaliacaoResponseDTO {

    private String id;
    private String numeroCNPJ;
    private String nomeFantasia;
    private String municipio;
    private String estado;
    private List<String> telefone;
    private CoordenadaGeo coordenadaGeo;
    private Endereco endereco;
    private List<Map<String, Object>> produtos;
}
