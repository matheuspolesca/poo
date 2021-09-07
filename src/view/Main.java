package view;

import controller.AtendimentoApplication;
import controller.ClienteApplication;
import controller.DoencaApplication;
import controller.FuncionarioApplication;
import controller.SistemaApplication;

import model.Doenca;
import model.Medico;
import model.Funcionario;
import model.Enfermeiro;
import model.Cliente;
import java.util.ArrayList;
import java.util.Scanner;
import model.Plantao;

public class Main {
    private static String profissao = "NULL";

    public static String getProfissao() {
        return profissao;
    }

    public static void setProfissao(String profissao) {
        Main.profissao = profissao;
    }
    
    
    public static void main(String[] args) {
        
        //Cadastro dos funcionários
        ArrayList<Plantao> periodo = new ArrayList<>();
        periodo.add(Plantao.TARDE);
        periodo.add(Plantao.MANHA);
        
        //Cadastro dos funcionÃ¡rios
        FuncionarioApplication.getFuncionarios()[FuncionarioApplication.getNumFuncionarios()] = new Funcionario("admin", "admin", 20, "admin", "admin@gmail.com", "Turmalina", 
        "0", "admin", "Administrador", "admin", periodo);
        FuncionarioApplication.getFuncionarios()[FuncionarioApplication.getNumFuncionarios()] = new  Funcionario("Tulio", "Cordeiro", 25, "(38)99103-9305", "tulioalves@gmail.com", "Turmalina", 
        "11111111111", "Masculino", "Funcionario", "123", periodo);
        FuncionarioApplication.getFuncionarios()[FuncionarioApplication.getNumFuncionarios()] = new  Enfermeiro("Matheus", "Polesca", 20, "(32)98447-5253", "matheuspolesca@gmail.com", "Sete Lagoas", 
        "22222222222", "Masculino", "Enfermeiro", "456", periodo);
        FuncionarioApplication.getFuncionarios()[FuncionarioApplication.getNumFuncionarios()] = new  Medico("Brenda", "Orlandi", 23, "(32)98447-5253", "brendaorlandi@gmail.com", "Diamantina", 
        "33333333333", "Feminino", "Medico", "789", periodo);
        
        //Cadastro das doenÃ§as
        DoencaApplication.getDoencas().add(new Doenca("Cancer"));
        DoencaApplication.getDoencas().add(new Doenca("AIDS"));
        DoencaApplication.getDoencas().add(new Doenca("COVID-19"));
        DoencaApplication.getDoencas().add(new Doenca("Colesterol"));
        DoencaApplication.getDoencas().add(new Doenca("Diabetes"));
        DoencaApplication.getDoencas().add(new Doenca("Sinusite"));
        DoencaApplication.getDoencas().add(new Doenca("Gripe"));
        DoencaApplication.getDoencas().add(new Doenca("Febre"));
        DoencaApplication.getDoencas().add(new Doenca("Enxaqueca"));
        
        //Cliente teste     
        ClienteApplication.getClientes().add(new Cliente("Gabriel", "Augusto", 25, "3527-1006", "gabriel@ufvjm.edu.br", "Diamantina", "44444444444", "Masculino"));
        ClienteApplication.getClientes().add(new Cliente("Fernanda", "Montinegro", 45, "3527-1006", "fernanda@ufvjm.edu.br", "São Paulo", "55555555555", "Feminino"));
        ClienteApplication.getClientes().add(new Cliente("Airton", "Senna", 85, "3527-1006", "airton@ufvjm.edu.br", "Santa Catarina", "66666666666", "Masculino"));
        ClienteApplication.getClientes().add(new Cliente("Elizabeth", "Pereira", 65, "3527-1006", "elizabeth@ufvjm.edu.br", "Pernambuco", "77777777777", "Feminino"));
        ClienteApplication.getClientes().add(new Cliente("João", "Pedro", 5, "3527-1006", "joaol@ufvjm.edu.br", "Bahia", "88888888888", "Masculino"));
        ClienteApplication.getClientes().add(new Cliente("Julia", "Robets", 15, "3527-1006", "elizabeth@ufvjm.edu.br", "Estados Unidos", "99999999999", "Feminino"));
        
        ClienteApplication.getClientes().get(0).getClienteDoencas().add( DoencaApplication.getDoencas().get(0));
        ClienteApplication.getClientes().get(0).getClienteDoencas().add( DoencaApplication.getDoencas().get(1));
        ClienteApplication.getClientes().get(1).getClienteDoencas().add( DoencaApplication.getDoencas().get(2));
        ClienteApplication.getClientes().get(1).getClienteDoencas().add( DoencaApplication.getDoencas().get(3));
        ClienteApplication.getClientes().get(1).getClienteDoencas().add( DoencaApplication.getDoencas().get(4));
        ClienteApplication.getClientes().get(2).getClienteDoencas().add( DoencaApplication.getDoencas().get(5));
        ClienteApplication.getClientes().get(2).getClienteDoencas().add( DoencaApplication.getDoencas().get(6));
        ClienteApplication.getClientes().get(2).getClienteDoencas().add( DoencaApplication.getDoencas().get(7));
        ClienteApplication.getClientes().get(2).getClienteDoencas().add( DoencaApplication.getDoencas().get(8));

        fazerLogin();
        if(!"NULL".equals(profissao)){
            boolean valor = true;
        
            //Menu Principal
            while (valor != false) {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n========= MENU =========");
                System.out.println("\nDigite somente o nÃºmero da opÃ§Ã£o desejada:"
                        + "\n\n1 - Cliente"
                        + "\n2 - FuncionÃ¡rios"
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
                        SistemaApplication.gerarRelatorio();
                        break;
                    case 4:
                        System.out.println("Sistema finalizado.");
                        valor = false;
                        break;
                    default:
                        System.out.println((char) 27 + "[31m\nOpÃ§Ã£o invalida\u001B[0m");
                }
            }
        }
        
    }

  
    //Quando o sistema abre, a pessoa precisa fazer o login
    public static void fazerLogin() {

        System.out.println("\n========== LOGIN ===========");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nInforme seu CPF:");
        String cpf = sc.nextLine();
        Funcionario funcLogin = new Funcionario();

        //Confere se já existe o CPF 
        for (int i = 0; i < FuncionarioApplication.getNumFuncionarios() ; i++){
            if (FuncionarioApplication.getFuncionarios()[i].getCpf().equals(cpf)) {
                funcLogin = FuncionarioApplication.getFuncionarios()[i];
                Util.Sucesso("CPF encontrado.");
                break;
            }
        }

        //Se existir o CPF, confere se a senha está correta
        if (funcLogin.getCpf() != null) {

            System.out.println("\nInforme sua senha:");
            String senha = sc.nextLine();

            if (funcLogin.getSenha().equals(senha)) {
                Util.Sucesso("Senha confirmada");
                profissao = funcLogin.getProfissao();
                Util.Notifica("\nVocê esta logado no sistema como " + profissao);
            } else {
                Util.Erro("Senha não compativel, tente novamente.");
            }
        } else {
            Util.Erro("CPF não encontrado, tente novamente.");
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
                ClienteApplication.cadastrarCliente();
                break;
            case 2:
                AtendimentoApplication.iniciarAtendimento();
                break;
            case 3:
                ClienteApplication.alterarCadastroCliente();
                break;
            case 4:
                AtendimentoApplication.alterarStatus();
                break;
            case 5:
                ClienteApplication.deletarCliente();
                break;
            case 6:
                AtendimentoApplication.encerrarAtendimento();
                break;
            case 7:
                SistemaApplication.acessarInformações();
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
                        FuncionarioApplication.cadastroFuncionario("Funcionario");
                        break;
                    case 2:
                        FuncionarioApplication.cadastroFuncionario("Medico");
                        break;
                    case 3:
                        FuncionarioApplication.cadastroFuncionario("Enfermeiro");
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
                FuncionarioApplication.alterarCadastroFuncionario();
                break;
            case 4:
                FuncionarioApplication.alterarPlantao();
                break;
            case 5:
                break;
            default:
                System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
        }
    }
//    
}
