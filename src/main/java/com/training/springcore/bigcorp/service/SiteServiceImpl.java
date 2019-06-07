package com.training.springcore.bigcorp.service;

import com.training.springcore.bigcorp.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private ResourceLoader resourceLoader;
    public SiteServiceImpl(){

    }

    private CaptorService captorService;
    @Autowired
    public SiteServiceImpl(CaptorService captorService) {
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
    }




    @Override
    @Monitored
    public Site findById(String siteId) {
        System.out.println("Appel de findById :" + this);
        if (siteId == null) {
            return null;
        }
        //this.readFile("classpath: example.txt");
        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }

   /* @Override
    public void readFile(String path) {
        Resource resource = resourceLoader
                .getResource("classpath:example.txt");
         try (InputStream stream = resource.getInputStream()) {
            Scanner scanner = new Scanner(stream).useDelimiter("\\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
