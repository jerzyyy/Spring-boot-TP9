package com.training.springcore.bigcorp.service;

import com.training.springcore.bigcorp.model.Site;


public interface SiteService {
    Site findById(String siteId);

   // void readFile(String path);
}
