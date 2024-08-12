package Eventos;

public class Concerto extends Evento {
    // Construtora
    private final int quantIngressosInicio = 150;

    public Concerto(String nome, String data, String hora, String local) {
        super(nome, data, hora, local, 150, 30);
    }

    // Métodos
    @Override
    public boolean verificarDisponibilidade(int quantidade, String tipoIngresso) {
        int limiteVip = (int)(quantIngressosInicio * 0.1); // Calcula 10% do total de ingressos (que é 15 no caso)

        if (tipoIngresso.equals("VIP") && getIngressosVipVendidos() + quantidade > limiteVip)
            return false;

        return getIngressosVendidos() + quantidade <= getQuant_ingressos();
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();
    }

    @Override
    public void venderIngresso(int quantidade, String tipo_ingresso) {
        if (verificarDisponibilidade(quantidade, tipo_ingresso)) {
            setIngressosVendidos(getIngressosVendidos() + quantidade);

            if (tipo_ingresso.equals("Normal")) {
                setIngressosNormaisVendidos(getIngressosNormaisVendidos() + quantidade);
            } else if (tipo_ingresso.equals("VIP")) {
                setIngressosVipVendidos(getIngressosVipVendidos() + quantidade);
            } else if (tipo_ingresso.equals("Meia-Entrada")) {
                setIngressosMeiaEntradaVendidos(getIngressosMeiaEntradaVendidos() + quantidade);
            }
        }
    }

    @Override
    public double calcularValorTotal(int quantidade, String tipo_ingresso) {
        return super.calcularValorTotal(quantidade, tipo_ingresso);
    }
}
