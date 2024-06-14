package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoAtendimento;
import com.buscaFarma.buscaFarma.model.AvaliacaoProduto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoAtendimentoRepository extends MongoRepository<AvaliacaoAtendimento, String> {

}
