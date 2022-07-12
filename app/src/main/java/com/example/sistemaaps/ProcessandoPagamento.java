package com.example.sistemaaps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sistemaaps.entidades.Ocupacao;
import com.example.sistemaaps.utils.Cronometro;

import org.w3c.dom.Text;

public class ProcessandoPagamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processando_pagamento);

        Intent intent = getIntent();
        Ocupacao ocupacao = (Ocupacao) intent.getSerializableExtra("Ocupacao");

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

        TextView txtProgresso = (TextView) findViewById(R.id.txtProgresso);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

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
                progressBar.setVisibility(View.GONE);
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