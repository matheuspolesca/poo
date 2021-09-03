package projetohospital;

public class Cliente extends Pessoa{
    private String doencas, status;

    public Cliente() {
    }
    
    public Cliente (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo, String doencas)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo);
        this.doencas = doencas;
    }
    
    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String texto = String.format("\n========== CLIENTE: %s ========"
                        + "\nNome: %s"
                        + "\nSobrenome: %s"
                        + "\nIdade: %d"
                        + "\nCPF: %s"
                        + "\nTelefone: %s"
                        + "\nE-mail %s"
                        + "\nSexo: %s"
                        + "\nStatus: %s"
                        + "\nEndereço: %s    "
                        + "\nDoenças:%s", getNome(), getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), status, getEndereco(), doencas);
        return texto;
    }

}
