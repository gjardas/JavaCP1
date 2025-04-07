package com.example.CP1.controller;

import com.example.CP1.model.Carro;
import com.example.CP1.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping("/potencia")
    public List<Carro> maisPotentes() {
        return service.listarMaisPotentes();
    }

    @GetMapping("/economia")
    public List<Carro> maisEconomicos() {
        return service.listarMaisEconomicos();
    }

    @GetMapping("/eletricos")
    public List<Carro> eletricos() {
        return service.listarPorTipo("eletrico");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> porId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public Carro adicionar(@RequestBody Carro carro) {
        return service.salvar(carro);
    }

    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody Carro carro) {
        return service.atualizar(id, carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}