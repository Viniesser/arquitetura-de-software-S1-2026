package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    // Injetando a interface do repositório para não acoplar com o banco (DIP)
    @Autowired
    private IProdutoRepository produtoRepository; 

    public ProdutoResponseDTO processarCadastro(ProdutoRequestDTO request) {
        
        // Cria o objeto Produto. Como ele é um "modelo rico", 
        // ele mesmo já calcula o desconto de atacado lá dentro do construtor.
        Produto produto = new Produto(request.getNome(), request.getPreco(), request.getEstoque());

        // Verifica a regra do produto premium (não pode custar menos de 100)
        if (!produto.isPremiumValido()) {
            throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
        }

        // Tudo certo, manda salvar no banco
        produtoRepository.salvar(produto);

        // Monta o DTO de resposta para devolver pro Controller com os dados finais
        return new ProdutoResponseDTO(
            "Produto cadastrado com sucesso!",
            produto.getNome(),
            produto.getPreco(),
            produto.getPrecoFinal(),
            produto.getEstoque()
        );
    }
}