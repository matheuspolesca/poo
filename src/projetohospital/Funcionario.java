package projetohospital;

import java.util.ArrayList;

public class Funcionario extends Pessoa{
    private String profissao, senha;
    private ArrayList<Plantao> periodo;
            
    public Funcionario() {
    }

    public Funcionario (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo, String profissao, String senha, ArrayList<Plantao> periodo)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo);
        this.profissao = profissao;
        this.senha = senha;
        Sistema.setNumFuncionarios(+1);
        this.periodo =  periodo;
    }

    public  ArrayList<Plantao> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(ArrayList<Plantao> periodo) {
        this.periodo = periodo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
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
