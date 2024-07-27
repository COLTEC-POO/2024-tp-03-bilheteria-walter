package Ingressos;

abstract class Ingresso {

    //Variáveis
    protected String data_venda;
    protected String tipo_ingresso;
    protected double valor;

    //Construtora
    public Ingresso(String data_venda, double valor){
        this.data_venda = data_venda;
        this.valor = valor;
    }

    //Getters
    public String getData_venda(){
        return data_venda;
    }

    public String getTipo_ingresso(){
        return tipo_ingresso;
    }

    public double getValor(){
        return valor;
    }

    //Setters
    public void setData_venda(String data_venda){
        this.data_venda = data_venda;
    }

    public void setTipo_ingresso(String tipo_ingresso){
        this.tipo_ingresso = tipo_ingresso;
    }

    public void setValor(double valor){
            this.valor = valor;
        }

}
