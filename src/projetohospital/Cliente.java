package projetohospital;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private String status;
    private ArrayList<Doenca> clienteDoencas = new ArrayList();

    public Cliente() {
    }
    
    public Cliente (String nome, String sobrenome, int idade, String telefone, String email, String endereco, String cpf, String sexo)
    {
        super(nome, sobrenome, idade, telefone, email, endereco, cpf, sexo);
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

    public void setClienteDoencas(Doenca doencaCliente) {
        this.clienteDoencas.add(doencaCliente);
        for(int i=0; i<Sistema.doencas.size(); i++){
            if(doencaCliente.getNome().equals(Sistema.doencas.get(i).getNome())){
                Sistema.doencas.get(i).setQtdPacientes(+1);
            }
        }
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
