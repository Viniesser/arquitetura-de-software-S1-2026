package com.fag.lucasmartins.arquitetura_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/checkout")
    public ResponseEntity<Object> realizarPedido(@RequestBody Map<String, Object> payload) {
        try {
            Integer usuarioId = (Integer) payload.get("usuarioId");
            Integer restauranteId = (Integer) payload.get("restauranteId");
            List<Map<String, Object>> itens = (List<Map<String, Object>>) payload.get("itens");

            double valorTotal = 0.0;

            for (Map<String, Object> item : itens) {
                Integer produtoId = (Integer) item.get("produtoId");
                Integer quantidade = (Integer) item.get("quantidade");

                String sqlPreco = "SELECT preco FROM produtos WHERE id = ?";
                Map<String, Object> produtoDb = jdbcTemplate.queryForMap(sqlPreco, produtoId);
                double preco = (double) produtoDb.get("preco");

                valorTotal += (preco * quantidade);

                jdbcTemplate.update("UPDATE produtos SET estoque = estoque - ? WHERE id = ?", quantidade, produtoId);
            }

            String sqlInsertPedido = "INSERT INTO pedidos (usuario_id, restaurante_id, valor_total, status) VALUES (?, ?, ?, 'CRIADO')";
            jdbcTemplate.update(sqlInsertPedido, usuarioId, restauranteId, valorTotal);

            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Pedido realizado com sucesso!");
            response.put("valorTotal", valorTotal);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar requisição: " + e.getMessage());
        }
    }
}