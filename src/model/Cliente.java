package model;

import controller.ClienteApplication;
import model.Pessoa;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa{
    private String status;
    private ArrayList<Doenca> clienteDoencas = new ArrayList();

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
                + "\nStatus: %s", getNome(), getNome(),getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getEndereco(), status);
        return texto;
    }
}
