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
    
    public static void menuSistema(){
        boolean valor = true;
        while(valor!=false){
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite somente o número da opção desejada:"
                                + "\n1 - Cadastrar Cliente, 2 - Iniciar Atendimento, 3 - Alterar Cadastro Cliente,"
                                + "\n4 - Analise Previa, 5 - Acessar Informacoes do Paciente, 6 - Encerrar Atendimento,"
                                + "\n7 - Emitir Relatorios, 8 - Cadastrar Funcionario, 9 - Alterar Cadastro Funcionario"
                                + "\n10 - Excluir Funcionario, 11 - Excluir Paciente, 12 - Encerrar Sistema");
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
    
    public static void fazerLogin(){
        boolean verificaCpf=false;
        int pos=0;
        
        while(verificaCpf==false){
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe seu CPF:");
            String cpf = sc.nextLine();
            for(int i=0; i<numeroFuncionarios; i++){
                if(funcionarios[i].getCpf().equals(cpf)){
                    verificaCpf=true;
                    pos=i;
                    System.out.println("CPF encontrado.");
                }
            }
            if(verificaCpf==true)
                break;
            System.out.println("CPF não encontrado, tente novamente.");
        }
        
        boolean verificaSenha=false;
        while(verificaSenha==false){
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe sua senha:");
            String senha = sc.nextLine();
            if(funcionarios[pos].getSenha().equals(senha)){
                verificaSenha=true;
                System.out.println("Senha confirmada");
            }
            if(verificaSenha==true)
                break;
            else
                System.out.println("Senha não compativel, tente novamente");
        }
        
        if((verificaCpf==true) && (verificaSenha==true))
            profissao = funcionarios[pos].getProfissao();
        
         System.out.println("Você esta logado no sistema como " + profissao + ".");
    };
    
    public static void cadastrarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o nome do seu cliente?");
        String nome = sc.nextLine();
        System.out.println("Qual o telefone do seu cliente?");
        String telefone = sc.nextLine();
        System.out.println("Qual o email do seu cliente?");
        String email = sc.nextLine();
        System.out.println("Qual o endereço do seu cliente?");
        String endereco = sc.nextLine();
        System.out.println("Qual o cpf do seu cliente?");
        String cpf = sc.nextLine();
        System.out.println("Qual são as doenças?");
        String doenca = sc.nextLine();
        System.out.println("Qual o sexo do seu cliente?");
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
