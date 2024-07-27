package Ingressos;

public class Meia extends Ingresso {

    public Meia(String data_venda, double valor){
        super(data_venda, valor / 2);
        tipo_ingresso = "Meia-Entrada";
    }

}
