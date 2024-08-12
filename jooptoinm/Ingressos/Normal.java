package Ingressos;

public class Normal extends Ingresso {
    // Construtora
    public Normal(double preco) {
        super(preco);
    }

    // Métodos
    @Override
    public double calcularValor() {
        return preco;
    }

    @Override
    public double calcularReceita() {
        return calcularValor();
    }

    @Override
    public void exibirExtrato() {
        System.out.printf("Extrato do Ingresso Normal: Preço = %.2f\n", calcularValor());
    }
}
