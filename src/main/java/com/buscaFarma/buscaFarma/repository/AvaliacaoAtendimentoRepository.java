package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoClienteATD;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoAtendimentoRepository extends MongoRepository<AvaliacaoClienteATD, String> {

}
