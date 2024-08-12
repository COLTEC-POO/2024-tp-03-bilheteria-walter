// chat gpt ensina
import javax.swing.*;
// nao
import Eventos.Concerto;
// sei
import Eventos.Filme;
// importar
import Eventos.Teatro;
import Eventos.Evento;

public class Main {
    public static void main(String[] args) {
        Evento evento = null;
        boolean continuar = true;

        while (continuar) {
            // Opções de eventos
            String[] opcoesEventos = {"Concerto", "Filme", "Teatro", "Sair"};

            // Exibindo uma caixa de diálogo para escolher o evento
            int escolhaEvento = JOptionPane.showOptionDialog(null,
                    "Escolha o tipo de evento:",
                    "Seleção de Evento",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcoesEventos, opcoesEventos[0]);

            if (escolhaEvento == 0) {
                evento = new Concerto("Concerto de Rock", "20/03/2023", "20:00", "Estádio do Rock");
            } else if (escolhaEvento == 1) {
                evento = new Filme("Filme de Ação", "15/04/2023", "19:00", "Cinema 3D");
            } else if (escolhaEvento == 2) {
                evento = new Teatro("Peça de Teatro", "10/05/2023", "21:00", "Teatro Municipal");
            } else if (escolhaEvento == 3) {
                continuar = false;
                break;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Opção inválida. Por favor, selecione um evento.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Compra
            boolean comprarMaisIngressos = true;

            while (comprarMaisIngressos) {
                // Tipos de ingressos
                String[] opcoesIngressos = {"Normal", "VIP", "Meia-Entrada"};

                // jay opition n sei
                int escolhaIngresso = JOptionPane.showOptionDialog(null,
                        "Escolha o tipo de ingresso:",
                        "Compra de Ingresso",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, opcoesIngressos, opcoesIngressos[0]);

                if (escolhaIngresso >= 0 && escolhaIngresso < opcoesIngressos.length) {
                    String tipoIngresso = opcoesIngressos[escolhaIngresso];


                    String quantidadeString = JOptionPane.showInputDialog(null,
                            "Quantos ingressos " + tipoIngresso + " deseja comprar?",
                            "Quantidade de Ingressos",
                            JOptionPane.QUESTION_MESSAGE);

                    try {
                        int quantidade = Integer.parseInt(quantidadeString);

                        // Verificando a disponibilidade `>´
                        if (evento.verificarDisponibilidade(quantidade, tipoIngresso)) {
                            double total = evento.calcularValorTotal(quantidade, tipoIngresso);
                            evento.venderIngresso(quantidade, tipoIngresso);

                            JOptionPane.showMessageDialog(null,
                                    "Compra realizada com sucesso!\n" +
                                            "Evento: " + evento.getNome() + "\n" +
                                            "Tipo de ingresso: " + tipoIngresso + "\n" +
                                            "Quantidade: " + quantidade + "\n" +
                                            "Total: R$ " + String.format("%.2f", total),
                                    "Confirmação de Compra",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Quantidade indisponível. Por favor, tente novamente.",
                                    "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Entrada inválida. Por favor, insira um número válido.",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nenhuma opção de ingresso selecionada. Operação cancelada.",
                            "Cancelamento",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                // Perguntando se o usuário deseja comprar mais ingressos para o mesmo evento
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Deseja comprar mais ingressos para este evento?",
                        "Continuar Compra",
                        JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.NO_OPTION) {
                    comprarMaisIngressos = false;
                }
            }

            // Exibindo o extrato
            evento.exibirExtrato();
        }

        JOptionPane.showMessageDialog(null,
                "Obrigado por usar o sistema de venda de ingressos.",
                "Encerramento",
                JOptionPane.INFORMATION_MESSAGE);
    }
}