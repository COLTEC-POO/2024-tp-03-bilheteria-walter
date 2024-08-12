package Eventos;

public class Teatro extends Evento {
    private final int quantIngressosInicio = 250;

    //Construtora
    public Teatro(String nome, String data, String hora, String local) {
        super(nome, data, hora, local, 250, 50);
    }

    //Métodos
    @Override
    public boolean verificarDisponibilidade(int quantidade, String tipoIngresso) {
        int limiteMeia = (int)(quantIngressosInicio * 0.2); // Calcula 10% do total de ingressos (que é 15 no caso)

        if (tipoIngresso.equals("Meia-Entrada") && getIngressosMeiaEntradaVendidos() + quantidade > limiteMeia)
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

            // Atualiza contadores somente se a venda for permitida
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
