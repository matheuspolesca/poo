package projetohospital;

public class Enfermeiro extends Funcionario {

    public Enfermeiro() {
    }

    public Enfermeiro(String nome, String telefone, String email, String endereco, String cpf, String doencas, String sexo, String profissao, String senha) {
        super(nome, telefone, email, endereco, cpf, doencas, sexo, profissao, senha);
        super.setProfissao("Enfermeiro");
    }

    @Override
    public String toString() {
        return "Enfermeiro{" + "nome=" + getNome() + ", telefone=" + getTelefone() + ", email=" + getEmail() + ", endereco=" + getEndereco() + ", cpf=" + getCpf() + ", doencas=" + getDoencas() + ", sexo=" + getSexo() + ", status=" + getStatus() + "profissao=" + getProfissao() + ", senha=" + getSenha() + '}';
    }
}
