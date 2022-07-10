package com.example.sistemaaps.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class Stopwatch implements Runnable {

    private final long nanoSecondsPerMillisecond = 1000000;
    private final long nanoSecondsPerSecond = 1000000000;
    private final long nanoSecondsPerMinute = 60000000000L;
    private final long nanoSecondsPerHour = 3600000000000L;

    private long instantStart;
    private long instantNow;
    private long timeElapsedNano = 0;
    private TextView txtStopwatch;
    private Thread thread;

    public Stopwatch(TextView txtStopwatch) {
        this.txtStopwatch = txtStopwatch;
    }

    public void start() {
        instantStart = System.nanoTime();
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void run() {
        while (true) {
            instantNow = System.nanoTime();

            timeElapsedNano = instantNow - instantStart;

            /**
             * Não é possível alterar um componente a partir de outra thread,
             * sendo necessário rodar o setText() na thread da UI. O bloco
             * abaixo acessa essa thread especial para fazer a atualização do
             * componente.
             */
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    txtStopwatch.setText("" + timeElapsedNano);
                }
            });

        }
    }

    public long getElapsedSeconds() {
        return timeElapsedNano / nanoSecondsPerSecond;
    }

}
