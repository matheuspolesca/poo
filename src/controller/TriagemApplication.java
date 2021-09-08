/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import model.Cliente;
import model.IdTriagem;
import view.Main;
import view.Util;

/**
 *
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 */
public class TriagemApplication {

    /**
     * Altera o id de triagem de um cliente
     * @param cliente
     */
    public static void alterarIdTriagem(Cliente cliente) {
        try {
            if ("Enfermeiro".equals(Main.getProfissao()) || "Administrador".equals(Main.getProfissao())) {
                if(cliente.getData()==null){
                    throw new Exception("O atendimento ao cliente não foi iniciado.");
                }
                System.out.println("\n========= ALTERAR IDTRIAGEM =========");
                Scanner sc = new Scanner(System.in);
                System.out.println("\nDigite o número referente ao nova Id de Triagem:"
                        + "\n1 - Vermelha       2 - Amarela       3 - Verde");
                int acesso = sc.nextInt();
                sc.nextLine();

                switch (acesso) {
                    case 1:
                        cliente.setIdTriagem(IdTriagem.VERMELHO);
                        cliente.setStatus("Aguardando atendimento");
                        for (int i = 0; i < AtendimentoApplication.getFilaAtendimento().size(); i++) {
                            if (cliente == AtendimentoApplication.getFilaAtendimento().get(i)) {
                                AtendimentoApplication.getFilaAtendimento().get(i).setIdTriagem(IdTriagem.VERMELHO);
                                AtendimentoApplication.getFilaAtendimento().get(i).setStatus("Aguardando atendimento");
                                break;
                            }
                        }
                        Util.Sucesso("\nAlterado com sucesso.");
                        break;
                    case 2:
                        cliente.setIdTriagem(IdTriagem.AMARELO);
                        cliente.setStatus("Aguardando atendimento");
                        for (int i = 0; i < AtendimentoApplication.getFilaAtendimento().size(); i++) {
                            if (cliente == AtendimentoApplication.getFilaAtendimento().get(i)) {
                                AtendimentoApplication.getFilaAtendimento().get(i).setIdTriagem(IdTriagem.AMARELO);
                                AtendimentoApplication.getFilaAtendimento().get(i).setStatus("Aguardando atendimento");
                                break;
                            }
                        }
                        Util.Sucesso("\nAlterado com sucesso.");
                        break;
                    case 3:
                        cliente.setIdTriagem(IdTriagem.VERDE);
                        cliente.setStatus("Aguardando atendimento");
                        for (int i = 0; i < AtendimentoApplication.getFilaAtendimento().size(); i++) {
                            if (cliente == AtendimentoApplication.getFilaAtendimento().get(i)) {
                                AtendimentoApplication.getFilaAtendimento().get(i).setIdTriagem(IdTriagem.VERDE);
                                AtendimentoApplication.getFilaAtendimento().get(i).setStatus("Aguardando atendimento");
                                break;
                            }
                        }
                        Util.Sucesso("\nAlterado com sucesso.");
                        break;
                    case 4:
                        break;
                    default:
                        Util.Erro("\nOpção invalido.");
                }
            } else {
                throw new Exception("\nVocê não tem permissão para acessar essa opção.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }
}
