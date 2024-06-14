package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoComentario;
import com.buscaFarma.buscaFarma.model.AvaliacaoRanking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoRankingRepository extends MongoRepository<AvaliacaoRanking, String> {

}
