package projetohospital;

public class Medico extends Funcionario{

    public Medico() {
    }

    public Medico(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String doencas, String sexo, String profissao, String senha) {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, doencas, sexo, profissao, senha);
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
                        + "\nStatus: %s"
                        + "\nEndereço: %s    "
                        + "\nDoenças:%s"
                        + "\nprofissao: %s"
                        + "\nsenha: %s", getNome(), getNome(), getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getStatus(), getEndereco(), getDoencas(), getProfissao(), getSenha());
        return texto;
    }
}
