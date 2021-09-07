/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Funcionario;
import java.util.ArrayList;
import java.util.Scanner;
import model.Plantao;
import view.Util;

/**
 *
 * @author brend
 */
public class FuncionarioApplication {
    
    private static Funcionario funcionarios[] = new Funcionario[100];
    private static int numFuncionarios;
    

    public FuncionarioApplication() {
        numFuncionarios = 0;
    }

    public static Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public static void setFuncionarios(Funcionario[] funcionarios) {
        FuncionarioApplication.funcionarios = funcionarios;
    }

    public static int getNumFuncionarios() {
        return numFuncionarios;
    }

    public static void setNumFuncionarios(int numFuncionarios) {
        FuncionarioApplication.numFuncionarios += numFuncionarios;
    }
    
    
    
    public static void cadastroFuncionario(String cadProfissao) {
       //Tentar fazer o cadastro
       Scanner sc = new Scanner(System.in);
       Funcionario novoFuncionario = new Funcionario();
       ArrayList<Plantao> periodo = new ArrayList<>();

       try {
           System.out.println("\n*CPF:");
           novoFuncionario.setCpf(sc.nextLine());

           for (int i = 0; i < numFuncionarios; i++) {
               if (funcionarios[i].getCpf().equals(novoFuncionario.getCpf())) {
                   throw new Exception("Funcionário já existe no sistema.");
               }
           }

            //Dados do funcionario
            System.out.println("\n*Nome:");
            novoFuncionario.setNome(sc.nextLine());
            System.out.println("\n*Sobrenome:");
            novoFuncionario.setSobrenome(sc.nextLine());
            System.out.println("\n*Idade:");
            novoFuncionario.setIdade(sc.nextInt());
            System.out.println("\n*Telefone:");
            sc.nextLine();
            novoFuncionario.setTelefone(sc.nextLine());
            System.out.println("\n*E-mail:");
            novoFuncionario.setEmail(sc.nextLine());
            System.out.println("\nEndereço:");
            novoFuncionario.setEndereco(sc.nextLine());
            System.out.println("\n*Sexo:");
            novoFuncionario.setSexo(sc.nextLine());
            System.out.println("\nSenha:");
            novoFuncionario.setSenha(sc.nextLine());
            novoFuncionario.setProfissao(cadProfissao);
            System.out.println("\nQuantos turnos você trabalha? (MAX 3)");
            int opc = sc.nextInt();

            if (opc <= 0 || opc > 3) {
                throw new Exception("Error: Quantidade de turnos são de 1 a 3 (Manhã, Tarde, Noite)");
            }

            for (int i = 0; i < opc; i++) {
                boolean existe = false;

                System.out.println("\nDigite o número referente ao período de trabalho:"
                        + "\n1 - Manhã        2- Tarde     3 - Noite");
                int opcPeriodo = sc.nextInt();

                for (Plantao periodinho : periodo) {
                    if (periodinho.getDescricao() == opcPeriodo) {
                        Util.Erro("Error: Não pode selecionar dois períodos iguais.");
                        --i;
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    periodo.add(Plantao.values()[opcPeriodo - 1]);
                }

            }

            novoFuncionario.setPeriodo(periodo);

            //Se algum campo obrigatório estiver vazio, retorna mensagem de erro
            if (novoFuncionario.getNome().isEmpty() || novoFuncionario.getSobrenome().isEmpty() || novoFuncionario.getIdade() <= 0 || novoFuncionario.getTelefone().isEmpty() || novoFuncionario.getEmail().isEmpty() || novoFuncionario.getCpf().isEmpty() || novoFuncionario.getSexo().isEmpty() || novoFuncionario.getSenha().isEmpty()) {
                throw new Exception("Campo Obrigatório não foi preenchido.");
            }

            funcionarios[numFuncionarios++] = novoFuncionario;
            Util.Sucesso("Funcionario cadastrado com sucesso.");

        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }

    //Alterar Cadastro do Cliente
    public static void alterarCadastroFuncionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========= EDITAR FUNCIONARIO =========");

        Funcionario funcionario = pesquisarFuncionario();

        boolean sair = false;

        if (funcionario != null) {
            do {
                System.out.println("\nDigite o número referente ao atributo que deseja alterar:"
                        + "\n1 - Nome         2- Sobrenome     3 - Idade"
                        + "\n4 - Telefone     5 - E-mail       6 - Endereço"
                        + "\n7 - CPF          8 - Sexo         9 - Senha"
                        + "\n10 - Profissão"
                        + "\n11 - Finalizar Alteracoes");
                int acesso = sc.nextInt();
                sc.nextLine();

                switch (acesso) {

                    case 1:
                        System.out.println("\nNovo Nome:");
                        String nomeC = sc.nextLine();

                        if (nomeC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setNome(nomeC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 2:
                        System.out.println("\nNovo Sobrenome:");
                        String sobrenomeF = sc.nextLine();

                        if (sobrenomeF.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setSobrenome(sobrenomeF);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 3:
                        System.out.println("\nNova Idade:");
                        int idadeF = sc.nextInt();

                        if (idadeF <= 0) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setIdade(idadeF);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 4:
                        System.out.println("\nNovo Telefone:");
                        String telefoneC = sc.nextLine();

                        if (telefoneC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setTelefone(telefoneC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 5:
                        System.out.println("\nNovo E-mail:");
                        String emailC = sc.nextLine();

                        if (emailC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setEmail(emailC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 6:
                        System.out.println("\nNovo Endereço:");
                        String enderecoC = sc.nextLine();
                        funcionario.setEndereco(enderecoC);
                        Util.Sucesso("\nAlterado com sucesso.");
                        break;
                    case 7:
                        System.out.println("\nNovo CPF:");
                        String cpfC = sc.nextLine();

                        if (cpfC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setCpf(cpfC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 8:
                        System.out.println("\nNovo Sexo:");
                        String sexoC = sc.nextLine();
                        if (sexoC.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setSexo(sexoC);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 9:
                        System.out.println("\nNova Senha:");
                        String senha = sc.nextLine();
                        if (senha.isEmpty()) {
                            Util.Erro("\nNão pode ser alterado para um campo vazio.");
                        } else {
                            funcionario.setSenha(senha);
                            Util.Sucesso("\nAlterado com sucesso.");
                        }
                        break;
                    case 10:
                        System.out.println("\nNova Profissão:");
                        System.out.println("\nDigite o número referente a profissão:"
                                + "\n\n1 - Funcionario"
                                + "\n2 - Medico"
                                + "\n3 - Enfermeiro");
                        int profissaoF = sc.nextInt();
                        switch (profissaoF) {
                            case 1:
                                funcionario.setProfissao("Funcionario");
                                break;
                            case 2:
                                funcionario.setProfissao("Medico");
                                break;
                            case 3:
                                funcionario.setProfissao("Enfermeiro");
                                break;
                            default:
                                Util.Erro("[31m\nOpção invalida\u001B[0m");
                        }
                        break;
                    case 11:
                        Util.Notifica("\nAlterações finalizadas.");
                        sair = true;
                        break;
                    default:
                        Util.Erro("\nOpção invalida.");
                }
            } while (sair != true);
        } else {
            Util.Erro("\nFuncionario não encontrado.");
        }
    }

//    public static void deletarFuncionario(){
//        //Tentar fazer o cadastro
//        Scanner sc = new Scanner(System.in);
//
//        try 
//        {
//            System.out.println("\n*CPF:");
//            String cpf = sc.nextLine();
//    
//            for (int i = 0; i < funcionarios.size(); i++) {
//                if (funcionarios.get(i).getCpf().equals(cpf)) {
//                    funcionarios.remove(i);
//                    System.out.println((char) 27 + "[32mFuncionário deletado.\u001B[0m");
//                    return;
//                }
//            }
//            throw new Exception("Funcionário não encontrado.");
//        } catch (Exception ex){
//            System.out.println((char) 27 + "[31m" + ex.getMessage() + "\u001B[0m");
//        }
//    }
    public static Funcionario pesquisarFuncionario() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nQual o nome do Funcionario?");
        String nome = sc.nextLine().toUpperCase();

        for (int i = 0; i < numFuncionarios; i++) {
            if (funcionarios[i].getNome().toUpperCase().equals(nome)) {
                return funcionarios[i];
            }
        }

        return null;
    }
    
    public static void alterarPlantao() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Plantao> periodo = new ArrayList<>();
        Funcionario funcionario = FuncionarioApplication.pesquisarFuncionario();
        
        try {
            if(funcionario!=null){
            System.out.println("\nQuantos turnos você trabalha? (MAX 3)");
            int opc = sc.nextInt();

                if (opc <= 0 || opc > 3) {
                    throw new Exception("Error: Quantidade de turnos são de 1 a 3 (Manhã, Tarde, Noite)");
                }

                for (int i = 0; i < opc; i++) {
                    boolean existe = false;
                    System.out.println("\nDigite o número referente ao período de trabalho:"
                            + "\n1 - Manhã        2- Tarde     3 - Noite");
                    int opcPeriodo = sc.nextInt();

                    for (Plantao periodinho : periodo) 
                    {
                        if (periodinho.getDescricao() == opcPeriodo) 
                        {
                            Util.Erro("Error: Não pode selecionar dois períodos iguais.");
                            --i;
                            existe = true;
                            break;
                        }
                    }

                    if (!existe) 
                    {
                        periodo.add(Plantao.values()[opcPeriodo - 1]);
                    }
                }

                funcionario.setPeriodo(periodo);
            }else{
                throw new Exception("Error: Funcionário não encontrado.");
            }
        } catch (Exception e) {
            Util.Erro(e.getMessage());
        }
    }
}
