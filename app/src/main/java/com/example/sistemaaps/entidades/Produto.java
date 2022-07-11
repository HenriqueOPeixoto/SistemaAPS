package com.example.sistemaaps.entidades;

import java.util.Random;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private int qtdEstoque;

    public Produto() {
        Random rng = new Random();
        this.id = rng.nextInt(1000000); // Gera um id aleatório ao instanciar o produto
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
