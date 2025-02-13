package net.weg.spring.estoque.controller.dto.Request;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.spring.estoque.model.Categoria;
import net.weg.spring.estoque.model.Fabricante;
import net.weg.spring.estoque.model.Produto;

@Data
@AllArgsConstructor
public class ProdutoRequestDTO {

    @NotBlank
    private String nome;

    @Positive
    @NotNull
    private double preco;

    @PositiveOrZero
    private Integer estoque;

    @NotBlank
    private String data_validade;

    @NotBlank
    private String descricao;

    @NotNull
    private String barras;

    @NotNull
    private double peso;

    @NotNull
    private double medida;

    @NotNull
    private Fabricante fabricante;

    @NotNull
    private Categoria categoria;

    public Produto convert() {
        return Produto.builder()
                .nome(this.nome)
                .preco(this.preco)
                .estoque(this.estoque)
                .data_validade(this.data_validade)
                .descricao(this.descricao)
                .barras(this.barras)
                .peso(this.peso)
                .medida(this.medida)
                .fabricante(this.fabricante)
                .categoria(this.categoria)
                .build();
    }
}
