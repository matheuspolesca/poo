package projetohospital;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Sistema {

    public static ArrayList<Cliente> clientes = new ArrayList();
    public static ArrayList<Funcionario> funcionarios = new ArrayList(100);
    public static String profissao = "NULL";

    public Sistema() {
    }

    //Quando o sistema abre, a pessoa precisa fazer o login
    public static void fazerLogin() {

        System.out.println("\n========== LOGIN ===========");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nInforme seu CPF:");
        String cpf = sc.nextLine();

        Funcionario funcLogin = new Funcionario();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcLogin = funcionario;
                System.out.println((char) 27 + "[32mCPF encontrado\u001B[0m");
                break;
            }
        }

        //Verifica se a senha informado está correta
        if (!funcLogin.getCpf().isEmpty()) {

            System.out.println("\nInforme sua senha:");
            String senha = sc.nextLine();

            if (funcLogin.getSenha().equals(senha)) {
                System.out.println((char) 27 + "[32mSenha confirmada\u001B[0m");
                profissao = funcLogin.getProfissao();
                System.out.println((char) 27 + "[30m\nVocê esta logado no sistema como " + profissao + ".\u001B[0m");
            } else {
                System.out.println((char) 27 + "[31mSenha não compativel, tente novamente\u001B[0m");
            }
        } else {
            System.out.println((char) 27 + "[31mCPF não encontrado, tente novamente.\u001B[0m");
        }
    }
    
    //Menu do sistema
    public static void menuSistema() {
        boolean valor = true;
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
                    System.out.println("\n========= MENU: FUNCIONÁRIO =========");
                    System.out.println("\nDigite somente o número da opção desejada:"
                            + "\n\n1 - Cadastrar Funcionario"
                            + "\n2 - Excluir Funcionario"
                            + "\n3 - Alterar Cadastro Funcionario"
                            + "\n4 - Fechar\n");
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
//                                    cadastrarCliente();
                                    break;
                                case 2:
//                                    cadastrarCliente();
                                    break;
                                case 3:
//                                    cadastrarCliente();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("\nOpção Inválida");
                                    break;
                            }

                            break;

                        case 2:
                            //excluirFuncionario
                            break;
                        case 3:
                            //alterarCadastroFuncionario
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                    }
                    break;
                case 3:
                    gerarRelatorio();
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
    
    private static void menuCliente() {
        System.out.println("\n========= MENU: CLIENTE =========");
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Cadastrar Cliente                    2 - Iniciar Atendimento"
                + "\n3 - Editar Cadastro Cliente              4 - Alterar Status"
                + "\n5 - Excluir Paciente                     6 - Encerrar Atendimento,"
                + "\n7 - Acessar Informacoes do Paciente "
                + "\n8 - Fechar\n");
        Scanner sc = new Scanner(System.in);
        int acessoC = sc.nextInt();
        switch (acessoC) {
            case 1:
                System.out.println("\n========= CADASTRAR CLIENTE =========");
                cadastrarCliente();
                break;
            case 2:
                iniciarAtendimento();
                break;
            case 3:
                alterarCadastroCliente();
                break;
            case 4:
                alterarStatus();
                break;
            case 5:
                //excluirPaciente
                break;
            case 6:
                encerrarAtendimento();
                break;
            case 7:
                acessarInformações();
                break;
            case 8:
                break;
            default:
                System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
        }
    }
