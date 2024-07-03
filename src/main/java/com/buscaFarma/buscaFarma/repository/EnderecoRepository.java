package com.buscaFarma.buscaFarma.repository;

import com.buscaFarma.buscaFarma.model.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
    List<Endereco> findAll();

    @Query(value = "{ 'estado' : ?0 }", fields = "{ 'municipio' : 1 }")
    List<String> findDistinctMunicipiosByEstado(String estado);

    @Query(value = "{ 'estado' : ?0, 'municipio' : ?1 }", fields = "{ 'bairro' : 1 }")
    List<String> findDistinctBairrosByMunicipioAndEstado(String municipio, String estado);
}
