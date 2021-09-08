/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.Doenca;
import java.util.ArrayList;
import java.util.Scanner;
import view.Util;

/**
 *
 * @author brend
 */
public class DoencaApplication {
    
    private static ArrayList<Doenca> doencas = new ArrayList();

    public DoencaApplication() {
    }

    public static ArrayList<Doenca> getDoencas() {
        return doencas;
    }

    public static void setDoencas(ArrayList<Doenca> doencas) {
        DoencaApplication.doencas = doencas;
    }
    
    
    protected static void adicionaDoencaAoCliente(Cliente cliente) {
        try{
            int indiceDoenca = pesquisarDoenca();
            if (indiceDoenca >= 0) {
                
                for (int i = 0; i < cliente.getClienteDoencas().size(); i++) {
                    if (indiceDoenca == cliente.getClienteDoencas().get(i).getIdDoenca()) {
                        throw new Exception("\nDoenca já registrada no cliente.");
                    }
                }
                
                cliente.getClienteDoencas().add(doencas.get(indiceDoenca));
                doencas.get(indiceDoenca).getDoencaClientes().add(cliente);
                doencas.get(indiceDoenca).setQtdPacientes(+1);
                Util.Sucesso("\nDoenca registrada com sucesso.");
            }else{
                throw new Exception("\nDoenca não cadastrada.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }
    
    public static void alterarDoenca(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        boolean sair = false;
        do {
            System.out.println("\nDigite o número referente a opção que deseja:"
                    + "\n1 - Inserir"
                    + "\n2 - Excluir"
                    + "\n3 - Finalizar Alteracoes");
            int acesso = sc.nextInt();

            switch (acesso) {

                case 1:
                    System.out.println("\nInclusão de doenca:");
                    adicionaDoencaAoCliente(cliente);
                    break;
                case 2:
                    System.out.println("\nExclusão de doenca:");
                    excluiDoencaDoCliente(cliente);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    Util.Erro("\nOpção invalida.");
            }
        } while (sair != true);
    }

    private static void excluiDoencaDoCliente(Cliente cliente) {
        if (cliente.getClienteDoencas().isEmpty()) {
            Util.Notifica("\nCliente sem doenças cadastradas.");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nInforme o numero referente a doenca que você deseja exluir:");
            for (int i = 0; i < cliente.getClienteDoencas().size(); i++) {
                System.out.println(cliente.getClienteDoencas().get(i).getIdDoenca() + " - " + cliente.getClienteDoencas().get(i).getNome());
            }
            int indiceExclui = sc.nextInt();
            for (int j = 0; j < cliente.getClienteDoencas().size(); j++) {
                if (cliente.getClienteDoencas().get(j).getIdDoenca() == indiceExclui) {
                    cliente.getClienteDoencas().remove(cliente.getClienteDoencas().get(j));
                }
            }
            for (int k = 0; k < doencas.size(); k++) {
                if (doencas.get(k).getIdDoenca() == indiceExclui) {
                    for (int l = 0; l < doencas.get(k).getDoencaClientes().size(); l++) {
                        if (doencas.get(k).getDoencaClientes().get(l) == cliente) {
                            doencas.get(k).getDoencaClientes().remove(doencas.get(k).getDoencaClientes().get(l));
                            doencas.get(k).setQtdPacientes(-1);
                        }
                    }
                }
            }
            Util.Sucesso("\nDoenca excluida com sucesso.");
        }
    }

    private static int pesquisarDoenca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInforme o numero referente a doenca: ");
        for (int i = 0; i < doencas.size(); i++) {
            System.out.println(doencas.get(i).getIdDoenca() + " - " + doencas.get(i).getNome());
        }
        int busca = sc.nextInt();
        int indice;

        for (int i = 0; i < doencas.size(); i++) {
            if (doencas.get(i).getIdDoenca() == busca) {
                indice = doencas.get(i).getIdDoenca();
                return indice;
            }
        }

        return -1;
    }
    
    
}
