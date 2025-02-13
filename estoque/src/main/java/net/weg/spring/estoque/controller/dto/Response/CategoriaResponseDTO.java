package net.weg.spring.estoque.controller.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaResponseDTO {
    private Integer id;
    private String nome;
    private String descricao;
}
