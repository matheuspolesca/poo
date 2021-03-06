/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Cliente;
import view.Util;
import view.Main;

/**
 *
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 */
public class AtendimentoApplication {

    private static ArrayList<Cliente> filaAtendimento = new ArrayList();

    /**
     * Obtém a fila de atendimento
     * @return ArrayList
     */
    public static ArrayList<Cliente> getFilaAtendimento() {
        return filaAtendimento;
    }

    /**
     * Define a fila de atendimento
     * @param filaAtendimento
     */
    public static void setFilaAtendimento(ArrayList<Cliente> filaAtendimento) {
        AtendimentoApplication.filaAtendimento = filaAtendimento;
    }


    /**
     * Método responsável por iniciar o atendimento
     */
    public static void iniciarAtendimento() {
        try {
            System.out.println("\n========= INICIAR ATENDIMENTO =========");
            Cliente cliente = ClienteApplication.pesquisarCliente();
            //To do: lançar excessão quando o cliente já existe
            if (cliente!=null) {
                if (cliente.getStatus()!=null){
                    throw new Exception("Cliente já esta na fila de atendimento.");
                }
                
                Util.Sucesso("\nAtendimento do cliente " + cliente.getNome() + " iniciado.");
                Date agora = new Date();
                cliente.setData(agora);
                cliente.setStatus("Aguardando triagem");
                AtendimentoApplication.getFilaAtendimento().add(cliente);
            } else {
                throw new Exception("\nCliente não encontrado.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }

    }

    //Alterar o Status do Paciente

    /**
     * Método responsável por alterar o status do paciente
     */
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
                        Util.Sucesso("\nAlterado com sucesso - Paciente aguardando triagem");
                        break;
                    case 2:
                        cliente.setStatus("Aguardando Atendimento");
                        Util.Sucesso("\nAlterado com sucesso - Paciente aguardando atendimento");
                        break;
                    case 3:
                        cliente.setStatus("Direcionado");
                        Util.Sucesso("\nAlterado com sucesso - Paciente direcionado");
                        break;
                    case 4:
                        cliente.setStatus("Liberado");
                        Util.Sucesso("\nAlterado com sucesso - Paciente liberado");
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

    /**
     * Método responsável por encerrar o atendimento
     */
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
