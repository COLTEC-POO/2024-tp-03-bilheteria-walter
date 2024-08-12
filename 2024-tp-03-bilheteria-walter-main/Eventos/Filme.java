package Eventos;

public class Filme extends Evento {
    private final int quantIngressosInicio = 200;

    // Construtora
    public Filme(String nome, String data, String hora, String local) {
        super(nome, data, hora, local, 200, 79.99);
    }

    // Métodos
    @Override
    public boolean verificarDisponibilidade(int quantidade, String tipo_ingresso) {
        if (tipo_ingresso.equals("VIP")) {  // Caso seja VIP, não será permitida a venda de modo algum
            return false;
        }
        return getQuant_ingressos() >= quantidade;  // Caso contrário, será feita a verificação
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
