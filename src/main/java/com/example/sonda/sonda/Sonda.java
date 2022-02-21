package com.example.sonda.sonda;

import com.example.sonda.planalto.Planalto;

//import javax.persistence.*;

//@Entity
//@Table(name = "sonda")
public class Sonda {

    //@Id
    private int id;
    private int posicaoX;
    private int posicaoY;
    private String direcao;

    //@ManyToOne
    //@JoinColumn(name = "planaltoId")
    private Planalto planalto;

    public Sonda(int posicaoX, int posicaoY, String direcao, Planalto planalto) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.direcao = direcao;
        this.planalto = planalto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public Planalto getPlanalto() {
        return planalto;
    }

    public void setPlanalto(Planalto planalto) {
        this.planalto = planalto;
    }

}
