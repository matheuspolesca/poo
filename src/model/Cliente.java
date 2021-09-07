package model;

import controller.ClienteApplication;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Cliente extends Pessoa implements Comparable <Cliente>{
    private String status;
    private ArrayList<Doenca> clienteDoencas = new ArrayList();
    private IdTriagem idTriagem;
    private Date data;

    public Cliente() {
    }
    
    public Cliente (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo);
        ClienteApplication.getNumClientesProtected();
        ClienteApplication.getNumClientes();
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Doenca> getClienteDoencas() {
        return clienteDoencas;
    }

    public void setClienteDoencas(ArrayList<Doenca> clienteDoencas) {
        this.clienteDoencas = clienteDoencas;
    }

    public IdTriagem getIdTriagem() {
        return idTriagem;
    }

    public void setIdTriagem(IdTriagem idtriagem) {
        this.idTriagem = idtriagem;
    }
    
    public Date getData() {
        return data;
    }
    
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
