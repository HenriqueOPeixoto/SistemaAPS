package com.example.sistemaaps;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
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
                /*
                Intent intent = new Intent(MainActivity.this, DesocuparSuite.class);
                intent.putExtra("Ocupacao", MainActivity.this.ocupacao);
                startActivity(intent);
                 */

                Intent intent = new Intent(MainActivity.this, DesocuparSuite.class);
                intent.putExtra("Ocupacao", MainActivity.this.ocupacao);
                startActivityForResult(intent, 0);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Ocupacao ocupacao = (Ocupacao) data.getSerializableExtra("OcupacaoResult");

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
            btnDesocupar.setBackgroundColor(Color.GRAY);
        }
    }
}