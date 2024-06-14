package com.buscaFarma.buscaFarma.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "AvaliacaoPrd")
@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AvaliacaoProduto {
    @Id
    private String id;
    private LocalDateTime dataAvaliacao;
    private Boolean marcadorAnonimo;
    private String principioAtivo;
    private String patologia;
    private String tipoModalidade;
    private String numeroCNPJ;
    private String numeroDocumento;

}

