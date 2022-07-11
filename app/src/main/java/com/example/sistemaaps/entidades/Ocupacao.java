package com.example.sistemaaps.entidades;

import java.util.Random;

public class Ocupacao {

    private int id;
    private long dataHorarioEntrada;
    private Suite suite;
    private Conta conta;

    public Ocupacao(Suite suite, Conta conta) {
        Random rng = new Random();

        this.id = rng.nextInt(1000000);
        this.suite = suite;
        this.dataHorarioEntrada = System.nanoTime();
        this.conta = conta;
    }
}