package Eventos;

public class Teatro extends Evento {
    private final int quantIngressosInicio = 250;

    // Construtora
    public Teatro(String nome, String data, String hora, String local) {
        super(nome, data, hora, local, 250, 50);
    }

    // Métodos
    @Override
    public boolean verificarDisponibilidade(int quantidade, String tipo_ingresso) {
        return getQuant_ingressos() >= quantidade;  // No caso de teatro, não tem nenhuma verificação adicional
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
