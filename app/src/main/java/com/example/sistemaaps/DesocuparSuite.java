package com.example.sistemaaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sistemaaps.entidades.Ocupacao;
import com.example.sistemaaps.entidades.Pagamento;
import com.example.sistemaaps.utils.Cronometro;

import java.util.ArrayList;

public class DesocuparSuite extends AppCompatActivity {

    private ArrayList<Pagamento> pagamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desocupar_suite);

        this.pagamentos = new ArrayList<Pagamento>();

        Intent intent = getIntent();
        Ocupacao ocupacao = (Ocupacao) intent.getSerializableExtra("Ocupacao");

        TextView txtCronometro = (TextView) findViewById(R.id.txtTempoDecorrido);

        Cronometro cronometro = new Cronometro(ocupacao.getDataHorarioEntrada(), txtCronometro);
        cronometro.start();

        if (pagamentos.size() == 0) {
            TextView txtPagamentos = (TextView) findViewById(R.id.txtPagamentos);
            txtPagamentos.setVisibility(View.GONE);
        }

        Button btnNovoPgto = (Button) findViewById(R.id.btnNovoPagamento);
        btnNovoPgto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DesocuparSuite.this, NovoPagamento.class);
                intent.putExtra("Ocupacao", ocupacao);
                startActivity(intent);
            }
        });

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Voltar para a atividade anterior
            }
        });

        TextView txtValor = (TextView) findViewById(R.id.txtValor);
        txtValor.setText(String.format("R$%.2f",  ocupacao.getConta().getValor()));
    }
}