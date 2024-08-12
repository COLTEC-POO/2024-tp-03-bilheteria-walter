package Ingressos;

import Eventos.RelatorioReceita;

public abstract class Ingresso implements RelatorioReceita {
    protected double preco;

    // Construtora
    public Ingresso(double preco) {
        this.preco = preco;
    }

    // Métodos
    public abstract double calcularValor();  // Método abstrato para calcular valor
}
