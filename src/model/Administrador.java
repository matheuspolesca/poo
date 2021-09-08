package model;

import model.Funcionario;
import java.util.ArrayList;

/**Classe responsável por modelar o administrador
 * 
 * 
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 * 
 */
public class Administrador extends Funcionario{
    
    public Administrador() {
    }

    public Administrador(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo, String profissao, String senha, ArrayList<Plantao> periodo) {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo, profissao, senha, periodo);
        super.setProfissao("Administrador");
    }

    @Override
    public String toString() {
        String texto = String.format("\n========== ENFERMEIRO: %s ========"
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
