package com.example.teste.sonda;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Movimento {
    @JsonProperty("D")
    DIREITA,
    @JsonProperty("E")
    ESQUERDA,
    @JsonProperty("M")
    MOVER


}
