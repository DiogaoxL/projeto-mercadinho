package org.example.modelo;

public class Produtos {
    private static int contador = 1;
    private int id;
    private String nome;
    private Double preco;

    public Produtos(String nome, Double preco) {
        this.id = contador++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto: " + this.getNome() +
                "\nPreço: R$" + this.getPreco();
    }
}
