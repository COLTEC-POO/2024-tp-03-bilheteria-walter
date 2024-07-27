package Eventos;

abstract class Evento {

    //Variáveis
    protected String nome;
    protected String data;
    protected String hora;
    protected String local;
    protected int quant_ingressos;
    protected double preco_ingresso;

    //Construtora
    public Evento(String nome, String data, String hora, String local, int quant_ingressos, double preco_ingresso){
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.quant_ingressos = quant_ingressos;
        this.preco_ingresso = preco_ingresso;
    }

    //Getters
    public String getNome(){
        return nome;
    }

    public String getData(){
        return data;
    }

    public String getHora(){
        return hora;
    }

    public String getLocal(){
        return local;
    }

    public int getQuant_ingressos(){
        return quant_ingressos;
    }

    public double getPreco_ingresso(){
        return preco_ingresso;
    }

    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setData(String data){
        this.data = data;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public void setQuant_ingressos(int quant_ingressos){
        this.quant_ingressos = quant_ingressos;
    }

    public void setPreco_ingresso(double preco_ingresso){
        this.preco_ingresso = preco_ingresso;
    }

}
