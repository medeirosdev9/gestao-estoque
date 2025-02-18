package net.weg.spring.estoque.controller.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class FabricanteRequestDTO{

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
}

