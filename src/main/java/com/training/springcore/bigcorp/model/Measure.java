package com.training.springcore.bigcorp.model;

import java.time.Instant;

public class Measure {
    private Instant instant;
    private Integer valueInWatt;
    public Captor captor;

    public Measure(Instant instant, Integer valueInWatt, Captor captor){
        this.setInstant(instant);
        this.setValueInWatt(valueInWatt);
        this.captor=captor;
    }


    public Integer getValueInWatt() {
        return valueInWatt;
    }

    public void setValueInWatt(Integer valueInWatt) {
        this.valueInWatt = valueInWatt;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
