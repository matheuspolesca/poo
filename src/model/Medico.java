package model;

import model.Funcionario;
import java.util.ArrayList;

/**
 * Classe responsável por modelar os Médicos
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 */
public class Medico extends Funcionario{

    /**
     * Construtor padrão da classe
     */
    public Medico() {
    }

    /**
     * Construtor adicional da classe
     * @param nome -  String
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
    public Medico(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo, String profissao, String senha, ArrayList<Plantao> periodo) {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo, profissao, senha, periodo);
        super.setProfissao("Medico");
    }
    
    
    /**
     * Método responsável por retornar o médico
     * @return string
     */
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
