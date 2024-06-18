package com.buscaFarma.buscaFarma.controller;

import com.buscaFarma.buscaFarma.DTO.AvaliacaoCompletaDTO;
import com.buscaFarma.buscaFarma.DTO.AvaliacaoResponseDTO;
import com.buscaFarma.buscaFarma.model.Farmacia;
import com.buscaFarma.buscaFarma.repository.FarmaciaRepository;
import com.buscaFarma.buscaFarma.service.FarmaciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/farmacias")
@Tag(name="Farmacias", description = "API para gerenciamento das farmácias populares")
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
    @Operation(summary = "Buscar farmacias por filtros", description = "Busca as farmacias por bairro, municipio e estado")
    public List<Farmacia> getFarmaciaByMunicipioEstado(@RequestParam(name = "bairro") String bairro, @RequestParam(name = "municipio") String municipio, @RequestParam(name="estado") String estado) {
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


    @GetMapping("/proximas")
    public List<Farmacia> getNearbyFarmacias(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double raioKm) {
        return farmaciaService.findNearbyFarmacias(latitude, longitude, raioKm);
    }

}
