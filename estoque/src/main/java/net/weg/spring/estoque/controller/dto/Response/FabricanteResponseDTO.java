package net.weg.spring.estoque.controller.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FabricanteResponseDTO {
    private Integer id;
    private String nome;
    private String descricao;
}
