package com.example.sistemaaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Suite suite = new Suite();
        Conta conta = new Conta();
        Ocupacao ocupacao = new Ocupacao(suite, conta);

        TextView txtTempoDecorrido = (TextView) findViewById(R.id.txtTempoDecorrido);

        Cronometro cronometro = new Cronometro(txtTempoDecorrido);
        cronometro.start();

        // Chamada da atividade de desocupação
        Button btnDesocuparSuite = (Button) findViewById(R.id.btnDesocupar);
        btnDesocuparSuite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DesocuparSuite.class));
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
}