package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoRequestDTO {
    
    private String nome;
    private double preco;
    private Integer estoque;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}