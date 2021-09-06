package projetohospital;

import java.util.ArrayList;

public class Medico extends Funcionario{

    public Medico() {
    }

    public Medico(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo, String profissao, String senha, ArrayList<Plantao> periodo) {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo, profissao, senha, periodo);
        super.setProfissao("Medico");
    }
    
    @Override
    public String toString() {
        String texto = String.format("\n========== MÉDICO: %s ========"
                        + "\nNome: %s"
                        + "\nSobrenome: %s"
                        + "\nIdade: %d"
                        + "\nCPF: %s"
                        + "\nTelefone: %s"
                        + "\nE-mail %s"
                        + "\nSexo: %s"
                        + "\nEndereço: %s    "
                        + "\nProfissao: %s"
                        + "\nSenha: %s", getNome(), getNome(), getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getEndereco(), getProfissao(), getSenha());
        return texto;
    }
}
