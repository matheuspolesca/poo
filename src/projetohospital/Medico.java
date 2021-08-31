package projetohospital;

public class Medico extends Funcionario{

    public Medico() {
    }

    public Medico(String nome, String telefone, String email, String endereco, String cpf, String doencas, String sexo, String profissao, String senha) {
        super(nome, telefone, email, endereco, cpf, doencas, sexo, profissao, senha);
        super.setProfissao("Medico");
    }
    
    @Override
    public String toString() {
        return "Medico{" + "nome=" + getNome() + ", telefone=" + getTelefone() + ", email=" + getEmail() + ", endereco=" + getEndereco() + ", cpf=" + getCpf() + ", doencas=" + getDoencas() + ", sexo=" + getSexo() + ", status=" + getStatus() + '}';
    }
}
