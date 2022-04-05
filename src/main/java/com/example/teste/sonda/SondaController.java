package com.example.teste.sonda;

import com.example.teste.planalto.Planalto;
import com.example.teste.planalto.PlanaltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "sonda")
public class SondaController {

    @Autowired
    private SondaRepository sondaRepository;
    @Autowired
    private PlanaltoRepository planaltoRepository;

    @PostMapping
    public Sonda criarSonda(@RequestBody Sonda sonda) {
        Planalto planalto = planaltoRepository.findById(sonda.getPlanalto().getId()).orElse(null);
        if (planalto != null) {
            boolean existePontos = planalto.verificarSeExistePontoCardinal(sonda.getPosicaoX(), sonda.getPosicaoY());
            if (existePontos) {
                return sondaRepository.save(sonda);
            }
        }
        return null;
    }

    @GetMapping
    public List<Sonda> buscarSonda() {
        return sondaRepository.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void excluirSonda(@PathVariable(value = "id") Integer id) {
        sondaRepository.deleteById(id);
    }

    @PostMapping(value = "/{id}/direita")
    public Sonda virarSondaDireita(@PathVariable(value = "id")  Integer id){
        Sonda sonda = sondaRepository.findById(id).orElse(null);
        sondaRepository.save(sonda.virarDireita());
        return sonda;
    }

    @PostMapping(value = "/{id}/esquerda")
    public Sonda virarSondaEsquerda(@PathVariable(value = "id")  Integer id){
        Sonda sonda = sondaRepository.findById(id).orElse(null);
        sondaRepository.save(sonda.virarEsquerda());
        return sonda;
    }

    @PostMapping(value = "/{id}/mover")
    public Sonda moverSonda(@PathVariable(value = "id")  Integer id){
        Sonda sonda = sondaRepository.findById(id).orElse(null);
        sonda.proximaPosicao();
        Planalto planalto = sonda.getPlanalto();
        boolean existePontos = planalto.verificarSeExistePontoCardinal(sonda.getPosicaoX(), sonda.getPosicaoY());
        if (existePontos) {
            sondaRepository.save(sonda);
        }
        return sonda;
    }
}
