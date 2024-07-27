package Eventos;

public class Concerto extends Evento{

    public Concerto(String nome, String data, String hora, String local, double preco_ingresso){
        super(nome, data, hora, local, 150, preco_ingresso);
    }

}
