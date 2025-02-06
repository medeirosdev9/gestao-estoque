package net.weg.spring.estoque.controller.dto.Request;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.spring.estoque.model.Categoria;
import net.weg.spring.estoque.model.Fabricante;

@Data
@AllArgsConstructor
public class ProdutoRequestDTO {
    private String nome;
    private double preco;
    private Integer estoque;
    private String data_validade;
    private String descricao;
    private String codigo_barras;
    private double peso;
    private double medida;
    private Integer id_fabricante;
    private Integer id_categoria;
}
