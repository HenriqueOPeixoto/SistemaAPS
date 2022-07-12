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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PagamentoDebito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_debito);

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
                Pagamento pagamento = new Pagamento(
                        ocupacao.getConta().getValor(), 0
                );


                File file = new File(getFilesDir() + "/pagamentos.bin");
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    if (!file.exists()) file.createNewFile();

                    oos.writeObject(pagamento);

                    oos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(PagamentoDebito.this,
                        ProcessandoPagamento.class);
                intent.putExtra("Ocupacao", ocupacao);
                startActivity(intent);
            }
        });
    }
}