package com.example.teste.sonda;

import com.example.teste.planalto.Planalto;
import com.example.teste.planalto.PlanaltoRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Table(name = "sonda")
public class Sonda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Preencha a posição X em que deseja pousar.")
    @Column(name = "posicao_x")
    private Integer posicaoX;
    @NotNull
    @Column(name = "posicao_y")
    private Integer posicaoY;
    @NotNull
    @Column(name = "direcao_cardinal")
    @Enumerated(EnumType.STRING)
    private DirecaoCardinal direcaoCardinal;

    @ManyToOne
    @JoinColumn(name = "planalto_id")
    private Planalto planalto;

    public Sonda() {}

//    public Sonda(int posicaoX, int posicaoY, String direcao, Planalto planalto) {
//        super();
//        this.posicaoX = posicaoX;
//        this.posicaoY = posicaoY;
//        this.direcaoCardinal = DirecaoCardinal.valueOf(direcao.toUpperCase(Locale.ROOT));
//        this.planalto = planalto;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public Integer getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public DirecaoCardinal getDirecaoCardinal() {
        return direcaoCardinal;
    }

    public void setDirecaoCardinal(DirecaoCardinal direcaoCardinal) {
        this.direcaoCardinal = direcaoCardinal;
    }

    public Planalto getPlanalto() {
        return this.planalto;
    }

    public void setPlanalto(Planalto planalto) {
        this.planalto = planalto;
    }

    public Sonda virarDireita(){
        DirecaoCardinal proxDirecao = DirecaoCardinal.virarDireita(this.getDirecaoCardinal());
        this.setDirecaoCardinal(proxDirecao);
        return this;
    }

    public Sonda virarEsquerda(){
        DirecaoCardinal proxDirecao = DirecaoCardinal.virarEsquerda(this.getDirecaoCardinal());
        this.setDirecaoCardinal(proxDirecao);
        return this;
    }

    public Sonda proximaPosicao() {
        ArrayList proximaPosicao = DirecaoCardinal.proximaPosicao(this.getDirecaoCardinal());
        this.setPosicaoX(this.getPosicaoX() + proximaPosicao.indexOf(0));
        this.setPosicaoY(this.getPosicaoY() + proximaPosicao.indexOf(1));
        return this;
    }

}