//    
//    private static boolean verificaCadastro<T>(T lista){
//        return true;
//    }

    //Receber as informações para criação do cliente
    public static void cadastrarCliente() {

        //Tentar fazer o cadastro
        try 
        {
            Scanner sc = new Scanner(System.in);
            boolean encontrou = false;
            Cliente novoCliente = new Cliente();
            

            System.out.println("\n*CPF:");
            novoCliente.setCpf(sc.nextLine());
//to do: alterar for
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getCpf().equals(novoCliente.getCpf())) {
                    System.out.println((char) 27 + "[31m\nO cliente já está cadastrado\u001B[0m");
                    encontrou = true;
                }
            }

            if (!encontrou) {
                
                System.out.println("\n*Nome:");
                novoCliente.setNome(sc.nextLine());
                System.out.println("\n*Telefone:");
                novoCliente.setTelefone(sc.nextLine());
                System.out.println("\n*E-mail:");
                novoCliente.setEmail(sc.nextLine());
                System.out.println("\nEndereço:");
                novoCliente.setEndereco(sc.nextLine());
                System.out.println("\nDoença:");
                novoCliente.setDoencas(sc.nextLine());
                System.out.println("\n*Sexo:");
                novoCliente.setSexo(sc.nextLine());

                //Se algum campo obrigatório estiver vazio, retorna mensagem de erro, se não, cadastra o cliente
                if (novoCliente.getNome().isEmpty() || novoCliente.getTelefone().isEmpty() || novoCliente.getEmail().isEmpty() || novoCliente.getCpf().isEmpty() || novoCliente.getSexo().isEmpty()) {
                    throw new Exception("Campo Obrigatório não foi preenchido.");
                }
                clientes.add(novoCliente);
                System.out.println((char) 27 + "[32mCliente cadastrado com sucesso.\u001B[0m");
                
            }
        } catch (Exception e) {
            System.out.println((char) 27 + "[31m" + e.getMessage() + "\u001B[0m");
        }
    }
    
    public static void cadastroFuncionario(){
//        if(profissao.equals("Medico") || profissao.equals("Funcionario") || profissao.equals("Enfermeiro")){
//            System.out.println("\nQual é a senha?");
//            String senha = sc.nextLine();
//            Funcionario novoFuncionario = new Funcionario (nome, telefone, email, endereco, cpf, doenca, sexo, profissao, senha);
//            funcionarios[++numeroFuncionarios] = novoFuncionario;
//            System.out.format((char)27 + "[32m%s cadastrado com sucesso.\u001B[0m", profissao);
//        }else{
//        
//        }
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

    public static void iniciarAtendimento() {

        System.out.println("\n========= INICIAR ATENDIMENTO =========");

        int busca = pesquisarCliente();

        if (busca >= 0) {
            System.out.println((char) 27 + "[32m\nAtendimento do cliente " + clientes.get(busca).getNome() + " iniciado.\u001B[0m");
            clientes.get(busca).setStatus("Aguardando triagem.");
        } else {
            System.out.println((char) 27 + "[31m\nCliente não encontrado\u001B[0m");
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
                        + "\n1 - Nome        2 - Telefone     3 - E-mail"
                        + "\n4 - Endereço    5 - CPF          6 - Doenças      7 - Sexo"
                        + "\n8 - Finalizar Alteracoes");
                int acesso = sc.nextInt();
                sc.nextLine();

                switch (acesso) {

                    case 1:
                        System.out.println("\nQual o novo nome do seu cliente?");
                        String nomeC = sc.nextLine();

                        if (nomeC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setNome(nomeC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso.\u001B[0m");
                        }
                        break;
                    case 2:
                        System.out.println("\nQual o novo telefone do seu cliente?");
                        String telefoneC = sc.nextLine();

                        if (telefoneC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setTelefone(telefoneC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 3:
                        System.out.println("\nQual o novo e-mail do seu cliente?");
                        String emailC = sc.nextLine();

                        if (emailC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setEmail(emailC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 4:
                        System.out.println("\nQual o novo endereco do seu cliente?");
                        String enderecoC = sc.nextLine();
                        clientes.get(busca).setEndereco(enderecoC);
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 5:
                        System.out.println("\nQual o novo CPF do seu cliente?");
                        String cpfC = sc.nextLine();

                        if (cpfC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setCpf(cpfC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 6:
                        System.out.println("\nQual as novas doencas do seu cliente?");
                        String doencasC = sc.nextLine();
                        clientes.get(busca).setDoencas(doencasC);
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 7:
                        System.out.println("\nQual o novo sexo do seu cliente?");
                        String sexoC = sc.nextLine();
                        if (sexoC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setSexo(sexoC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 8:
                        System.out.println("\nAlterações finalizadas.");
                        sair = true;
                        break;
                    default:
                        System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                }
            } while (sair != true);
        } else {
            System.out.println((char) 27 + "[31m\nCliente não encontrado\u001B[0m");
        }
    }

    public static void gerarRelatorio() {

    }

    ;
    
    //Alterar o Status do Paciente
    public static void alterarStatus() {
        if ("Enfermeiro".equals(profissao) || "Administrador".equals(profissao)) {

            System.out.println("\n========= ALTERAR STATUS =========");
            //Conferir se o paciente existe
            int busca = pesquisarCliente();

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
                        clientes.get(busca).setStatus("Aguardando triagem");
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 2:
                        clientes.get(busca).setStatus("Aguardando Atendimento");
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 3:
                        clientes.get(busca).setStatus("Direcionado");
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 4:
                        clientes.get(busca).setStatus("Liberado");
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                }
            } else {
                System.out.println((char) 27 + "[31m\nCliente não encontrado\u001B[0m");
            }
        } else {
            System.out.println((char) 27 + "[31mVocê não tem permissão para acessar essa opção.\u001B[0m");
        }

    }

    ;
    
    //Acessar informações sobre o cliente
    public static void acessarInformações() {

        //Apenas médicos ou o Administrador pode ter acesso as informações
        if ("Medico".equals(profissao) || "Administrador".equals(profissao)) {

            System.out.println("\n========= ACESSAR INFORMAÇÕES =========");

            //Conferir se o paciente existe
            int busca = pesquisarCliente();

            if (busca >= 0) {
                System.out.println(clientes.get(busca).toString());
            } else {
                System.out.println((char) 27 + "[31m\nCliente não encontrado\u001B[0m");
            }
        } else {
            System.out.println((char) 27 + "[31m\nVocê não tem permissão para acessar essa opção.\u001B[0m");
        }

    }

    ;
    
    public static void encerrarAtendimento() {
        System.out.println("\n========= ENCERRAR ATENDIMENTO =========");

        //Conferir se o paciente existe
        int busca = pesquisarCliente();

        if (busca >= 0) {
            System.out.println((char) 27 + "[32m\nAtendimento do cliente " + clientes.get(busca).getNome() + " finalizado.\u001B[0m");
            clientes.get(busca).setStatus("\nAguardando triagem.");
        } else {
            System.out.println((char) 27 + "[31m\nCliente não encontrado\u001B[0m");
        }
    }
;

}
