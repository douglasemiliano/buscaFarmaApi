package com.buscaFarma.buscaFarma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Farmacia")
@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Farmacia {
    @Id
    private String id;
    private String numeroCNPJ;
    private String nomeFantasia;
    private String municipio;
    private String estado;
    private List<String> telefone;
    private CoordenadaGeo coordenadaGeo;
    private Endereco endereco;

    // Getters e Setters
}

class CoordenadaGeo {
    @JsonProperty("type")
    private String type;
    @JsonProperty("coordinates")
    private List<Double> coordinates;

    // Getters e Setters
}

class Endereco {
    @JsonProperty("rua")
    private String rua;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("bairro")
    private String bairro;

    // Getters e Setters
}
