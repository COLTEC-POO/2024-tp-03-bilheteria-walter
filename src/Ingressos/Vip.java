package Ingressos;

public class Vip extends Ingresso {
    public Vip(String data_venda, double valor) {
        super(data_venda, valor * 2); // Valor do ingresso VIP é o dobro do valor do ingresso normal
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();
        System.out.println("Tipo: Vip");
    }
}