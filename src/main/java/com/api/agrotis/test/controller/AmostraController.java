package com.api.agrotis.test.controller;

import com.api.agrotis.test.entities.Amostra;
import com.api.agrotis.test.service.AmostraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amostra")
public class AmostraController {

    @Autowired
    private AmostraService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Amostra salvarAmostra(Amostra amostra) {
        return service.saveSample(amostra);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Amostra> consultarAmostras() {
        return service.getSamples();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<Amostra> consultarAmostraPorId(@PathVariable("id") Long id) {
        return Optional.ofNullable(service.getSampleById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Amostra Não Encontrada.")));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAmostra(@PathVariable("id") Long id){
        service.getSampleById(id).map(amostra -> {
            service.deleteSampleById(amostra.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Amostra não encontrada."));
    }


    @PutMapping("/{id}")
    public void atualizarAmostra(@PathVariable("id") Long id, @RequestBody Amostra amostra){
        service.getSampleById(id).map(amostra1 -> {
            modelMapper.map(amostra, amostra1);
            service.saveSample(amostra1);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Amostra não encontrada."));
    }
}

