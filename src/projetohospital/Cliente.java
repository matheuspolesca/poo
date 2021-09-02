package projetohospital;

public class Cliente {
    private String nome, sobrenome, telefone, email, endereco, cpf, doencas, sexo, status;
    private int idade;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String doencas, String sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
                        + "\nSobrenome: %s"
                        + "\nIdade: %d"
                        + "\nCPF: %s"
                        + "\nTelefone: %s"
                        + "\nE-mail %s"
                        + "\nSexo: %s"
                        + "\nStatus: %s"
                        + "\nEndereço: %s    "
                        + "\nDoenças:%s", nome, nome, sobrenome, idade, cpf, telefone, email, sexo, status, endereco, doencas);
        return texto;
    }

}
