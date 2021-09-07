/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import model.Cliente;
import view.Util;
import view.Main;

/**
 *
 * @author brend
 */
public class AtendimentoApplication {

    private static ArrayList<Cliente> filaAtendimento = new ArrayList();

    public static ArrayList<Cliente> getFilaAtendimento() {
        return filaAtendimento;
    }

    public static void setFilaAtendimento(ArrayList<Cliente> filaAtendimento) {
        AtendimentoApplication.filaAtendimento = filaAtendimento;
    }

    //Inicia o atendimento do paciente
    public static void iniciarAtendimento() {
        try {
            System.out.println("\n========= INICIAR ATENDIMENTO =========");
            Cliente cliente = ClienteApplication.pesquisarCliente();
            if (cliente!=null) {
                Util.Sucesso("\nAtendimento do cliente " + cliente.getNome() + " iniciado.");
                cliente.setStatus("Aguardando triagem");
                LocalDate agora;
                agora = LocalDate.now();
                System.out.println(agora);
                cliente.setDate(agora);
                AtendimentoApplication.getFilaAtendimento().add(cliente);
                Collections.sort(AtendimentoApplication.getFilaAtendimento());
                
            } else {
                throw new Exception("\nCliente não encontrado.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }

    }

    //Alterar o Status do Paciente
    public static void alterarStatus() {
        try {

            System.out.println("\n========= ALTERAR STATUS =========");
            //Conferir se o paciente existe
            Cliente cliente = ClienteApplication.pesquisarCliente();

            if (cliente!=null) {
                Scanner sc = new Scanner(System.in);
                System.out.println("\nQual o novo status do paciente?"
                        + "\n1 - Aguardando triagem     2 - Aguardando Atendimento"
                        + "\n3 - Direcionado            4 - Liberado"
                        + "\n5 - Cancelar");
                int acesso = sc.nextInt();
                sc.nextLine();

                switch (acesso) {
                    case 1:
                        cliente.setStatus("Aguardando triagem");
                        Util.Sucesso("\nAlterado com sucesso");
                        break;
                    case 2:
                        cliente.setStatus("Aguardando Atendimento");
                        Util.Sucesso("\nAlterado com sucesso");
                        break;
                    case 3:
                        cliente.setStatus("Direcionado");
                        Util.Sucesso("\nAlterado com sucesso");
                        break;
                    case 4:
                        cliente.setStatus("Liberado");
                        Util.Sucesso("\nAlterado com sucesso");
                        break;
                    case 5:
                        break;
                    default:
                        Util.Erro("\nOpção invalida");
                }
            } else {
                throw new Exception("\nCliente não encontrado.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }

    }

    //Encerrar atendimento do paciente
    public static void encerrarAtendimento() {
        try {

            System.out.println("\n========= ENCERRAR ATENDIMENTO =========");

            //Conferir se o paciente existe
            Cliente cliente = ClienteApplication.pesquisarCliente();

            if (cliente!=null) {
                Util.Sucesso("\nAtendimento do cliente " + cliente.getNome() + " finalizado com sucesso.");
                cliente.setStatus("Liberado");
                for (int i = 0; i < AtendimentoApplication.getFilaAtendimento().size(); i++) {
                    if (cliente == AtendimentoApplication.getFilaAtendimento().get(i)) {
                        AtendimentoApplication.getFilaAtendimento().remove(AtendimentoApplication.getFilaAtendimento().get(i));
                        break;
                    }
                }
                cliente.setData(null);
                cliente.setIdTriagem(null);
            } else {
                throw new Exception("\nCliente não encontrado.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }
}
