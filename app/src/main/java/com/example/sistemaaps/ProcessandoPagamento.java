package com.example.sistemaaps;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

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

        TextView txtProgresso = (TextView) findViewById(R.id.txtProgresso);

        /*
            As linhas abaixo são reponsáveis pela animação da tela de processamento.
         */
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                txtProgresso.setText("Insira seu cartão na máquina\nAguardando Pagamento...");
            }
        }, 3000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                txtProgresso.setText("Pagamento confirmado!");
            }
        }, 8000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 12000);

    }
}