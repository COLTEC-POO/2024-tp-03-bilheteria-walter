package Ingressos;

public class Meia extends Ingresso {
    // Construtora
    public Meia(double preco) {
        super(preco);
    }

    // Métodos
    @Override
    public double calcularValor() {
        return preco * 0.5;  // Valor do ingresso meia é metade do valor
    }

    @Override
    public double calcularReceita() {
        return calcularValor();
    }

    @Override
    public void exibirExtrato() {
        System.out.printf("Extrato do Ingresso Meia: Preço = %.2f\n", calcularValor());
    }
}
