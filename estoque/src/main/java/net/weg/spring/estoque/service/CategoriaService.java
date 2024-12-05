package net.weg.spring.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.model.Categoria;
import net.weg.spring.estoque.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {
    private CategoriaRepository repository;
    public Categoria create(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria, Integer id) {
        categoria.setId(id);
        return repository.save(categoria);
    }


    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Categoria findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }
}
