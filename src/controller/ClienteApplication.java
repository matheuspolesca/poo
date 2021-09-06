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

            try {

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
                if (numDoencas > 0) {
                    for (int i = 0; i < numDoencas; i++) {
                        DoencaApplication.adicionaDoencaAoCliente(novoCliente);
                    }
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

        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }

    }

    //Alterar Cadastro do Cliente
    public static void alterarCadastroCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========= EDITAR CLIENTE =========");

        int busca = pesquisarCliente();

        boolean sair = false;

        if (busca >= 0) {
            do {
                System.out.println("\nDigite o número referente ao atributo que deseja alterar:"
                        + "\n1 - Nome        2- Sobrenome     3 - Idade"
                        + "\n4 - Telefone    5 - E-mail       6 - Endereço"
                        + "\n7 - CPF         8 - Doenças      9 - Sexo"
                        + "\n10 - Finalizar Alteracoes");
                int acesso = sc.nextInt();
                sc.nextLine();

                switch (acesso) {

                    case 1:
                        System.out.println("\nNovo nome:");
                        String nomeC = sc.nextLine();

                        if (nomeC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            clientes.get(busca).setNome(nomeC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 2:
                        System.out.println("\nNovo Sobrenome:");
                        String sobrenomeC = sc.nextLine();

                        if (sobrenomeC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            clientes.get(busca).setSobrenome(sobrenomeC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 3:
                        System.out.println("\nNova Idade:");
                        int idadeC = sc.nextInt();

                        if (idadeC <= 0) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            clientes.get(busca).setIdade(idadeC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 4:
                        System.out.println("\nNovo Telefone:");
                        String telefoneC = sc.nextLine();

                        if (telefoneC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            clientes.get(busca).setTelefone(telefoneC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 5:
                        System.out.println("\nNovo E-mail:");
                        String emailC = sc.nextLine();

                        if (emailC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            clientes.get(busca).setEmail(emailC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 6:
                        System.out.println("\nNovo Endereço:");
                        String enderecoC = sc.nextLine();
                        clientes.get(busca).setEndereco(enderecoC);
                        Util.Sucesso("\nAlterado com sucesso.");
                        break;
                    case 7:
                        System.out.println("\nNovo CPF:");
                        String cpfC = sc.nextLine();

                        if (cpfC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            clientes.get(busca).setCpf(cpfC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 8:
                        System.out.println("\nNova Doença:");
                        DoencaApplication.alterarDoenca(clientes.get(busca));

                        Util.Sucesso("\nAlterado com sucesso.");
                        break;
                    case 9:
                        System.out.println("\nNovo Sexo:");
                        String sexoC = sc.nextLine();
                        if (sexoC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            clientes.get(busca).setSexo(sexoC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 10:
                        System.out.println("\nAlterações finalizadas.");
                        sair = true;
                        break;
                    default:
                       Util.Erro("\nOpção invalida.");
                }
            } while (sair != true);
        } else {
            Util.Erro("\nCliente não encontrado.");
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

    public static int pesquisarCliente() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nQual o nome do Cliente?");
        String nome = sc.nextLine().toUpperCase();

        int pos;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().toUpperCase().equals(nome)) {
                pos = i;
                return pos;
            }
        }

        return -1;
    }
    
    
}
