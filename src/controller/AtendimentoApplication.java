/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.Cliente;
import projetohospital.Util;
import projetohospital.Main;

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
    
    public static void iniciarAtendimento() {

        System.out.println("\n========= INICIAR ATENDIMENTO =========");
        int busca = ClienteApplication.pesquisarCliente();

        try {
            if (busca >= 0) {
                Util.Sucesso("\nAtendimento do cliente " +ClienteApplication.getClientes().get(busca).getNome() + " iniciado.");
                //to do: Incluir horário
                ClienteApplication.getClientes().get(busca).setStatus("Aguardando triagem.");
                //ClienteApplication.getClientes().get(busca).getData() = ;
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
        if ("Enfermeiro".equals(Main.getProfissao()) || "Administrador".equals(Main.getProfissao())) {

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
                Util.Erro("\nCliente não encontrado");
            }
        } else {
            Util.Erro("\nVocê não tem permissão para acessar essa opção.");
        }

    }

    public static void encerrarAtendimento() {
        System.out.println("\n========= ENCERRAR ATENDIMENTO =========");

        //Conferir se o paciente existe
        int busca = ClienteApplication.pesquisarCliente();

        if (busca >= 0) {
            Util.Sucesso("\nAtendimento do cliente " + ClienteApplication.getClientes().get(busca).getNome() + " finalizado com sucesso.");
            ClienteApplication.getClientes().get(busca).setStatus("Liberado");
            //to do: Deletar Data e idCliente
            //ClienteApplication.getClientes().get(busca).getData() = ;
            //ClienteApplication.getClientes().get(busca).getIdTriagem();
            for(int i=0; i<AtendimentoApplication.getFilaAtendimento().size(); i++){
                if(ClienteApplication.getClientes().get(busca) == AtendimentoApplication.getFilaAtendimento().get(i)){
                    AtendimentoApplication.getFilaAtendimento().remove(AtendimentoApplication.getFilaAtendimento().get(i));
                    break;
                }
            }
        } else {
            Util.Erro("\nCliente não encontrado");
        }
    }

}
