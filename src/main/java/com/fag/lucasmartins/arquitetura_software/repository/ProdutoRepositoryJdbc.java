package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // Avisa o Spring que é aqui que a gente mexe com o banco de dados
public class ProdutoRepositoryJdbc implements IProdutoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void salvar(Produto produto) {
        // Pega os dados do produto já calculados e joga no banco (H2)
        String sqlInsert = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsert, produto.getNome(), produto.getPreco(), produto.getPrecoFinal(), produto.getEstoque());
    }
}