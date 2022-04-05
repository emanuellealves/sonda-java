package com.example.teste.sonda;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public enum DirecaoCardinal {
    @JsonProperty("N")
    NORTE,
    @JsonProperty("S")
    SUL,
    @JsonProperty("L")
    LESTE,
    @JsonProperty("O")
    OESTE;

    public static DirecaoCardinal virarEsquerda(DirecaoCardinal direcaoAtual){
        switch (direcaoAtual) {
            case NORTE:
                return DirecaoCardinal.OESTE;
            case LESTE:
                return DirecaoCardinal.NORTE;
            case SUL:
                return DirecaoCardinal.LESTE;
            case OESTE:
                return DirecaoCardinal.SUL;
            default:
                return direcaoAtual;
        }
    }

    public static DirecaoCardinal virarDireita(DirecaoCardinal direcaoAtual){
        switch (direcaoAtual) {
            case NORTE:
                return DirecaoCardinal.LESTE;
            case LESTE:
                return DirecaoCardinal.SUL;
            case SUL:
                return DirecaoCardinal.OESTE;
            case OESTE:
                return DirecaoCardinal.NORTE;
            default:
                return direcaoAtual;
        }
    }

    public static ArrayList<Integer> proximaPosicao(DirecaoCardinal direcaoAtual){
        ArrayList<Integer> proximasPosicoes = new ArrayList<>();
        switch (direcaoAtual) {
            case NORTE:
                proximasPosicoes.add(0);
                proximasPosicoes.add(1);
                return proximasPosicoes;
            case LESTE:
                proximasPosicoes.add(1);
                proximasPosicoes.add(0);
                return proximasPosicoes;
            case SUL:
                proximasPosicoes.add(0);
                proximasPosicoes.add(-1);
                return proximasPosicoes;
            case OESTE:
                proximasPosicoes.add(-1);
                proximasPosicoes.add(0);
                return proximasPosicoes;
            default:
                proximasPosicoes.add(0);
                proximasPosicoes.add(0);
                return proximasPosicoes;
        }
    }
}
