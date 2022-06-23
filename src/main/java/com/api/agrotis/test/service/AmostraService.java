package com.api.agrotis.test.service;

import com.api.agrotis.test.entities.Amostra;
import com.api.agrotis.test.repository.AmostraRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AmostraService {
    @Autowired
    private AmostraRepository amostraRepository;

    public Amostra saveSample(Amostra amostra){
        amostraRepository.save(amostra);
        return amostra;
    }

   public List<Amostra> getSamples(){
        return amostraRepository.findAll();
   }

   public Optional<Amostra> getSampleById(Long id){
        return amostraRepository.findByid(id);
   }

   public void deleteSampleById(Long id){
        amostraRepository.deleteById(id);

   }
}
