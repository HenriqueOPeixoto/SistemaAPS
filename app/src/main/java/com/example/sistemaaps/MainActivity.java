package com.example.sistemaaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sistemaaps.entidades.Conta;
import com.example.sistemaaps.entidades.Ocupacao;
import com.example.sistemaaps.entidades.Suite;
import com.example.sistemaaps.utils.Cronometro;

public class MainActivity extends AppCompatActivity {

    private Ocupacao ocupacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Suite suite = new Suite();
        Conta conta = new Conta();
        this.ocupacao = new Ocupacao(suite, conta);

        TextView txtTempoDecorrido = (TextView) findViewById(R.id.txtTempoDecorrido);

        Cronometro cronometro = new Cronometro(ocupacao.getDataHorarioEntrada(), txtTempoDecorrido);
        cronometro.start();

        // Chamada da atividade de desocupação
        Button btnDesocuparSuite = (Button) findViewById(R.id.btnDesocupar);
        btnDesocuparSuite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DesocuparSuite.class);
                intent.putExtra("Ocupacao", MainActivity.this.ocupacao);
                startActivity(intent);
            }
        });

        // Chamada da atividade de fazer pedido
        Button btnFazerPedido = (Button) findViewById(R.id.btnPedido);
        btnFazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FazerPedido.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ocupacao.getConta().isPaga()) {
            TextView txtTempoDecorridoDesc = (TextView) findViewById(R.id.txtTempoDecorridoDesc);
            txtTempoDecorridoDesc.setText("A suíte está desocupada");

            TextView txtTempoDecorrido = (TextView) findViewById(R.id.txtTempoDecorrido);
            txtTempoDecorrido.setVisibility(View.GONE);

            Button btnFazerPedido = (Button) findViewById(R.id.btnPedido);
            btnFazerPedido.setEnabled(false);
            btnFazerPedido.setBackgroundColor(Color.GRAY);

            Button btnDesocupar = (Button) findViewById(R.id.btnDesocupar);
            btnDesocupar.setEnabled(false);
            btnFazerPedido.setBackgroundColor(Color.GRAY);
        }
    }
}