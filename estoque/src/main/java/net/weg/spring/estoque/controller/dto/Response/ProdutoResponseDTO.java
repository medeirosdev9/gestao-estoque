package net.weg.spring.estoque.controller.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.spring.estoque.model.Produto;

@Data
@AllArgsConstructor
public class ProdutoResponseDTO {
    private Integer id;
    private String nome;
    private double preco;
    private Integer estoque;
    private String data_validade;
    private String descricao;
    private String barras;
    private double peso;
    private double medida;
    private FabricanteResponseDTO fabricante;
    private CategoriaResponseDTO categoria;

    public ProdutoResponseDTO convertToProdutoResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getData_validade(),
                produto.getDescricao(),
                produto.getBarras(),
                produto.getPeso(),
                produto.getMedida(),
                new FabricanteResponseDTO(
                        produto.getFabricante().getId(),
                        produto.getFabricante().getNome(),
                        produto.getFabricante().getDescricao()
                ),
                new CategoriaResponseDTO(
                        produto.getCategoria().getId(),
                        produto.getCategoria().getNome(),
                        produto.getCategoria().getDescricao()
                )
        );
    }

}
