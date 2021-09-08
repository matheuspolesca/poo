package controller;

import java.util.Collections;
import java.util.Scanner;
import model.Cliente;
import model.ClienteComparator;
import model.Plantao;
import view.Util;
import view.Main;

/**
 *
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 */
public abstract class SistemaApplication {

    /**
     * Construtor padrão da classe
     */
    public SistemaApplication() {
    }


    /**
     * Acessa as informações de algum cliente
     */
    public static void acessarInformações() {

        try {
            //Apenas médicos ou o Administrador pode ter acesso as informações
            if ("Medico".equals(Main.getProfissao()) || "Administrador".equals(Main.getProfissao())) {

                System.out.println("\n========= ACESSAR INFORMAÇÕES =========");

                //Conferir se o paciente existe
                Cliente cliente = ClienteApplication.pesquisarCliente();

                if (cliente!=null) {
                    System.out.println(cliente.toString());
                    //to do - Concertar a impressão
                    System.out.println("Doencas do paciente: ");
                    for (int i = 0; i < cliente.getClienteDoencas().size(); i++) {
                        System.out.println(cliente.getClienteDoencas().get(i).getNome());
                    }
                } else {
                    throw new Exception("\nCliente não encontrado.");
                }
            } else {
                throw new Exception("\nVocê não tem permissão para acessar essa opção.");
            }
        } catch (Exception ex) {
            Util.Erro(ex.getMessage());
        }
    }

    /**
     * Gera os relatórios disponíveis (clientes, funcionários, doenças, fila de atendimento e relatório de plantão)
     * 
     */
    public static void gerarRelatorio() {
        System.out.println("\n========= RELATÓRIO =========");
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Lista de Clientes"
                + "\n2 - Lista de Funcionarios"
                + "\n3 - Lista de Doenças"
                + "\n4 - Relatório de Plantão"
                + "\n5 - Fila de Atendimento em Ordem de Prioridade Crescente"
                + "\n6 - Fila de Atendimento em Ordem de Prioridade Decrescente"
                + "\n7 - Voltar\n");
        Scanner sc = new Scanner(System.in);
        int acessoF = sc.nextInt();

        switch (acessoF) {
            case 1:
                System.out.println("\nNumero de Pacientes:");
                System.out.println(ClienteApplication.getClientes().size());
                System.out.println("\nLista de Clientes");
                relatorioClientes();
                break;

            case 2:
                System.out.println("\nNumero de Funcionarios");
                System.out.println(FuncionarioApplication.getNumFuncionarios());
                System.out.println("\nLista de Funcionarios");
                relatorioFuncionarios();
                break;

            case 3:
                System.out.println("\nLista de Doenças:");
                relatorioDoencas();
                break;
            case 4:
                relatorioPlantao();
                break;
            case 5:
                if (!AtendimentoApplication.getFilaAtendimento().isEmpty()) {
                    System.out.println("\nFila de Atendimento:");
                    AtendimentoApplication.getFilaAtendimento().stream().map(s -> s.getNome()).forEach(System.out::println);
                } else {
                    Util.Erro("A fila de atendimento esta vazia.");
                }
                break;
                case 6:
                if(!AtendimentoApplication.getFilaAtendimento().isEmpty()){
                    System.out.println("\nFila de Atendimento:");
                    Collections.sort(AtendimentoApplication.getFilaAtendimento(), new ClienteComparator());
                    AtendimentoApplication.getFilaAtendimento().stream().map(s -> s.getNome()).forEach(System.out::println);
                }
                else
                    System.out.println((char) 27 + "[31m\nA fila de atendimento esta vazia.\u001B[0m");
                break;
            case 7:
                break;

            default:
                Util.Erro("\nOpção invalida.");
        }
    }

    
    private static void relatorioClientes() {
        for (int i = 0; i < ClienteApplication.getClientes().size(); i++) {
            System.out.println(ClienteApplication.getClientes().get(i).toString());
        }
    }


    private static void relatorioFuncionarios() {

        for (int i = 0; i < FuncionarioApplication.getNumFuncionarios(); i++) {
            System.out.println(FuncionarioApplication.getFuncionarios()[i].toString());
            System.out.println("Plantão:");
            for (Plantao periodo : FuncionarioApplication.getFuncionarios()[i].getPeriodo()) {
                System.out.println(Plantao.values()[periodo.getDescricao() - 1]);
            }
        }

    }


    private static void relatorioDoencas() {
        for (int i = 0; i < DoencaApplication.getDoencas().size(); i++) {
            System.out.println(DoencaApplication.getDoencas().get(i).getNome() + ": " + DoencaApplication.getDoencas().get(i).getQtdPacientes() + " caso(s).");
            if (DoencaApplication.getDoencas().get(i).getQtdPacientes() > 0) {
                System.out.println("Os clientes com essa doenca sao: ");
                for (int j = 0; j < DoencaApplication.getDoencas().get(i).getDoencaClientes().size(); j++) {
                    System.out.println(DoencaApplication.getDoencas().get(i).getDoencaClientes().get(j).getNome());
                }
            }
        }
    }


    private static void relatorioPlantao() {
        System.out.println("\n========= RELATÓRIO PLANTÃO =========");
        for (int j = 0; j < 3; j++) {
            System.out.println("\nPeriodo: " + Plantao.values()[j].name());
            for (int i = 0; i < FuncionarioApplication.getNumFuncionarios(); i++) {
                for (Plantao periodo : FuncionarioApplication.getFuncionarios()[i].getPeriodo()) {
                    if (periodo.getDescricao() == Plantao.values()[j].getDescricao() && !FuncionarioApplication.getFuncionarios()[i].getProfissao().equals("Administrador")) {
                        System.out.println(FuncionarioApplication.getFuncionarios()[i].getNome());
                    }
                }
            }
        }
    }

}
