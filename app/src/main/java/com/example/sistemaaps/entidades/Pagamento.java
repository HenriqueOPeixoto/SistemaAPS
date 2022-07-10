package com.example.sistemaaps.entidades;

import java.time.ZonedDateTime;
import java.util.Random;

public class Pagamento {

    private int id;
    private double valor;
    private int metodoPagamento;
    private ZonedDateTime dataHorario;

    public Pagamento() {
        Random rng = new Random();
        this.id = rng.nextInt(1000000); // Gera um id aleatório ao instanciar o pgto
    }
}
