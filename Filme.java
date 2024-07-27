package Eventos;

public class Filme extends Evento{

    public Filme(String nome, String data, String hora, String local, double preco_ingresso){
        super(nome, data, hora, local, 200, preco_ingresso);
    }

}
