package com.buscaFarma.buscaFarma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class FarmaciaService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Object executarAgregacao() {
        return mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.match(Criteria.where("numeroCNPJ").is("12345678000199")),
                        Aggregation.lookup("AvaliacaoCmt", "numeroCNPJ", "numeroCNPJ", "avaliacaoCmt"),
                        Aggregation.lookup("AvaliacaoPrd", "numeroCNPJ", "numeroCNPJ", "avaliacaoPrd"),
                        Aggregation.lookup("AvaliacaoRnk", "numeroCNPJ", "numeroCNPJ", "avaliacaoRnk"),
                        Aggregation.lookup("AvaliacaoATD", "numeroCNPJ", "numeroCNPJ", "avaliacaoATD")
                ),
                "Farmacia",
                Object.class
        ).getMappedResults();
    }
}

