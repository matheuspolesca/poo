package projetohospital;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoHospital {

    public static void main(String[] args) {
        //Cadastro dos funcionários
        ArrayList<Plantao> periodo = new ArrayList<>();
        periodo.add(Plantao.TARDE);
        periodo.add(Plantao.MANHA);
        
        Sistema.getFuncionarios()[Sistema.getNumFuncionarios()] = new Funcionario("admin", "admin", 20, "admin", "admin@gmail.com", "Turmalina", 
        "0", "admin", "Administrador", "admin", periodo);
        
        
        Sistema.getFuncionarios()[Sistema.getNumFuncionarios()] = new  Funcionario("Tulio", "Cordeiro", 25, "(38)99103-9305", "tulioalves@gmail.com", "Turmalina", "11111111111", "Masculino", "Funcionario", "123", periodo);
        Sistema.getFuncionarios()[Sistema.getNumFuncionarios()] = new  Enfermeiro("Matheus", "Polesca", 20, "(32)98447-5253", "matheuspolesca@gmail.com", "Sete Lagoas", 
        "22222222222", "Masculino", "Enfermeiro", "456", periodo);
        Sistema.getFuncionarios()[Sistema.getNumFuncionarios()] = new  Medico("Brenda", "Orlandi", 23, "(32)98447-5253", "brendaorlandi@gmail.com", "Diamantina", 
        "33333333333", "Feminino", "Medico", "789", periodo);
        
        
        //Cadastro das doenças
        Sistema.getDoencas().add(new Doenca("Cancer"));
        Sistema.getDoencas().add(new Doenca("AIDS"));
        Sistema.getDoencas().add(new Doenca("COVID-19"));
        Sistema.getDoencas().add(new Doenca("Colesterol"));
        Sistema.getDoencas().add(new Doenca("Diabetes"));
        Sistema.getDoencas().add(new Doenca("Sinusite"));
        Sistema.getDoencas().add(new Doenca("Gripe"));
        Sistema.getDoencas().add(new Doenca("Febre"));
        Sistema.getDoencas().add(new Doenca("Enxaqueca"));
        
        //Cliente teste
        Sistema.getClientes().add(new Cliente("Gabriel", "Augusto", 25, "3527-1006", "joao@ufvjm.edu.br", "Diamantina", "15274632184", "Pouco"));

        
        //Fila teste
        //Fila fila = new Fila(cliente, doenca, "25/02/2000 07:32");
        //Sistema.
        
        Sistema.fazerLogin();
        if(!"NULL".equals(Sistema.getProfissao())){
            boolean valor = true;
        
            //Menu Principal
            while (valor != false) {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n========= MENU =========");
                System.out.println("\nDigite somente o número da opção desejada:"
                        + "\n\n1 - Cliente"
                        + "\n2 - Funcionários"
                        + "\n3 - Emitir Relatorios  "
                        + "\n4 - Encerrar Sistema\n");
                int acessoM = sc.nextInt();

                switch (acessoM) {
                    case 1:
                        menuCliente();
                        break;
                    case 2:
                        menuFuncionario();
                        break;
                    case 3:
                        Sistema.gerarRelatorio();
                        break;
                    case 4:
                        System.out.println("Sistema finalizado.");
                        valor = false;
                        break;
                    default:
                        System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                }
            }
        }
    }
    
    
    private static void menuCliente() {
        System.out.println("\n========= MENU: CLIENTE =========");
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Cadastrar Cliente                    2 - Iniciar Atendimento"
                + "\n3 - Editar Cadastro Cliente              4 - Alterar Status"
                + "\n5 - Excluir Paciente                     6 - Encerrar Atendimento"
                + "\n7 - Acessar Informacoes do Paciente "
                + "\n8 - Fechar\n");
        Scanner sc = new Scanner(System.in);
        int acessoC = sc.nextInt();
        switch (acessoC) {
            case 1:
                System.out.println("\n========= CADASTRAR CLIENTE =========");
                Sistema.cadastrarCliente();
                break;
            case 2:
                Sistema.iniciarAtendimento();
                break;
            case 3:
                Sistema.alterarCadastroCliente();
                break;
            case 4:
                Sistema.alterarStatus();
                break;
            case 5:
                Sistema.deletarCliente();
                break;
            case 6:
                Sistema.encerrarAtendimento();
                break;
            case 7:
                Sistema.acessarInformações();
                break;
            case 8:
                break;
            default:
                System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
        }
    }
    
    private static void menuFuncionario(){
        System.out.println("\n========= MENU: FUNCIONÁRIO =========");
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Cadastrar Funcionario"
                + "\n2 - Excluir Funcionario"
                + "\n3 - Alterar Cadastro Funcionario"
                + "\n4 - Alterar Plantão"
                + "\n5 - Fechar\n");
        Scanner sc = new Scanner(System.in);
        int acessoF = sc.nextInt();

        switch (acessoF) {
            case 1:
                System.out.println("\n*Você quer cadastrar um:"
                        + "\n\n1 - Funcionario"
                        + "\n2 - Medico"
                        + "\n3 - Enfermeiro"
                        + "\n4 - Fechar\n");
                int opcF = sc.nextInt();
                System.out.println("\n========= CADASTRAR FUNCIONÁRIO =========");
                switch (opcF) {
                    case 1:
                        Sistema.cadastroFuncionario("Funcionario");
                        break;
                    case 2:
                        Sistema.cadastroFuncionario("Medico");
                        break;
                    case 3:
                        Sistema.cadastroFuncionario("Enfermeiro");
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("[31m\nOpção invalida\u001B[0m");
                        break;
                }

                break;

            case 2:
//                deletarFuncionario();
                break;
            case 3:
                Sistema.alterarCadastroFuncionario();
                break;
            case 4:
                Sistema.alterarPlantao();
                break;
            case 5:
                break;
            default:
                System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
        }
    }
//    
}
