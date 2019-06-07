package com.training.springcore.bigcorp;

import com.training.springcore.bigcorp.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Set;


@Configuration

public class BigCorpApplicationConfig {
    @Value("${bigcorp.name}")
    private String name;

    @Value("${bigcorp.version}")
    private Integer version;

    @Value("${bigcorp.emails}")
    private Set<String> emails;

    @Value("${bigcorp.webSiteUrl}")
    private String webSiteUrl;

    @Bean
    public ApplicationInfo applicationInfo() {
        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }
}
