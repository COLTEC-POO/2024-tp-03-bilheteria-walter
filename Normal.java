package Ingressos;

public class Normal extends Ingresso {

    public Normal(String data_venda, double valor){
        super(data_venda, valor);
        tipo_ingresso = "Normal";
    }

}
