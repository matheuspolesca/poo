package model;

import model.Cliente;
import java.util.ArrayList;

/**Classe responsável por modelar as doenças
 * 
 * 
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 * 
 */
public class Doenca {
    private String nome;
    private static int totDoencas;
    private int idDoenca, qtdPacientes;
    private ArrayList<Cliente> doencaClientes = new ArrayList();

    /**
     * Construtor padrão da classe
     */
    public Doenca() {
    }

    /**
     * Construtor adicional da classe
     * @param nome
     */
    public Doenca(String nome) {
        this.nome = nome;
        this.idDoenca = totDoencas;
        totDoencas++;
    }
    
    /**
     * Obtém o nome da doença
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da doença
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a quantidade de pacientes
     * @return
     */
    public int getQtdPacientes() {
        return qtdPacientes;
    }

    /**
     * Define a quantidade de pacientes
     * @param qtdPacientes
     */
    public void setQtdPacientes(int qtdPacientes) {
        this.qtdPacientes += qtdPacientes;
    }

    /**
     * Obtém o id da doença
     * @return
     */
    public int getIdDoenca() {
        return idDoenca;
    }

    /**
     * Define o id da doença
     * @param idDoenca
     */
    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }
    
    /** 
     * Obtém as doenças do paciente
     * @return
     */
    public ArrayList<Cliente> getDoencaClientes() {
        return doencaClientes;
    }

    /** 
     * Define as doenças do paciente
     * @param doencaClientes
     */
    public void setDoencaClientes(ArrayList<Cliente> doencaClientes) {
        this.doencaClientes = doencaClientes;
    }

    /**
     * Obtém o total de doenças
     * @return
     */
    public static int getTotDoencas() {
        return totDoencas;
    }

    /**
     * Define o total de doenças
     * @param totDoencas
     */
    public static void setTotDoencas(int totDoencas) {
        Doenca.totDoencas = totDoencas;
    }
    
    /**
     * Retorna o nome da doença e a quantidade de pacientes que a possuem
     * @return
     */
    @Override
    public String toString() {
        String texto = String.format("\n========== DOENCAS: %s ========"
                + "\nNome: %s    "
                + "\nQuantidade de Pacientes: %s", nome, qtdPacientes);
        return texto;
    }
}
