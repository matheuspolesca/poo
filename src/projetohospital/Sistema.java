package projetohospital;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Sistema {
    public static ArrayList<Cliente> clientes = new ArrayList();
    public static Funcionario funcionarios[] = new Funcionario[100];
    public static String profissao = "NULL";
    public static int numeroClientes = 0, numeroFuncionarios = 0;
    
    public Sistema() {
    }
    
    //Quando o sistema abre, a pessoa precisa fazer o login
    public static void fazerLogin(){
        boolean verificaCpf=false;
        int pos=0;
        System.out.println("\n========== LOGIN ===========");
        
        //Verifica se o CPF informado está correto
        while(verificaCpf==false){
            Scanner sc = new Scanner(System.in);
            System.out.println("\nInforme seu CPF:");
            String cpf = sc.nextLine();
            for(int i=0; i<numeroFuncionarios; i++){
                if(funcionarios[i].getCpf().equals(cpf)){
                    verificaCpf=true;
                    pos=i;
                    System.out.println((char)27 + "[32mCPF encontrado\u001B[0m");
                }
            }
            if(verificaCpf==true)
                break;
            System.out.println((char)27 + "[31mCPF não encontrado, tente novamente.\u001B[0m");
        }
        
        //Verifica se a senha informado está correta
        boolean verificaSenha=false;
        while(verificaSenha==false){
            Scanner sc = new Scanner(System.in);
            System.out.println("\nInforme sua senha:");
            String senha = sc.nextLine();
            if(funcionarios[pos].getSenha().equals(senha)){
                verificaSenha=true;
                System.out.println((char)27 + "[32mSenha confirmada\u001B[0m");
                break;
            }
            else
                System.out.println((char)27 + "[31mSenha não compativel, tente novamente\u001B[0m");
        }
        
        if((verificaCpf==true) && (verificaSenha==true))
            profissao = funcionarios[pos].getProfissao();
        
         System.out.println((char)27 + "[30mVocê esta logado no sistema como " + profissao + ".\u001B[0m");
    };
    
    public static void menuSistema(){
        boolean valor = true;
        while(valor!=false){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n========= MENU =========");
            System.out.println("\nDigite somente o número da opção desejada:"
                                + "\n\n1 - Cadastrar Cliente                     2 - Iniciar Atendimento"
                                + "\n3 - Alterar Cadastro Cliente              4 - Analise Previa"
                                + "\n5 - Acessar Informacoes do Paciente       6 - Encerrar Atendimento,"
                                + "\n7 - Emitir Relatorios                     8 - Cadastrar Funcionario"
                                + "\n9 - Alterar Cadastro Funcionario         10 - Excluir Funcionario"
                                + "\n11 - Excluir Paciente                    12 - Encerrar Sistema\n");
            int acesso = sc.nextInt();
            switch (acesso) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    iniciarAtendimento();
                    break;
                case 3:
                    alterarCadastroCliente();
                    break;
                case 4:
                    analisePrevia();
                    break;
                case 5:
                    acessarInformações();
                    break;
                case 6:
                    encerrarAtendimento();
                    break;
                case 7:
                    gerarRelatorio();
                    break;
                case 8:
                    //cadastrarFuncionario
                case 9:
                    //alterarCadastroFuncionario
                case 10:
                    //excluirFuncionario
                case 11:
                    //excluirPaciente
                case 12:
                    System.out.println("Sistema finalizado.");
                    valor=false;
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    };
    
    public static void cadastrarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========= CADASTRAR CLIENTE =========");
        System.out.println("\nQual o nome do seu cliente?");
        String nome = sc.nextLine();
        System.out.println("\nQual o telefone do seu cliente?");
        String telefone = sc.nextLine();
        System.out.println("\nQual o email do seu cliente?");
        String email = sc.nextLine();
        System.out.println("\nQual o endereço do seu cliente?");
        String endereco = sc.nextLine();
        System.out.println("\nQual o cpf do seu cliente?");
        String cpf = sc.nextLine();
        System.out.println("\nQual são as doenças?");
        String doenca = sc.nextLine();
        System.out.println("\nQual o sexo do seu cliente?");
        String sexo = sc.nextLine();
        Cliente novoCliente = new Cliente(nome, telefone, email, endereco, cpf, doenca, sexo);
        numeroClientes++;
        clientes.add(novoCliente);
    };
    
    public static void iniciarAtendimento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o nome do Cliente?");
        String nome = sc.nextLine();
        
        boolean busca=false;
        int pos=0;
            
        while(busca==false){
            for(int i=0; i<clientes.size(); i++){
                if(clientes.get(i).getNome().equals(nome)){
                    busca=true;
                    pos=i;
                }
            }
            if(busca=true)
                break;
            System.out.println("Nome não encontrado.");
        }
            
        if(busca=true){
            System.out.println("Atendimento do cliente" + clientes.get(pos).getNome() + " iniciado.");
            clientes.get(pos).setStatus("Aguardando triagem.");
        }
    };
    
    public static void alterarCadastroCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o nome do Cliente?");
        String nome = sc.nextLine();
        
        boolean busca=false;
        int pos=0;
            
        while(busca==false){
            for(int i=0; i<clientes.size(); i++){
                if(clientes.get(i).getNome().equals(nome)){
                    busca=true;
                    pos=i;
                }
            }
            if(busca=true)
                break;
            System.out.println("Nome não encontrado.");
        }
            
        if(busca=true){
            boolean valor = true;
            while(valor!=false){
                System.out.println("Digite o número referente ao atributo que deseja alterar:"
                                    + "\n1 - Nome, 2 - Telefone, 3 - E-mail, 4 - Endereço"
                                    + "\n5 - CPF, 6 - Doenças, 7 - Sexo,"
                                    + "\n8 - Finalizar Alteracoes");
                int acesso = sc.nextInt();
                switch (acesso) {
                    case 1:
                        System.out.println("Qual o novo nome do seu cliente?");
                        clientes.get(pos).setNome(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Qual o novo telefone do seu cliente?");
                        clientes.get(pos).setTelefone(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Qual o novo e-mail do seu cliente?");
                        clientes.get(pos).setEmail(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Qual o novo endereco do seu cliente?");
                        clientes.get(pos).setEndereco(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Qual o novo CPF do seu cliente?");
                        clientes.get(pos).setCpf(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Qual as novas doencas do seu cliente?");
                        clientes.get(pos).setDoencas(sc.nextLine());
                        break;
                    case 7:
                        System.out.println("Qual o novo sexo do seu cliente?");
                        clientes.get(pos).setSexo(sc.nextLine());
                        break;
                    case 8:
                        System.out.println("Alterações finalizadas.");
                        valor=false;
                        break;
                    default:
                        System.out.println("Opção invalida");
                }
            }
        }
    };
    
    public static void gerarRelatorio(){
        
    };
    
    public static void analisePrevia(){
        if("Enfermeiro".equals(profissao) || "Administrador".equals(profissao)){
            Scanner sc = new Scanner(System.in);
            System.out.println("Qual o nome do Cliente?");
            String nome = sc.nextLine();
            
            boolean busca=false;
            int pos=0;
            
            while(busca==false){
                for(int i=0; i<clientes.size(); i++){
                    if(clientes.get(i).getNome().equals(nome)){
                        busca=true;
                        pos=i;
                    }
                }
                if(busca=true)
                    break;
                System.out.println("Nome não encontrado.");
            }
            
            if(busca=true){
                System.out.println("Qual o novo status do paciente?");
                clientes.get(pos).setStatus(sc.nextLine());
            }
        }
        else
            System.out.println("Você não tem permissão para acessar essa opção.");
    };
    
    public static void acessarInformações(){
        if("Medico".equals(profissao) || "Administrador".equals(profissao)){
            Scanner sc = new Scanner(System.in);
            System.out.println("Qual o nome do Cliente?");
            String nome = sc.nextLine();
            
            boolean busca=false;
            int pos=0;
            
            while(busca==false){
                for(int i=0; i<clientes.size(); i++){
                    if(clientes.get(i).getNome().equals(nome)){
                        busca=true;
                        pos=i;
                    }
                }
                if(busca=true)
                    break;
                System.out.println("Nome não encontrado.");
            }
            
            if(busca=true)
                    System.out.println(clientes.get(pos).toString());
        }
        else
            System.out.println("Você não tem permissão para acessar essa opção.");
    };
    
    public static void encerrarAtendimento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o nome do Cliente?");
        String nome = sc.nextLine();
        
        boolean busca=false;
        int pos=0;
            
        while(busca==false){
            for(int i=0; i<clientes.size(); i++){
                if(clientes.get(i).getNome().equals(nome)){
                    busca=true;
                    pos=i;
                }
            }
            if(busca=true)
                break;
            System.out.println("Nome não encontrado.");
        }
            
        if(busca=true){
            System.out.println("Atendimento do cliente" + clientes.get(pos).getNome() + "finalizado.");
            clientes.get(pos).setStatus("Aguardando triagem.");
        }
    };
    
}
