package controller;

import java.util.Collections;
import java.util.Scanner;
import model.Plantao;
import projetohospital.Util;
import projetohospital.Main;

public abstract class SistemaApplication {
    
    
    public SistemaApplication() {
    }
   

    //Acessar informações sobre o cliente
    public static void acessarInformações() {

        //Apenas médicos ou o Administrador pode ter acesso as informações
        if ("Medico".equals(Main.getProfissao()) || "Administrador".equals(Main.getProfissao())) {

            System.out.println("\n========= ACESSAR INFORMAÇÕES =========");

            //Conferir se o paciente existe
            int busca = ClienteApplication.pesquisarCliente();

            if (busca >= 0) {
                System.out.println(ClienteApplication.getClientes().get(busca).toString());
                //to do - Concertar a impressão
                System.out.println("Doencas do paciente: ");
                for (int i = 0; i < ClienteApplication.getClientes().get(busca).getClienteDoencas().size(); i++) {
                    System.out.println(ClienteApplication.getClientes().get(busca).getClienteDoencas().get(i).getNome());
                }
            } else {
                Util.Erro("\nCliente não encontrado.");
            }
        } else {
            Util.Erro("\nVocê não tem permissão para acessar essa opção.");
        }

    }

    public static void gerarRelatorio() {
        System.out.println("\n========= RELATÓRIO =========");
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Lista de Clientes"
                + "\n2 - Lista de Funcionários"
                + "\n3 - Lista de Doenças"
                + "\n4 - Relatório de Plantão"
                + "\n5 - Fila de Atendimento"
                + "\n6 - Voltar\n");
        Scanner sc = new Scanner(System.in);
        int acessoF = sc.nextInt();

        switch (acessoF) {
            case 1:
                System.out.println("\nNúmero de Pacientes:");
                relatorioPacientes();
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
                if(!AtendimentoApplication.getFilaAtendimento().isEmpty()){
                    System.out.println("\nFila de Atendimento:");
                    AtendimentoApplication.getFilaAtendimento().stream().map(s -> s.getNome()).forEach(System.out::println);
                }
                else
                    System.out.println((char) 27 + "[31m\nA fila de atendimento esta vazia.\u001B[0m");
                break;
            case 6:
                break;

            default:
                Util.Erro("\nOpção invalida.");
        }
    }

    public static void relatorioClientes() {
        for (int i = 0; i < ClienteApplication.getClientes().size(); i++) {
            System.out.println(ClienteApplication.getClientes().get(i).toString());
        }
    }

    public static void relatorioFuncionarios() {

        for (int i = 0; i < FuncionarioApplication.getNumFuncionarios(); i++) {
            System.out.println(FuncionarioApplication.getFuncionarios()[i].toString());
            System.out.println("Plantão:");
            for (Plantao periodo : FuncionarioApplication.getFuncionarios()[i].getPeriodo()) {
                System.out.println(Plantao.values()[periodo.getDescricao() - 1]);
            }
        }

    }

    public static void relatorioDoencas() {
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

    public static void relatorioPacientes() {
        System.out.println(ClienteApplication.getClientes().size());
    }

    public static void relatorioPlantao() {
        System.out.println("\n========= RELATÓRIO PLANTÃO =========");
        for (int j = 0; j < 3; j++) {
            System.out.println("\nPeriodo: " + Plantao.values()[j].name());
            for (int i = 0; i < FuncionarioApplication.getNumFuncionarios(); i++) {
                for (Plantao periodo : FuncionarioApplication.getFuncionarios()[i].getPeriodo()) {
                    if(periodo.getDescricao() == Plantao.values()[j].getDescricao() && !FuncionarioApplication.getFuncionarios()[i].getProfissao().equals("Administrador")){
                    System.out.println(FuncionarioApplication.getFuncionarios()[i].getNome());
                    }
                }
            }
        }
    }

}
