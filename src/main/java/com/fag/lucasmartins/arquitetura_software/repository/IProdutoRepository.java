package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.model.Produto;

public interface IProdutoRepository {
    // Esse é o contrato. Qualquer banco de dados que a gente usar no futuro 
    // vai ser obrigado a ter esse método salvar.
    void salvar(Produto produto);
}