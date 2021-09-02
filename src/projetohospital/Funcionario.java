package projetohospital;

public class Funcionario extends Cliente{
    private String profissao, senha;

    public Funcionario() {
    }

    public Funcionario (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String doencas, String sexo, String profissao, String senha)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, doencas, sexo);
        this.profissao = profissao;
        this.senha = senha;
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
                        + "\nStatus: %s"
                        + "\nEndereço: %s    "
                        + "\nDoenças:%s"
                        + "\nprofissao: %s"
                        + "\nsenha: %s", getNome(), getNome(),getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getStatus(), getEndereco(), getDoencas(), getProfissao(), getSenha());
        return texto;
    }
}
