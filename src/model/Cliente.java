package model;

import controller.ClienteApplication;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**Classe responsável por modelar o cliente
 * 
 * 
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 * 
 */
public class Cliente extends Pessoa implements Comparable <Cliente>{
    private String status;
    private ArrayList<Doenca> clienteDoencas = new ArrayList();
    private IdTriagem idTriagem;
    private Date data;

    /**
     * Construtor padrão da classe
     */
    public Cliente() {
    }
    
    /**
     * Construtor adicional da classe
     * @param nome
     * @param sobrenome
     * @param idade
     * @param telefone
     * @param email
     * @param endereco
     * @param cpf
     * @param sexo
     */
    public Cliente (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo);
        ClienteApplication.getNumClientesProtected();
        ClienteApplication.getNumClientes();
    }
    
    /**
     * Obtém o status do cliente
     * @return string
     */ 
    public String getStatus() {
        return status;
    }

    /**  
     * Define o status do cliente
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtém as doenças de um cliente
     * @return ArrayList
     */
    public ArrayList<Doenca> getClienteDoencas() {
        return clienteDoencas;
    }

    /**
     * Define as doenças de um cliente
     * @param clienteDoencas
     */
    public void setClienteDoencas(ArrayList<Doenca> clienteDoencas) {
        this.clienteDoencas = clienteDoencas;
    }

    /**
     * Obtém o id de triagem de um cliente
     * @return
     */
    public IdTriagem getIdTriagem() {
        return idTriagem;
    }

    /**
     * Define o id de triagem de um cliente
     * @param idtriagem
     */
    public void setIdTriagem(IdTriagem idtriagem) {
        this.idTriagem = idtriagem;
    }
    
    /**
     * Obtém a data 
     * @return date
     */
    public Date getData() {
        return data;
    }
    
    /**
     * Define a data
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
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
                + "\nEndereço: %s    "
                + "\nStatus: %s    "
                + "\nData: %s    "
                + "\nIdTriagem: %s", getNome(), getNome(),getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getEndereco(), status, data, idTriagem);
        return texto;
    }
    
    /**
     *
     * @param cliente
     * @return
     */
    @Override
    
    public int compareTo(Cliente cliente) {
        if(this.getIdTriagem()!= cliente.getIdTriagem()){
            return this.getIdTriagem().compareTo(cliente.getIdTriagem());
        }
        if(this.getData() != cliente.getData()){
            return this.getData().compareTo(cliente.getData());
        }
        else if(this.getClienteDoencas().size() != cliente.getClienteDoencas().size()){
            return Integer.valueOf(this.getClienteDoencas().size()).compareTo((cliente.getClienteDoencas().size()));
        }
        else if(!Objects.equals(this.getIdade(), cliente.getIdade())){
            return this.getIdade().compareTo(cliente.getIdade());
        }
        else if(this.getNome() == null ? cliente.getNome() != null : !this.getNome().equals(cliente.getNome())){
            return this.getNome().compareTo(cliente.getNome());
        }
        return this.getSobrenome().compareTo(cliente.getSobrenome());
    }
}
