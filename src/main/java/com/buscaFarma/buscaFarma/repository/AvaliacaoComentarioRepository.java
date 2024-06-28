package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.AvaliacaoClienteComentario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoComentarioRepository extends MongoRepository<AvaliacaoClienteComentario, String> {

}
