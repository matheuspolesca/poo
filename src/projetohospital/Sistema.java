package projetohospital;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Sistema {

    private static ArrayList<Cliente> clientes = new ArrayList();
    private static ArrayList<Doenca> doencas = new ArrayList();
    private static Funcionario funcionarios[] = new Funcionario[100];
    private static int numClientes, numFuncionarios;
    private static String profissao = "NULL";
    protected static int numClientesProtected;

    public Sistema() {
        numClientes = 0;
        numClientesProtected = 0;
        numFuncionarios = 0;
    }

    //Quando o sistema abre, a pessoa precisa fazer o login
    public static void fazerLogin() {

        System.out.println("\n========== LOGIN ===========");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nInforme seu CPF:");
        String cpf = sc.nextLine();
        Funcionario funcLogin = new Funcionario();

        //Confere se já existe o CPF 
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcLogin = funcionario;
                System.out.println((char) 27 + "[32mCPF encontrado\u001B[0m");
                break;
            }
        }

        //Se existir o CPF, confere se a senha está correta
        if (funcLogin.getCpf() != null) {

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

//    private static boolean verificaCadastro<T>(T lista){
//        return true;
//    }
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
                        adicionaDoencaAoCliente(novoCliente);
                    }
                }

                //Se algum campo obrigatório estiver vazio, retorna mensagem de erro, se não, cadastra o cliente
                if (novoCliente.getNome().isEmpty() || novoCliente.getSobrenome().isEmpty() || novoCliente.getIdade() <= 0 || novoCliente.getTelefone().isEmpty() || novoCliente.getEmail().isEmpty() || novoCliente.getCpf().isEmpty() || novoCliente.getSexo().isEmpty()) {
                    throw new Exception("Campo Obrigatório não foi preenchido.");
                }
                clientes.add(novoCliente);
                System.out.println((char) 27 + "[32mCliente cadastrado com sucesso.\u001B[0m");

            } catch (Exception ex) {
                System.out.println((char) 27 + "[31m" + ex.getMessage() + "\u001B[0m");
            }

        } catch (Exception ex) {
            System.out.println((char) 27 + "[31m" + ex.getMessage() + "\u001B[0m");
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
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setNome(nomeC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso.\u001B[0m");
                        }
                        break;
                    case 2:
                        System.out.println("\nNovo Sobrenome:");
                        String sobrenomeC = sc.nextLine();

                        if (sobrenomeC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setSobrenome(sobrenomeC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 3:
                        System.out.println("\nNova Idade:");
                        int idadeC = sc.nextInt();

                        if (idadeC <= 0) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setIdade(idadeC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso.\u001B[0m");
                        }
                        break;
                    case 4:
                        System.out.println("\nNovo Telefone:");
                        String telefoneC = sc.nextLine();

                        if (telefoneC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setTelefone(telefoneC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 5:
                        System.out.println("\nNovo E-mail:");
                        String emailC = sc.nextLine();

                        if (emailC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setEmail(emailC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 6:
                        System.out.println("\nNovo Endereço:");
                        String enderecoC = sc.nextLine();
                        clientes.get(busca).setEndereco(enderecoC);
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 7:
                        System.out.println("\nNovo CPF:");
                        String cpfC = sc.nextLine();

                        if (cpfC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setCpf(cpfC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 8:
                        System.out.println("\nNova Doença:");
                        alterarDoenca(clientes.get(busca));

                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 9:
                        System.out.println("\nNovo Sexo:");
                        String sexoC = sc.nextLine();
                        if (sexoC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            clientes.get(busca).setSexo(sexoC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 10:
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
                    System.out.println((char) 27 + "[32mCliente deletado.\u001B[0m");
                    return;
                }
            }
            throw new Exception("Cliente não encontrado.");
        } catch (Exception ex) {
            System.out.println((char) 27 + "[31m" + ex.getMessage() + "\u001B[0m");
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
                        System.err.println("Error: Não pode selecionar dois períodos iguais.");
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
            System.out.println((char) 27 + "[32mFuncionario cadastrado com sucesso.\u001B[0m");

        } catch (Exception ex) {
            System.out.println((char) 27 + "[31m" + ex.getMessage() + "\u001B[0m");
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
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setNome(nomeC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso.\u001B[0m");
                        }
                        break;
                    case 2:
                        System.out.println("\nNovo Sobrenome:");
                        String sobrenomeF = sc.nextLine();

                        if (sobrenomeF.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setSobrenome(sobrenomeF);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 3:
                        System.out.println("\nNova Idade:");
                        int idadeF = sc.nextInt();

                        if (idadeF <= 0) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setIdade(idadeF);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso.\u001B[0m");
                        }
                        break;
                    case 4:
                        System.out.println("\nNovo Telefone:");
                        String telefoneC = sc.nextLine();

                        if (telefoneC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setTelefone(telefoneC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 5:
                        System.out.println("\nNovo E-mail:");
                        String emailC = sc.nextLine();

                        if (emailC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setEmail(emailC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 6:
                        System.out.println("\nNovo Endereço:");
                        String enderecoC = sc.nextLine();
                        funcionario.setEndereco(enderecoC);
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 7:
                        System.out.println("\nNovo CPF:");
                        String cpfC = sc.nextLine();

                        if (cpfC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setCpf(cpfC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 8:
                        System.out.println("\nNovo Sexo:");
                        String sexoC = sc.nextLine();
                        if (sexoC.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setSexo(sexoC);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        }
                        break;
                    case 9:
                        System.out.println("\nNova Senha:");
                        String senha = sc.nextLine();
                        if (senha.isEmpty()) {
                            System.out.println((char) 27 + "[31m\nNão pode ser alterado para um campo vazio.\u001B[0m");
                        } else {
                            funcionario.setSenha(senha);
                            System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
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
                                System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                        }
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
            System.out.println((char) 27 + "[31m\nFuncionario não encontrado\u001B[0m");
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

    public static void iniciarAtendimento() {

        System.out.println("\n========= INICIAR ATENDIMENTO =========");
        int busca = pesquisarCliente();

        try {
            if (busca >= 0) {
                System.out.println((char) 27 + "[32m\nAtendimento do cliente " + clientes.get(busca).getNome() + " iniciado.\u001B[0m");
                clientes.get(busca).setStatus("Aguardando triagem.");
            } else {
                throw new Exception("Cliente não encontrado.");
            }
        } catch (Exception ex) {
            System.out.println((char) 27 + "[31m" + ex.getMessage() + "\u001B[0m");
        }
    }

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

    public static void encerrarAtendimento() {
        System.out.println("\n========= ENCERRAR ATENDIMENTO =========");

        //Conferir se o paciente existe
        int busca = pesquisarCliente();

        if (busca >= 0) {
            System.out.println((char) 27 + "[32m\nAtendimento do cliente " + clientes.get(busca).getNome() + " finalizado.\u001B[0m");
            clientes.get(busca).setStatus("Liberado");
        } else {
            System.out.println((char) 27 + "[31m\nCliente não encontrado\u001B[0m");
        }
    }

    //Acessar informações sobre o cliente
    public static void acessarInformações() {

        //Apenas médicos ou o Administrador pode ter acesso as informações
        if ("Medico".equals(profissao) || "Administrador".equals(profissao)) {

            System.out.println("\n========= ACESSAR INFORMAÇÕES =========");

            //Conferir se o paciente existe
            int busca = pesquisarCliente();

            if (busca >= 0) {
                System.out.println(clientes.get(busca).toString());
                //to do - Concertar a impressão
                System.out.println("Doencas do paciente: ");
                for (int i = 0; i < clientes.get(busca).getClienteDoencas().size(); i++) {
                    System.out.println(clientes.get(busca).getClienteDoencas().get(i).getNome());
                }
            } else {
                System.out.println((char) 27 + "[31m\nCliente não encontrado\u001B[0m");
            }
        } else {
            System.out.println((char) 27 + "[31m\nVocê não tem permissão para acessar essa opção.\u001B[0m");
        }

    }

    public static void gerarRelatorio() {
        System.out.println("\n========= RELATÓRIO =========");
        System.out.println("\nDigite somente o número da opção desejada:"
                + "\n\n1 - Lista de Clientes"
                + "\n2 - Lista de Funcionários"
                + "\n3 - Lista de Doenças"
                + "\n5 - Fechar\n");
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
                System.out.println(numFuncionarios);
                System.out.println("\nLista de Funcionarios");
                relatorioFuncionarios();
                break;

            case 3:
                System.out.println("\nLista de Doenças:");
                relatorioDoencas();
                break;

            default:
                System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
        }
    }

    public static void relatorioClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).toString());
        }
    }

    public static void relatorioFuncionarios() {

        for (int i = 0; i < numFuncionarios; i++) {
            System.out.println(funcionarios[i].toString());
            System.out.println("Plantão:");
            for (Plantao periodo : funcionarios[i].getPeriodo()) {
                System.out.println(Plantao.values()[periodo.getDescricao() - 1]);
            }
        }

    }

    public static void relatorioDoencas() {
        for (int i = 0; i < doencas.size(); i++) {
            System.out.println(doencas.get(i).getNome() + ": " + doencas.get(i).getQtdPacientes() + " caso(s).");
            if (doencas.get(i).getQtdPacientes() > 0) {
                System.out.println("Os clientes com essa doenca sao: ");
                for (int j = 0; j < doencas.get(i).getDoencaClientes().size(); j++) {
                    System.out.println(doencas.get(i).getDoencaClientes().get(j).getNome());
                }
            }
        }
    }

    public static void relatorioPacientes() {
        System.out.println(clientes.size());
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
                    System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
            }
        } while (sair != true);
    }

    public static void alterarPlantao() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Plantao> periodo = new ArrayList<>();
        Funcionario funcionario = pesquisarFuncionario();

        System.out.println("\nQuantos turnos você trabalha? (MAX 3)");
        int opc = sc.nextInt();
        try {
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
                        System.err.println("Error: Não pode selecionar dois períodos iguais.");
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
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void adicionaDoencaAoCliente(Cliente cliente) {
        int indiceDoenca = pesquisarDoenca();
        if (indiceDoenca >= 0) {
            boolean existe = false;
            for (int i = 0; i < cliente.getClienteDoencas().size(); i++) {
                if (indiceDoenca == cliente.getClienteDoencas().get(i).getIdDoenca()) {
                    existe = true;
                    break;
                }
            }
            if (existe == false) {
                cliente.getClienteDoencas().add(doencas.get(indiceDoenca));
                doencas.get(indiceDoenca).getDoencaClientes().add(cliente);
                doencas.get(indiceDoenca).setQtdPacientes(+1);
                System.out.println((char) 27 + "[32m\nDoenca registrada com sucesso.\u001B[0m");
            } else {
                System.out.println((char) 27 + "[31m\nDoenca já registrada no cliente.\u001B[0m");
            }
        }
    }

    public static void excluiDoencaDoCliente(Cliente cliente) {
        if (cliente.getClienteDoencas().isEmpty()) {
            System.out.println((char) 27 + "[31m\nCliente sem doenças cadastradas.\u001B[0m");
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
            System.out.println((char) 27 + "[32m\nDoenca excluida com sucesso.\u001B[0m");
        }
    }

    public static int pesquisarDoenca() {
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

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Sistema.clientes = clientes;
    }

    public static ArrayList<Doenca> getDoencas() {
        return doencas;
    }

    public static void setDoencas(ArrayList<Doenca> doencas) {
        Sistema.doencas = doencas;
    }

    public static Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public static void setFuncionarios(Funcionario[] funcionarios) {
        Sistema.funcionarios = funcionarios;
    }

    public static int getNumClientes() {
        return numClientes;
    }

    public static void setNumClientes(int numClientes) {
        Sistema.numClientes += numClientes;
    }

    public static int getNumFuncionarios() {
        return numFuncionarios;
    }

    public static void setNumFuncionarios(int numFuncionarios) {
        Sistema.numFuncionarios += numFuncionarios;
    }

    public static String getProfissao() {
        return profissao;
    }

    public static void setProfissao(String profissao) {
        Sistema.profissao = profissao;
    }

    public static int getNumClientesProtected() {
        return numClientesProtected;
    }

    public static void setNumClientesProtected(int numClientesProtected) {
        Sistema.numClientesProtected += numClientesProtected;
    }
}
