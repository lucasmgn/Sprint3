package br.com.sprint3.states.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Regiao {

    @JsonProperty("Norte")
    NORTE("Norte"),
    @JsonProperty("Nordeste")
    NORDESTE("Nordeste"),
    @JsonProperty("Sul")
    SUL("Sul"),
    @JsonProperty("Sudeste")
    SUDESTE("Sudeste"),
    @JsonProperty("Centro-Oeste")
    CENTRO_OESTE("Centro-Oeste");

    Regiao(String s) {
    }
}
