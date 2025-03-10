package net.weg.spring.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.controller.dto.Response.FabricanteResponseDTO;
import net.weg.spring.estoque.model.Fabricante;
import net.weg.spring.estoque.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FabricanteService {
    private FabricanteRepository repository;
    public FabricanteResponseDTO create(Fabricante fabricante) {
        return EntityToDto(repository.save(fabricante)) ;
    }

    public FabricanteResponseDTO update(Fabricante fabricante, Integer id) {
        fabricante.setId(id);
        return EntityToDto(repository.save(fabricante)) ;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public FabricanteResponseDTO findById(Integer id) {
        return EntityToDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Fabricante não encontrado")));
    }

    public List<FabricanteResponseDTO> findAll() {
        List<FabricanteResponseDTO> fabricanteResponseDTOS = new ArrayList<>();
        for (Fabricante fabricante : repository.findAll()) {
            fabricanteResponseDTOS.add(EntityToDto(fabricante));
        }
        return fabricanteResponseDTOS;
    }

    public FabricanteResponseDTO EntityToDto(Fabricante fabricante) {
        return new FabricanteResponseDTO(fabricante.getId(), fabricante.getNome(), fabricante.getDescricao());
    }

    public Fabricante DtoToEntity(FabricanteResponseDTO fabricanteResponseDTO) {
        Fabricante fabricante = new Fabricante();
        fabricante.setId(fabricanteResponseDTO.getId());
        fabricante.setNome(fabricanteResponseDTO.getNome());
        fabricante.setDescricao(fabricanteResponseDTO.getDescricao());
        return fabricante;
    }
}