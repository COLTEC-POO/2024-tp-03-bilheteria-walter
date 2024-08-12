package Ingressos;

public class Normal extends Ingresso {
    public Normal(String data_venda, double valor) {
        super(data_venda, valor); // Valor do ingresso normal
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();
        System.out.println("Tipo: Normal");
    }
}