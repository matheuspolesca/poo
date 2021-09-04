package projetohospital;

import java.util.ArrayList;

public class Doenca {
    private String nome;
    private int idDoenca, qtdPacientes;
    private ArrayList<Cliente> doencaClientes = new ArrayList();

    public Doenca() {
    }

    public Doenca(String nome, int idDoenca) {
        this.nome = nome;
        this.idDoenca = idDoenca;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdPacientes() {
        return qtdPacientes;
    }

    public void setQtdPacientes(int qtdPacientes) {
        this.qtdPacientes = qtdPacientes;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }
    
    public ArrayList<Cliente> getDoencaClientes() {
        return doencaClientes;
    }
    
    public void setDoencaClientes(Cliente clienteDoenca) {
        this.doencaClientes.add(clienteDoenca);
    }
    
    @Override
    public String toString() {
        String texto = String.format("\n========== DOENCAS: %s ========"
                + "\nNome: %s    "
                + "\nQuantidade de Pacientes: %s", nome, qtdPacientes);
        return texto;
    }
}
