package net.weg.spring.estoque.controller.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoResponseDTO {
    private Integer id;
    private String nome;
    private double preco;
    private Integer estoque;
    private String data_validade;
    private String descricao;
    private String codigo_barras;
    private double peso;
    private double medida;
    private FabricanteResponseDTO fabricante;
    private CategoriaResponseDTO categoria;
}
