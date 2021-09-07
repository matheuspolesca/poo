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
            int busca = ClienteApplication.pesquisarCliente();
            //To do: lançar excessão quando o cliente já existe
            if (ClienteApplication.getClientes().get(busca).getStatus()!=null) {
                    throw new Exception("Cliente já esta na fila de atendimento.");
            }
            else if (busca >= 0) {
                Util.Sucesso("\nAtendimento do cliente " + ClienteApplication.getClientes().get(busca).getNome() + " iniciado.");
                Date agora = new Date();
                ClienteApplication.getClientes().get(busca).setData(agora);
                ClienteApplication.getClientes().get(busca).setStatus("Aguardando triagem");
                AtendimentoApplication.getFilaAtendimento().add(ClienteApplication.getClientes().get(busca));
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
            int busca = ClienteApplication.pesquisarCliente();

            if (busca >= 0) {
                Scanner sc = new Scanner(System.in);
                System.out.println("\nQual o novo status do paciente?"
                        + "\n1 - Aguardando triagem     2 - Aguardando Atendimento"
                        + "\n3 - Direcionado            4 - Liberado"
                        + "\n5 - Cancelar");
                int acesso = sc.nextInt();
                sc.nextLine();

                switch (acesso) {
                    case 1:
                        ClienteApplication.getClientes().get(busca).setStatus("Aguardando triagem");
                        Util.Sucesso("\nAlterado com sucesso");
                        break;
                    case 2:
                        ClienteApplication.getClientes().get(busca).setStatus("Aguardando Atendimento");
                        Util.Sucesso("\nAlterado com sucesso");
                        break;
                    case 3:
                        ClienteApplication.getClientes().get(busca).setStatus("Direcionado");
                        Util.Sucesso("\nAlterado com sucesso");
                        break;
                    case 4:
                        ClienteApplication.getClientes().get(busca).setStatus("Liberado");
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
            int busca = ClienteApplication.pesquisarCliente();

            if (busca >= 0) {
                Util.Sucesso("\nAtendimento do cliente " + ClienteApplication.getClientes().get(busca).getNome() + " finalizado com sucesso.");
                ClienteApplication.getClientes().get(busca).setStatus("Liberado");
                for (int i = 0; i < AtendimentoApplication.getFilaAtendimento().size(); i++) {
                    if (ClienteApplication.getClientes().get(busca) == AtendimentoApplication.getFilaAtendimento().get(i)) {
                        AtendimentoApplication.getFilaAtendimento().remove(AtendimentoApplication.getFilaAtendimento().get(i));
                        break;
                    }
                }
                ClienteApplication.getClientes().get(busca).setData(null);
                ClienteApplication.getClientes().get(busca).setIdTriagem(null);
            } else {
                throw new Exception("\nCliente não encontrado.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }
}
