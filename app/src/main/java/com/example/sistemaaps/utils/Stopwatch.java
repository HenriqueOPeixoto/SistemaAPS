package com.example.sistemaaps.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class Stopwatch implements Runnable {

    private long instantStart;
    private long timeElapsedNano = 0;
    private long timeElapsedSeconds = 0;
    private final TextView txtStopwatch;

    // Valores no formato do relógio
    private int clockSeconds;
    private int clockMinutes;
    private int clockHours;

    public Stopwatch(TextView txtStopwatch) {
        this.txtStopwatch = txtStopwatch;
    }

    public void start() {
        instantStart = System.nanoTime();
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            long instantNow = System.nanoTime();

            timeElapsedNano = instantNow - instantStart;
            timeElapsedSeconds = (int) getElapsedSeconds();

            this.setClockValues();

            /*
              Não é possível alterar um componente a partir de outra thread,
              sendo necessário rodar o setText() na thread da UI. O bloco
              abaixo acessa essa thread especial para fazer a atualização do
              componente.
             */
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    txtStopwatch.setText(Stopwatch.this.toString());
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

    public long getElapsedSeconds() {
        long nanoSecondsPerSecond = 1000000000;
        return timeElapsedNano / nanoSecondsPerSecond;
    }

    public void setClockValues() {
        int remainder;

        this.clockHours = (int) timeElapsedSeconds / 3600;
        remainder = (int) timeElapsedSeconds % 3600;

        this.clockMinutes = remainder / 60;
        this.clockSeconds = remainder % 60;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.clockHours, this.clockMinutes,
                this.clockSeconds);
    }

}
