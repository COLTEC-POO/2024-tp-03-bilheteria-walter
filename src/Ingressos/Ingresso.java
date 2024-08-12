package Ingressos;

public abstract class Ingresso implements RelatorioReceita{
    //Atributos comuns de Ingresso
    private String data_venda;
    private double valor;

    //Construtora
    public Ingresso(String data_venda, double valor) {
        this.data_venda = data_venda;
        this.valor = valor;
    }

    //Getters
    public String getDataVenda() {
        return data_venda;
    }

    public double getValor() {
        return valor;
    }

    //Métodos
    @Override
    public void exibirExtrato(){
        System.out.println();
        System.out.println("Data de Venda: " + getDataVenda());
        System.out.println("Valor: " + getValor());
    }
}