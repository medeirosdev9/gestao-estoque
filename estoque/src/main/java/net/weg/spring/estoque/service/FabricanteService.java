package net.weg.spring.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.model.Fabricante;
import net.weg.spring.estoque.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FabricanteService {
    private FabricanteRepository repository;
    public Fabricante create(Fabricante fabricante) {
        return repository.save(fabricante);
    }

    public Fabricante update(Fabricante fabricante, Integer id) {
        fabricante.setId(id);
        return repository.save(fabricante);
    }


    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Fabricante findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Fabricante não encontrado"));
    }

    public List<Fabricante> findAll() {
        return repository.findAll();
    }
}
