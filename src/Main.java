import Eventos.Concerto;
import Eventos.Filme;
import Eventos.Teatro;

import Ingressos.Meia;
import Ingressos.Normal;
import Ingressos.Vip;

public class Main {

    public static void main(String[] args){

        Concerto concerto = new Concerto("Concerto de Rock", "20/03/2023", "20:00", "Estádio do Rock");
        Filme filme = new Filme("Filme de Ação", "15/04/2023", "19:00", "Cinema 3D");
        Teatro teatro = new Teatro("Peça de Teatro", "10/05/2023", "21:00", "Teatro Municipal");

        Meia meia = new Meia("10/10/2007", 100);
        Normal normal = new Normal("29/10/2007", 100);
        Vip vip = new Vip("10/03/2011", 100);

        // Vendendo ingressos
        concerto.calcularValorTotal(160, "Normal");
        concerto.calcularValorTotal(15, "VIP");
        concerto.calcularValorTotal(150, "Meia-Entrada");
        filme.calcularValorTotal(20, "Normal");
        filme.calcularValorTotal(10, "VIP");
        filme.calcularValorTotal(15, "Meia-Entrada");
        teatro.calcularValorTotal(20, "Meia-Entrada");
        teatro.calcularValorTotal(10, "Normal");

        // Exibindo extratos
        concerto.exibirExtrato();
        filme.exibirExtrato();
        teatro.exibirExtrato();

        meia.exibirExtrato();
        normal.exibirExtrato();
        vip.exibirExtrato();

    }

}
