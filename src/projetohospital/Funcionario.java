package projetohospital;

public class Funcionario extends Cliente{
    private String profissao, senha;

    public Funcionario() {
    }

    public Funcionario
        (String nome, String telefone, String email, String endereco, 
         String cpf, String doencas, String sexo, String profissao, String senha) 
    {
        super(nome, telefone, email, endereco, cpf, doencas, sexo);
        this.profissao=profissao;
        this.senha=senha;
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
        return "Funcionario{" + "nome=" + getNome() + ", telefone=" + getTelefone() + ", email=" + getEmail() + ", endereco=" + getEndereco() + ", cpf=" + getCpf() + ", doencas=" + getDoencas() + ", sexo=" + getSexo() + ", status=" + getStatus() + "profissao=" + profissao + ", senha=" + senha + '}';
    }
}
