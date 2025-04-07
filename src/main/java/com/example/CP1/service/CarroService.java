package com.example.CP1.service;

import com.example.CP1.exception.ResourceNotFoundException;
import com.example.CP1.model.Carro;
import com.example.CP1.repository.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public List<Carro> listarMaisPotentes() {
        return repository.findTop10ByOrderByPotenciaDesc();
    }

    public List<Carro> listarMaisEconomicos() {
        return repository.findTop10ByOrderByEconomiaDesc();
    }

    public List<Carro> listarPorTipo(String tipo) {
        return repository.findByTipoIgnoreCase(tipo);
    }

    public Carro buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado"));
    }

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }

    public Carro atualizar(Long id, Carro novoCarro) {
        Carro existente = buscarPorId(id);

        existente.setMarca(novoCarro.getMarca());
        existente.setModelo(novoCarro.getModelo());
        existente.setAno(novoCarro.getAno());
        existente.setPotencia(novoCarro.getPotencia());
        existente.setEconomia(novoCarro.getEconomia());
        existente.setTipo(novoCarro.getTipo());
        existente.setPreco(novoCarro.getPreco());

        return repository.save(existente);
    }
    @Transactional
    public void deletar(Long id) {
        Carro carro = buscarPorId(id);
        repository.delete(carro);
    }
}