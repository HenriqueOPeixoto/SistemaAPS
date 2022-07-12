package com.example.sistemaaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sistemaaps.entidades.Ocupacao;
import com.example.sistemaaps.entidades.Pagamento;
import com.example.sistemaaps.utils.Cronometro;

import java.util.ArrayList;

public class NovoPagamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_pagamento);

        Intent intent = getIntent();
        Ocupacao ocupacao = (Ocupacao) intent.getSerializableExtra("Ocupacao");
        ArrayList<Pagamento> pagamentos = (ArrayList<Pagamento>)
                intent.getSerializableExtra("Pagamentos");

        Pagamento teste = new Pagamento(60.0, 0);

        pagamentos.add(teste);

        TextView txtTempoDecorrido = (TextView) findViewById(R.id.txtTempoDecorrido);

        Cronometro cronometro = new Cronometro(ocupacao.getDataHorarioEntrada(), txtTempoDecorrido);
        cronometro.start();

        Button btnNovoPagamento = (Button) findViewById(R.id.btnNovoPagamento);
        btnNovoPagamento.setEnabled(false);

        Button btnFinalizarPagamento = (Button) findViewById(R.id.btnFinalizarPagamento);
        btnFinalizarPagamento.setEnabled(false);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnDebito = (Button) findViewById(R.id.btnDebito);
        btnDebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NovoPagamento.this, PagamentoDebito.class);
                intent.putExtra("Ocupacao", ocupacao);
                startActivity(intent);
            }
        });
    }
}