package Ingressos;

public class Vip extends Ingresso {
    // Construtora
    public Vip(double preco) {
        super(preco);
    }

    // Métodos
    @Override
    public double calcularValor() {
        return preco * 2;  // Valor do ingresso VIP é o dobro do valor
    }

    @Override
    public double calcularReceita() {
        return calcularValor();
    }

    @Override
    public void exibirExtrato() {
        System.out.printf("Extrato do Ingresso VIP: Preço = %.2f\n", calcularValor());
    }
}
