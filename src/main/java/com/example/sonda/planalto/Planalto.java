package com.example.sonda.planalto;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "planalto")
public class Planalto {
    {System.out.println("oi");}
    //@Id
    private int id;
    private int profundidadeX;
    private int profundidadeY;

    public Planalto(int id, int profundidadeX, int profundidadeY) {
        this.id = id;
        this.profundidadeX = profundidadeX;
        this.profundidadeY = profundidadeY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfundidadeX() {
        return profundidadeX;
    }

    public void setProfundidadeX(int profundidadeX) {
        this.profundidadeX = profundidadeX;
    }

    public int getProfundidadeY() {
        return profundidadeY;
    }

    public void setProfundidadeY(int profundidadeY) {
        this.profundidadeY = profundidadeY;
    }
}
