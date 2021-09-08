package model;

import java.util.ArrayList;

/**Classe responsável por modelar o enfermeiro
 * 
 * 
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 * 
 */
public class Enfermeiro extends Funcionario {

    /**
     * Construtor padrão da classe
     */
    public Enfermeiro() {
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
    public Enfermeiro(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo, String profissao, String senha, ArrayList<Plantao> periodo) {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo, profissao, senha, periodo);
        super.setProfissao("Enfermeiro");
    }

    /**
     * Método responsável por retornar o enfermeiro
     * @return string
     */
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
