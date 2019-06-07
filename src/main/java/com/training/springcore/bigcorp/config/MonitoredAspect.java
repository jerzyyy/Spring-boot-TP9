package com.training.springcore.bigcorp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitoredAspect {
    @Before("@annotation(com.training.springcore.bigcorp.service.Monitored)")
    public void logServiceBeforeCall(JoinPoint jp) {
        System.out.println("Appel finder " + jp.getSignature());
    }

    @After("@annotation(com.training.springcore.bigcorp.service.Monitored)")
    public void logServiceAfterCall(JoinPoint jp) {
        System.out.println("Fin d'appel finder " + jp.getSignature());
    }

}
