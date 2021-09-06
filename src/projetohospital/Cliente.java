package projetohospital;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa{
    private String status;
    private ArrayList<Doenca> clienteDoencas = new ArrayList();
    private IdTriagem idTriagem;

    public Cliente() {
    }
    
    public Cliente (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo);
        Sistema.numClientesProtected++;
        Sistema.setNumClientes(+1);
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
                + "\nIdTriagem: %s", getNome(), getNome(),getSobrenome(), getIdade(), getCpf(), getTelefone(), getEmail(), getSexo(), getEndereco(), status, idTriagem);
        return texto;
    }
}
