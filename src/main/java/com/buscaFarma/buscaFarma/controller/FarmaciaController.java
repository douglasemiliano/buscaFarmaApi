package com.buscaFarma.buscaFarma.controller;

import com.buscaFarma.buscaFarma.model.Farmacia;
import com.buscaFarma.buscaFarma.repository.FarmaciaRepository;
import com.buscaFarma.buscaFarma.service.FarmaciaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {
    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping()
    public List<Farmacia> getFarmacia() {
        return farmaciaRepository.findAllItems();

    }

    @GetMapping("/busca")
    public List<Farmacia> getFarmaciaByMunicipioEstado(@RequestParam(name = "bairro") String bairro, @RequestParam(name = "municipio") String municipio, @RequestParam(name="estado") String estado) {
        System.err.println(municipio + " " + estado + " " + bairro);

        List<Farmacia> farmacias;
        if (!bairro.isEmpty() && !municipio.isEmpty() && !estado.isEmpty() ) {
            farmacias = farmaciaRepository.buscarPorBairroMunicipioEstado(bairro, municipio,estado);
        } else if (bairro.isEmpty() && !municipio.isEmpty() && !estado.isEmpty()) {
            farmacias = farmaciaRepository.buscarPorMunicipioEstado(municipio,estado);
        } else if (bairro.isEmpty() && municipio.isEmpty() && !estado.isEmpty()) {
            farmacias = farmaciaRepository.buscarPorEstado(estado);
        } else {
            return null;
        }
        return farmacias;
    }

    @GetMapping("/avaliacao/{cnpj}")
    public Object getAvaliacaoByCnpj(@PathVariable String cnpj) {
        System.err.println("entrou");
        System.err.println(cnpj);
        System.err.println(this.farmaciaService.executarAgregacao());
        return this.farmaciaService.executarAgregacao();
    }
}
