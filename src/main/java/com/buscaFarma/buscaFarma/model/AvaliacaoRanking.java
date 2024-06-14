package com.buscaFarma.buscaFarma.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "AvaliacaoRnk")
@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AvaliacaoRanking {
    @Id
    private String id;
    private LocalDateTime dataPreenchimento;
    private Boolean marcadorAnonimo;
    private Integer valor;
    private String numeroCNPJ;
    private String numeroDocumento;
}

