/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import java.util.ArrayList;
import java.util.Scanner;
import view.Util;
import controller.TriagemApplication;
import model.Doenca;

/**
 *
 * @author brend
 */
public class ClienteApplication {
    private static ArrayList<Cliente> clientes = new ArrayList();
    protected static int numClientesProtected;
    private static int numClientes;

    public ClienteApplication() {
        numClientes = 0;
        numClientesProtected = 0;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        ClienteApplication.clientes = clientes;
    }

    public static int getNumClientesProtected() {
        return numClientesProtected;
    }

    public static void setNumClientesProtected(int numClientesProtected) {
        ClienteApplication.numClientesProtected = numClientesProtected;
    }

    public static int getNumClientes() {
        return numClientes;
    }

    public static void setNumClientes(int numClientes) {
        ClienteApplication.numClientes = numClientes;
    }
    
    
    
    //Receber as informações para criação do cliente
    public static void cadastrarCliente() {

        //Tentar fazer o cadastro
        Scanner sc = new Scanner(System.in);
        Cliente novoCliente = new Cliente();

        try {
            System.out.println("\n*CPF:");
            novoCliente.setCpf(sc.nextLine());

            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getCpf().equals(novoCliente.getCpf())) {
                    throw new Exception("Cliente já existe no sistema.");
                }
            }

            System.out.println("\n*Nome:");
            novoCliente.setNome(sc.nextLine());

            System.out.println("\n*Sobrenome:");
            novoCliente.setSobrenome(sc.nextLine());

            System.out.println("\n*Idade:");
            novoCliente.setIdade(sc.nextInt());

            System.out.println("\n*Telefone:");
            sc.nextLine();
            novoCliente.setTelefone(sc.nextLine());

            System.out.println("\n*E-mail:");
            novoCliente.setEmail(sc.nextLine());

            System.out.println("\nEndereço:");
            novoCliente.setEndereco(sc.nextLine());

            System.out.println("\n*Sexo:");
            novoCliente.setSexo(sc.nextLine());

            System.out.println("\nQuantas doenças tem o cliente?");
            int numDoencas = sc.nextInt();
            
            while (numDoencas <= 0 || numDoencas > Doenca.getTotDoencas()) {
                Util.Erro("O número de doenças informado foi menor do que o digitado, reinicie o cadastro.");
                System.out.println("\nQuantas doenças tem o cliente?");
                numDoencas = sc.nextInt();
            }
            
            for (int i = 0; i < numDoencas; i++) {
                DoencaApplication.adicionaDoencaAoCliente(novoCliente);
            }

            //Se algum campo obrigatório estiver vazio, retorna mensagem de erro, se não, cadastra o cliente
            if (novoCliente.getNome().isEmpty() || novoCliente.getSobrenome().isEmpty() || novoCliente.getIdade() <= 0 || novoCliente.getTelefone().isEmpty() || novoCliente.getEmail().isEmpty() || novoCliente.getCpf().isEmpty() || novoCliente.getSexo().isEmpty()) {
                throw new Exception("Campo Obrigatório não foi preenchido.");
            }
            clientes.add(novoCliente);
            Util.Sucesso("Cliente cadastrado com sucesso.");

        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }

    }

    //Alterar Cadastro do Cliente
    public static void alterarCadastroCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========= EDITAR CLIENTE =========");

        Cliente cliente = pesquisarCliente();

        boolean sair = false;
        
        try{
            if (cliente!=null) {
                do {
                    System.out.println("\nDigite o número referente ao atributo que deseja alterar:"
                            + "\n1 - Nome        2- Sobrenome     3 - Idade"
                            + "\n4 - Telefone    5 - E-mail       6 - Endereço"
                            + "\n7 - CPF         8 - Doenças      9 - Sexo"
                            + "\n10 - IdTriagem"
                            + "\n11 - Finalizar Alteracoes");
                    int acesso = sc.nextInt();
                    sc.nextLine();

                    switch (acesso) {

                        case 1:
                            System.out.println("\nNovo nome:");
                            String nomeC = sc.nextLine();

                            if (nomeC.isEmpty()) {
                                System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                            } else {
                                cliente.setNome(nomeC);
                                System.out.println((char) 27 + "[32m\nAlterado com sucesso.\u001B[0m");
                            }
                            break;
                        case 2:
                            System.out.println("\nNovo Sobrenome:");
                            String sobrenomeC = sc.nextLine();

                            if (sobrenomeC.isEmpty()) {
                                System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                            } else {
                                cliente.setSobrenome(sobrenomeC);
                                System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                            }
                            break;
                        case 3:
                            System.out.println("\nNova Idade:");
                            int idadeC = sc.nextInt();

                            if (idadeC <= 0) {
                                System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                            } else {
                                cliente.setIdade(idadeC);
                                System.out.println((char) 27 + "[32m\nAlterado com sucesso.\u001B[0m");
                            }
                            break;
                        case 4:
                            System.out.println("\nNovo Telefone:");
                            String telefoneC = sc.nextLine();

                            if (telefoneC.isEmpty()) {
                                System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                            } else {
                                cliente.setTelefone(telefoneC);
                                System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                            }
                            break;
                        case 5:
                            System.out.println("\nNovo E-mail:");
                            String emailC = sc.nextLine();

                            if (emailC.isEmpty()) {
                                System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                            } else {
                                cliente.setEmail(emailC);
                                System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                            }
                            break;
                        case 6:
                            System.out.println("\nNovo Endereço:");
                            String enderecoC = sc.nextLine();
                            cliente.setEndereco(enderecoC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                            break;
                        case 7:
                            System.out.println("\nNovo CPF:");
                            String cpfC = sc.nextLine();

                            if (cpfC.isEmpty()) {
                                System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                            } else {
                                cliente.setCpf(cpfC);
                                System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                            }
                            break;
                        case 8:
                            DoencaApplication.alterarDoenca(cliente);
                            break;
                        case 9:
                            System.out.println("\nNovo Sexo:");
                            String sexoC = sc.nextLine();
                            if (sexoC.isEmpty()) {
                                System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                            } else {
                                cliente.setSexo(sexoC);
                                System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                            }
                            break;
                        case 10:
                            TriagemApplication.alterarIdTriagem(cliente);
                            break;
                        case 11:
                            System.out.println("\nAlterações finalizadas.");
                            sair = true;
                            break;
                        default:
                            System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                    }
                } while (sair != true);
            } else {
                throw new Exception("\nCliente não encontrado.");
            }
            
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }

    public static void deletarCliente() {
        //Tentar fazer o cadastro
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\n*CPF:");
            String cpf = sc.nextLine();
//to do: alterar for
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getCpf().equals(cpf)) {
                    clientes.remove(i);
                    setNumClientes(-1);
                    numClientesProtected--;
                    Util.Sucesso("Cliente deletado.");
                    return;
                }
            }
            throw new Exception("Cliente não encontrado.");
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }

    protected static Cliente pesquisarCliente() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nQual o nome do Cliente?");
        String nome = sc.nextLine().toUpperCase();
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().toUpperCase().equals(nome)) {
                return clientes.get(i);
            }
        }

        return null;
    }
    
    
}
