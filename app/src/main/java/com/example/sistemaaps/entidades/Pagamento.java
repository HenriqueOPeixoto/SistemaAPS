package com.example.sistemaaps.entidades;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Random;

public class Pagamento implements Serializable {

    private int id;
    private double valor;
    private int metodoPagamento;
    private long dataHorario;

    public Pagamento(double valor, int metodoPagamento) {
        Random rng = new Random();
        this.id = rng.nextInt(1000000); // Gera um id aleatório ao instanciar o pgto
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.dataHorario = System.nanoTime();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(int metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public long getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(long dataHorario) {
        this.dataHorario = dataHorario;
    }

    @Override
    public String toString() {
        if (metodoPagamento == 0) {
            return String.format("Cartão (Débito) - R$%.2f", this.getValor());
        }

        return "Pagamento{" +
                "valor=" + valor +
                ", metodoPagamento=" + metodoPagamento +
                '}';
    }
}
