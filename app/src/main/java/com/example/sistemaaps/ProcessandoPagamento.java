package com.example.sistemaaps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProcessandoPagamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processando_pagamento);

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
    }
}