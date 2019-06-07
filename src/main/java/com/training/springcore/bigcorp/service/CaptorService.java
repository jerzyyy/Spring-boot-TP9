package com.training.springcore.bigcorp.service;

import com.training.springcore.bigcorp.model.Captor;

import java.util.Set;

public interface CaptorService {
    Set<Captor> findBySite(String siteId);
}
