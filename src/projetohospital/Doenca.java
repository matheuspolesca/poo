package projetohospital;

import java.util.ArrayList;

public class Doenca {
    private String nome;
    private static int totDoencas;
    private int idDoenca, qtdPacientes;
    private ArrayList<Cliente> doencaClientes = new ArrayList();

    public Doenca() {
    }

    public Doenca(String nome) {
        this.nome = nome;
        this.idDoenca = totDoencas;
        totDoencas++;
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
        this.qtdPacientes += qtdPacientes;
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

    public void setDoencaClientes(ArrayList<Cliente> doencaClientes) {
        this.doencaClientes = doencaClientes;
    }

    public static int getTotDoencas() {
        return totDoencas;
    }

    public static void setTotDoencas(int totDoencas) {
        Doenca.totDoencas = totDoencas;
    }
    
    @Override
    public String toString() {
        String texto = String.format("\n========== DOENCAS: %s ========"
                + "\nNome: %s    "
                + "\nQuantidade de Pacientes: %s", nome, qtdPacientes);
        return texto;
    }
}
