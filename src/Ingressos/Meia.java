package Ingressos;

public class Meia extends Ingresso {
    public Meia(String data_venda, double valor) {
        super(data_venda, valor * 0.5); // Valor do ingresso de meia entrada é 50% do valor do ingresso normal
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();
        System.out.println("Tipo: Meia");
    }
}