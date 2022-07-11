package com.example.sistemaaps.entidades;

import java.util.Random;

public class Item {
    private int id;
    private Produto produto;
    private int qtd;

    public Item(Produto produto, int qtd) {
        Random rng = new Random();
        this.id = rng.nextInt(1000000); // Gera um id aleatório ao instanciar o item

        this.produto = produto;
        this.qtd = qtd;
    }
}
