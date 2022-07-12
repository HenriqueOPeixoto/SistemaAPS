package com.example.sistemaaps.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import java.io.Serializable;

public class Cronometro implements Runnable {

    private long instanteInicio;
    private long tempoDecorridoNano = 0;
    private long tempoDecorridoSegundos = 0;
    private final TextView txtCronometro;

    // Valores no formato do relógio
    private int relogioSegundos;
    private int relogioMinutos;
    private int relogioHoras;

    public Cronometro(long instanteInicio, TextView txtCronometro) {
        this.txtCronometro = txtCronometro;
        this.instanteInicio = instanteInicio;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            long instanteAgora = System.nanoTime();

            tempoDecorridoNano = instanteAgora - instanteInicio;
            tempoDecorridoSegundos = (int) getTempoDecorridoSegundos();

            this.setValoresRelogio();

            /*
              Não é possível alterar um componente a partir de outra thread,
              sendo necessário rodar o setText() na thread da UI. O bloco
              abaixo acessa essa thread especial para fazer a atualização do
              componente.
             */
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    txtCronometro.setText(Cronometro.this.toString());
                }
            });

            /*
              Isso é para impedir o timer de ser calculado a cada frame,
              pois isso exige muito da CPU.
              Só é necessário atualizar o timer a cada segundo.
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public long getTempoDecorridoSegundos() {
        long nanosegundosPorSegundo = 1000000000;
        return tempoDecorridoNano / nanosegundosPorSegundo;
    }

    public void setValoresRelogio() {
        int resto;

        this.relogioHoras = (int) tempoDecorridoSegundos / 3600;
        resto = (int) tempoDecorridoSegundos % 3600;

        this.relogioMinutos = resto / 60;
        this.relogioSegundos = resto % 60;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.relogioHoras, this.relogioMinutos,
                this.relogioSegundos);
    }

}
