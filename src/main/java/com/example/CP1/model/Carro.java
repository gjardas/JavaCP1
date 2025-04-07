package com.example.CP1.model;

import jakarta.persistence.*;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private int ano;
    private double potencia;
    private double economia;
    private String tipo;
    private double preco;

    public Carro() {} // Construtor padrão obrigatório para JPA

    // ✅ Construtor com argumentos (opcional, útil nos testes)
    public Carro(String marca, String modelo, int ano, double potencia, double economia, String tipo, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
        this.economia = economia;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Long getId() { return id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getPotencia() { return potencia; }
    public void setPotencia(double potencia) { this.potencia = potencia; }

    public double getEconomia() { return economia; }
    public void setEconomia(double economia) { this.economia = economia; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
