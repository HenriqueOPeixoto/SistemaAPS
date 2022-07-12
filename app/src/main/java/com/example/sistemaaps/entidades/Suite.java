package com.example.sistemaaps.entidades;

import java.io.Serializable;
import java.util.Random;

public class Suite implements Serializable {

    private int id;
    private boolean ocupado;
    private boolean limpo;

    public Suite() {
        Random rng = new Random();

        this.id = rng.nextInt(1000000);
        this.ocupado = false;
        this.limpo = true;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }
}
