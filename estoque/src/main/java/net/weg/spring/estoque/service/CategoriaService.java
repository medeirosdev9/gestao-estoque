package net.weg.spring.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.controller.dto.Response.CategoriaResponseDTO;
import net.weg.spring.estoque.model.Categoria;
import net.weg.spring.estoque.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository repository;
    public CategoriaResponseDTO create(Categoria categoria) {
        return EntityToDto(repository.save(categoria));
    }

    public Categoria update(Categoria categoria, Integer id) {
        categoria.setId(id);
        return repository.save(categoria);
    }


    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public CategoriaResponseDTO findById(Integer id) {
        return EntityToDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada")));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public CategoriaResponseDTO EntityToDto(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

    public Categoria DtoToEntity(CategoriaResponseDTO categoriaResponseDTO) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaResponseDTO.getId());
        categoria.setNome(categoriaResponseDTO.getNome());
        categoria.setDescricao(categoriaResponseDTO.getDescricao());
        return categoria;
    }
}
