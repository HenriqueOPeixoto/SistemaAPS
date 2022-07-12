package com.example.sistemaaps.entidades;

import java.io.Serializable;
import java.util.Random;

public class Conta implements Serializable {

    private int id;
    private double valor;

    public Conta() {
        Random rng = new Random();

        this.id = rng.nextInt(1000000);
        this.valor = 60.0;
    }

}
