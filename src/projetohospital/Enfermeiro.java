package projetohospital;

public class Enfermeiro extends Funcionario {

    public Enfermeiro() {
    }

    public Enfermeiro(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String doencas, String sexo, String profissao, String senha) {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, doencas, sexo, profissao, senha);
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
                        + "\nStatus: %s"
                        + "\nEndereço: %s    "
                        + "\nDoenças:%s"
                        + "\nprofissao: %s"
                        + "\nsenha: %s", getNome(), getNome(), getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getStatus(), getEndereco(), getDoencas(), getProfissao(), getSenha());
        return texto;
    }
}
