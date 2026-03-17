package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoResponseDTO {
    
    private String mensagem;
    private String nome;
    private double preco;
    private double precoFinal;
    private Integer estoque;

    // Construtor para facilitar a montagem da resposta no Service
    public ProdutoResponseDTO(String mensagem, String nome, double preco, double precoFinal, Integer estoque) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.preco = preco;
        this.precoFinal = precoFinal;
        this.estoque = estoque;
    }

    // Getters e Setters
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public double getPrecoFinal() { return precoFinal; }
    public void setPrecoFinal(double precoFinal) { this.precoFinal = precoFinal; }
    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}