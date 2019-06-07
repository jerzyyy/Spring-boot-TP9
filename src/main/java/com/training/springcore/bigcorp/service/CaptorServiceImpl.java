package com.training.springcore.bigcorp.service;

import com.training.springcore.bigcorp.model.Captor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CaptorServiceImpl implements CaptorService{
    @Value("${bigcorp.measure.default-simulated}")
    private Integer defaultValue;


    @Override
    @Monitored
    public Set<Captor> findBySite(String siteId) {
        Set<Captor> captors = new HashSet<>();
        if (siteId == null) {
            return captors;
        }
        captors.add(new Captor("Capteur A"));
        return captors;
    }
}
