package com.example.sistemaaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sistemaaps.utils.Cronometro;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtTempoDecorrido = (TextView) findViewById(R.id.txtTempoDecorrido);

        Cronometro cronometro = new Cronometro(txtTempoDecorrido);
        cronometro.start();
    }
}