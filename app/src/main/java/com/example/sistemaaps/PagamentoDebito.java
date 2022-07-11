package com.example.sistemaaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PagamentoDebito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_debito);

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

        TextView txtMoeda = (TextView) findViewById(R.id.txtMoeda);
        txtMoeda.setVisibility(View.GONE);

        TextView txtFieldParcial = (TextView) findViewById(R.id.txtFieldParcial);
        txtFieldParcial.setVisibility(View.GONE);

        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        btnConfirmar.setVisibility(View.GONE);

        Button btnParcial = (Button) findViewById(R.id.btnParcial);
        btnParcial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMoeda.setVisibility(View.VISIBLE);
                txtFieldParcial.setVisibility(View.VISIBLE);
                btnConfirmar.setVisibility(View.VISIBLE);
            }
        });

        Button btnTotal = (Button) findViewById(R.id.btnTotal);
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PagamentoDebito.this,
                        ProcessandoPagamento.class));
            }
        });
    }
}