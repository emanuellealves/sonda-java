package com.example.teste.planalto;

import com.example.teste.sonda.Sonda;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "planalto")
public class Planalto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @NotNull
    @Column(name = "profundidade_x")
    private Integer profundidadeX;
    @NotNull
    @Column(name = "profundidade_y")
    private Integer profundidadeY;

    public Planalto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getProfundidadeX() {
        return profundidadeX;
    }

    public void setProfundidadeX(Integer profundidadeX) {
        this.profundidadeX = profundidadeX;
    }

    public Integer getProfundidadeY() {
        return profundidadeY;
    }

    public void setProfundidadeY(Integer profundidadeY) {
        this.profundidadeY = profundidadeY;
    }

    public boolean verificarSeExistePontoCardinal(Integer profundidadeX, Integer profundidadeY) {
        if (this.profundidadeX < profundidadeX || this.profundidadeY < profundidadeY) {
            return false;
        }
        return true;
    }
}
