package Ingressos;

public class Vip extends Ingresso {

    public Vip(String data_venda, double valor){
        super(data_venda, valor * 2);
        tipo_ingresso = "Vip";
    }

}
