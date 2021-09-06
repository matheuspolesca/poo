package projetohospital;

public class Enfermeiro extends Funcionario {

    public Enfermeiro() {
    }

    public Enfermeiro(String nome, String sobrenome, Integer idade, String telefone, String email, String endereco, String cpf, String sexo, String profissao, String senha) {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo, profissao, senha);
        super.setProfissao("Enfermeiro");
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
