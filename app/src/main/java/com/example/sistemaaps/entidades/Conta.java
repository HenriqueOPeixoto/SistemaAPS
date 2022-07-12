package com.example.sistemaaps.entidades;

import java.io.Serializable;
import java.util.Random;

public class Conta implements Serializable {

    private int id;
    private double valor;
    private boolean paga;

    public Conta() {
        Random rng = new Random();

        this.id = rng.nextInt(1000000);
        this.valor = 60.0;
        this.paga = false;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }
}
