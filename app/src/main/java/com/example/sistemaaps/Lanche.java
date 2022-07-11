package com.example.sistemaaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lanche extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanche);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Voltar para a atividade anterior
            }
        });

        // Definicao dos botoes das categorias

        /*
        Button btnRefeicao = (Button) findViewById(R.id.btnRefeicao);
        btnRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FazerPedido.this, Refeicao.class));
            }
        });

        Button btnSobremesa = (Button) findViewById(R.id.btnSobremesa);
        btnSobremesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FazerPedido.this, Sobremesa.class));
            }
        });

        Button btnBebidas = (Button) findViewById(R.id.btnBebidas);
        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FazerPedido.this, Bebidas.class));
            }
        });
        */

        /*
        // Botao do carrinho de compra
        Button btnCarrinho = (Button) findViewById(R.id.btnCarrinho);
        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FazerPedido.this, Carrinho.class));
            }
        });
        /*
         */
    }
}