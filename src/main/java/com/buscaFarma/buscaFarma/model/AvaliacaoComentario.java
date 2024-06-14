package com.buscaFarma.buscaFarma.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "AvaliacaoCmt")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvaliacaoComentario {
    @Id
    private String id;
    private LocalDateTime dataPreenchimento;
    private Boolean marcadorAnonimo;
    private String texto;
    private String numeroCNPJ;
    private String numeroDocumento;
}

