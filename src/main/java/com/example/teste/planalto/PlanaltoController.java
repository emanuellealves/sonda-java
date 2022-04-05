package com.example.teste.planalto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "planalto")
public class PlanaltoController {

    @Autowired
    private PlanaltoRepository planaltoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Planalto criarPlanalto(@RequestBody Planalto planalto) {
        return planaltoRepository.save(planalto);
    }

    @GetMapping
    public List<Planalto> buscarPlanalto() {
        return planaltoRepository.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void excluirPlanalto(@PathVariable(value = "id") Integer id) {
        planaltoRepository.deleteById(id);
    }
}
