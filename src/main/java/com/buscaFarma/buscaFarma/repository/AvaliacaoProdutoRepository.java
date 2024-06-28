package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoClienteProduto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoProdutoRepository extends MongoRepository<AvaliacaoClienteProduto, String> {

}
