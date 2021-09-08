package model;

/**
 * 
 * Classe modelo para pacientes e funcionários
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 */
abstract class Pessoa {
    /**
     *
     */
    private String nome, sobrenome, telefone, email, endereco, cpf, sexo;
    
    /**
     *
     */
    private Integer idade;
    
    /**
     * Construtor padrão da classe
     */
    public Pessoa() {
    }

    /**
     * Construtor adicional da classe
     * @param nome -  String
     * @param sobrenome - String
     * @param idade - int
     * @param telefone - String
     * @param email - String
     * @param endereco - String
     * @param cpf - String
     * @param sexo - String
     */
    public Pessoa(String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.sexo = sexo;
    }
    
    /**
     * Obtém o nome da pessoa
     * @return string
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome da pessoa
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

     /**
     * Obtém o sobrenome da pessoa
     * @return string
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Define o sobrenome da pessoa
     * @param sobrenome
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    /**
     * Obtém a idade da pessoa
     * @return int
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * Define a idade da pessoa
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Obtém o telefone da pessoa
     * @return string
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o e-mail da pessoa
     * @return string
     */
    public String getEmail() {
        return email;
    }

     /**
     * Define o e-mail da pessoa
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o endereço da pessoa
     * @return string
     */
    public String getEndereco() {
        return endereco;
    }

     /**
     * Define o endereço da pessoa
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o cpf da pessoa
     * @return string
     */
    public String getCpf() {
        return cpf;
    }

     /**
     * Define o cpf da pessoa
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * Obtém o sexo da pessoa
     * @return string
     */
    public String getSexo() {
        return sexo;
    }

     /**
     * Define o sexo da pessoa
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /**
    * Retorna a pessoa atual
    * @return string
    */
    @Override
    public String toString() {
        String texto = String.format("\n========== PESSOA: %s ========"
                        + "\nNome: %s"
                        + "\nSobrenome: %s"
                        + "\nIdade: %d"
                        + "\nCPF: %s"
                        + "\nTelefone: %s"
                        + "\nE-mail %s"
                        + "\nSexo: %s"
                        + "\nEndereço:%s", nome, nome, sobrenome, idade, cpf, telefone, email, sexo, endereco);
        return texto;
    }

}
