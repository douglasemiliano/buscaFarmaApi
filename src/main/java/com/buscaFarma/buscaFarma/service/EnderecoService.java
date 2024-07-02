package com.buscaFarma.buscaFarma.service;

import com.buscaFarma.buscaFarma.model.Endereco;
import com.buscaFarma.buscaFarma.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<String> buscarMunicipiosPorEstado(String estado) {
        return enderecoRepository.findDistinctMunicipiosByEstado(estado);
    }

    public List<String> buscarBairrosPorMunicipioEEstado(String municipio, String estado) {
        return enderecoRepository.findDistinctBairrosByMunicipioAndEstado(municipio, estado);
    }
}
