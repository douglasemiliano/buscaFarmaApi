package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoComentario;
import com.buscaFarma.buscaFarma.model.AvaliacaoProduto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoComentarioRepository extends MongoRepository<AvaliacaoComentario, String> {

}
