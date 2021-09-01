package projetohospital;

public class Cliente {
    private String nome, telefone, email, endereco, cpf, doencas, sexo, status;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String email, String endereco, String cpf, String doencas, String sexo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.doencas = doencas;
        this.sexo = sexo;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
                        + "\nCPF: %s"
                        + "\nTelefone: %s"
                        + "\nE-mail %s"
                        + "\nSexo: %s"
                        + "\nStatus: %s"
                        + "\nEndereço: %s    "
                        + "\nDoenças:%s", nome, nome, cpf, telefone, email, sexo, status, endereco, doencas);
        return texto;
    }

}
