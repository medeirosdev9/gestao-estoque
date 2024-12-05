package net.weg.spring.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nome;
    @Min(1)
    private double preco;
    @Column(unique=true)
    private Integer estoque;
    private String data_validade;
    private String descricao;
    private String codigo_barras;
    private double peso;
    private double medida;
    @ManyToOne
    private Fabricante fabricante;
    private String categoria;
}