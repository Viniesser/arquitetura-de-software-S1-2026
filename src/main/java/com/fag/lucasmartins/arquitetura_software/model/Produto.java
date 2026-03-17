package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private double precoFinal;
    private Integer estoque;

    // Construtor: Aqui o produto já nasce "inteligente" e calcula o próprio desconto
    public Produto(String nome, double preco, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.precoFinal = calcularPrecoFinal(preco, estoque);
    }

    // Regra 1: Valida se o produto premium está com o preço correto
    public boolean isPremiumValido() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
            return this.preco >= 100.0;
        }
        return true; // Se não for premium, passa direto
    }

    // Regra 2: Calcula o desconto de 10% para atacado (50 ou mais no estoque)
    private double calcularPrecoFinal(double precoBase, Integer qtdEstoque) {
        if (qtdEstoque != null && qtdEstoque >= 50) {
            return precoBase - (precoBase * 0.10);
        }
        return precoBase;
    }

    // Getters para acessar os valores
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public double getPrecoFinal() { return precoFinal; }
    public Integer getEstoque() { return estoque; }
}