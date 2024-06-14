package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoProduto;
import com.buscaFarma.buscaFarma.model.Farmacia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AvaliacaoProdutoRepository extends MongoRepository<AvaliacaoProduto, String> {

}
