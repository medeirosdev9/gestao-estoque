package net.weg.spring.estoque.model;

import jakarta.persistence.*;
import lombok.*;
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private double preco;

    @NonNull
    @Column(nullable = false)
    private Integer estoque;

    @NonNull
    @Column(nullable = false)
    private String data_validade;

    @NonNull
    private String descricao;

    @NonNull
    @Column(unique = true)
    private String barras;

    @NonNull
    @Column(nullable = false)
    private double peso;

    @NonNull
    @Column(nullable = false)
    private double medida;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Fabricante fabricante;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(nullable = false)
    private Categoria categoria;
}