package Eventos;

public abstract class Evento implements RelatorioReceita{
    //Atributos
    private String nome;
    private String data;
    private String hora;
    private String local;
    int quant_ingressos;
    private double preco_ingresso;
    private int ingressosVendidos;
    private int ingressosNormaisVendidos;
    private int ingressosVipVendidos;
    private int ingressosMeiaEntradaVendidos;

    //Construtora
    public Evento(String nome, String data, String hora, String local, int quant_ingressos, double preco_ingresso) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.quant_ingressos = quant_ingressos;
        this.preco_ingresso = preco_ingresso;
        this.ingressosVendidos = 0;
        this.ingressosNormaisVendidos = 0;
        this.ingressosVipVendidos = 0;
        this.ingressosMeiaEntradaVendidos = 0;
    }

    //Getters
    public int getQuant_ingressos() {
        return quant_ingressos;
    }

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public int getIngressosNormaisVendidos(){
        return ingressosNormaisVendidos;
    }

    public int getIngressosVipVendidos() {
        return ingressosVipVendidos;
    }

    public int getIngressosMeiaEntradaVendidos() {
        return ingressosMeiaEntradaVendidos;
    }

    //Setters
    public void setIngressosVendidos(int ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }

    public void setIngressosNormaisVendidos(int ingressosNormaisVendidos) {
        this.ingressosNormaisVendidos = ingressosNormaisVendidos;
    }

    public void setIngressosVipVendidos(int ingressosVipVendidos) {
        this.ingressosVipVendidos = ingressosVipVendidos;
    }

    public void setIngressosMeiaEntradaVendidos(int ingressosMeiaEntradaVendidos) {
        this.ingressosMeiaEntradaVendidos = ingressosMeiaEntradaVendidos;
    }

    //Métodos com Override
    @Override
    public double calcularReceita() {
        double totalNormal = ingressosNormaisVendidos * preco_ingresso;
        double totalVip = ingressosVipVendidos * preco_ingresso * 2;
        double totalMeia = ingressosMeiaEntradaVendidos * preco_ingresso * 0.5;

        return totalNormal + totalVip + totalMeia;
    }

    @Override
    public void exibirExtrato(){
        System.out.println();
        System.out.println("Extrato do Evento:");
        System.out.println("Nome: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
        System.out.println("Local: " + local);
        System.out.println("Preço do Ingresso: " + preco_ingresso);
        System.out.println("Quantidade de Ingressos: " + quant_ingressos);
        System.out.println("Total de Ingressos Vendidos: " + ingressosVendidos);
        System.out.printf("Total de Ingresssos disponiveis: %d\n", quant_ingressos - ingressosVendidos);
        System.out.println("Ingressos Normais Vendidos: " + ingressosNormaisVendidos);
        System.out.println("Ingressos VIP Vendidos: " + ingressosVipVendidos);
        System.out.println("Ingressos Meia Entrada Vendidos: " + ingressosMeiaEntradaVendidos);
        System.out.println("Receita Total: " + calcularReceita());
        System.out.println("Valor Total dos Ingressos Normais: " + calcularValorTotal(ingressosNormaisVendidos, "Normal"));
        System.out.println("Valor Total dos Ingressos VIP: " + calcularValorTotal(ingressosVipVendidos, "VIP"));
        System.out.println("Valor Total dos Ingressos Meia Entrada: " + calcularValorTotal(ingressosMeiaEntradaVendidos, "Meia-Entrada"));
        System.out.println();
    }

    //Métodos
    public boolean verificarDisponibilidade(int quantidade, String tipo_ingresso){
        int quantidadeDisponivel = quant_ingressos - ingressosVendidos;

        return quantidadeDisponivel >= quantidade;
    }

    public void venderIngresso(int quantidade, String tipo_ingresso) {
        if (verificarDisponibilidade(quantidade, tipo_ingresso)) {  //Verificando se essa quantidade de ingressos de um tipo específico, está disponível
            ingressosVendidos += quantidade;  //Caso esteja disponível, a venda será realizada

            if(tipo_ingresso.equals("Normal")){  //Caso seja normal, será acumulado em um contador para o calculo final de ingressos Normais
                ingressosNormaisVendidos += quantidade;
            } else if (tipo_ingresso.equals("VIP")) {  //Caso seja vip, será acumulado em um contador para o calculo final de ingressos VIP
                ingressosVipVendidos += quantidade;
            } else if (tipo_ingresso.equals("MeiaEntrada")) {  //Caso seja meia, será acumulado em um contador para o calculo final de ingressos Meia
                ingressosMeiaEntradaVendidos += quantidade;
            }
        }
    }

    public double calcularValorTotal(int quantidade, String tipo_ingresso) {
        venderIngresso(quantidade, tipo_ingresso);  //Caso realmente estejam disponíveis os ingressos, será realizada a venda

        if (tipo_ingresso.equals("VIP")) {  //Calculando o total caso seja VIP
            return quantidade * preco_ingresso * 2;
        } else if (tipo_ingresso.equals("Meia-Entrada")) {  //Calculando o total caso seja Meia
            return quantidade * preco_ingresso * 0.5;
        } else {  //Calculando o total caso seja Normal
            return quantidade * preco_ingresso;
        }
    }
}