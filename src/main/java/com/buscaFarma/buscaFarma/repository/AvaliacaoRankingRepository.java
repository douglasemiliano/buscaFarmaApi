package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoClienteRank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoRankingRepository extends MongoRepository<AvaliacaoClienteRank, String> {

}
