package model;

import controller.FuncionarioApplication;
import java.util.ArrayList;

/**Classe responsável por modelar o funcionário
 * 
 * 
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 * 
 */
public class Funcionario extends Pessoa{

    /**
     *
     */
    public  String profissao, senha;

    /**
     * 
     */
    private ArrayList<Plantao> periodo;
            
    /**
     * Construtor padrão da classe
     */
    public Funcionario() {
    }

    /**
     * Construtor adicional da classe
     * @param nome - String
     * @param sobrenome - String
     * @param idade - int
     * @param telefone - String
     * @param email - String
     * @param endereco - String
     * @param cpf - String
     * @param sexo - String
     * @param profissao - String
     * @param senha - String
     * @param periodo - ArrayList
     */
    public Funcionario (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo, String profissao, String senha, ArrayList<Plantao> periodo)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo);
        this.profissao = profissao;
        this.senha = senha;
        FuncionarioApplication.setNumFuncionarios(+1);
        this.periodo =  periodo;
    }

    /**
     * Método responsável por captar o período de plantão do funcionário
     * @return
     */
    public  ArrayList<Plantao> getPeriodo() {
        return periodo;
    }

    /**
     * Método responsável por definir o período de plantão do funcionário
     * @param periodo
     */
    public void setPeriodo(ArrayList<Plantao> periodo) {
        this.periodo = periodo;
    }

    /**
     * Método responsável por captar a profissão do funcionário
     * @return
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Método responsável por definir a profissão do funcionário
     * @param profissao
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    /**
     * Método responsável por captar a senha do funcionário
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Método responsável por definir a senha do funcionário
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Método responsável por retornar o funcionário
     * @return string
     */
    @Override
    public String toString() {
        String texto = String.format("\n========== FUNCIONÁRIO: %s ========"
                + "\nNome: %s"
                + "\nSobrenome: %s"
                + "\nIdade: %d"
                + "\nCPF: %s"
                + "\nTelefone: %s"
                + "\nE-mail %s"
                + "\nSexo: %s"
                + "\nEndereço: %s    "
                + "\nProfissao: %s"
                + "\nSenha: %s", getNome(), getNome(),getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getEndereco(), getProfissao(), getSenha());
        return texto;
    }
}
