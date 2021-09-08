package model;

import model.Doenca;
import model.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Classe responsável por modelar a fila de pacientes
 * 
 * 
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 * 
 */
public class Fila{
    private Cliente cliente;
    private Doenca doenca;
    private Date data;

    /**
     * 
     * @param cliente
     * @param data
     */
    public Fila(Cliente cliente, /*Doenca doenca,*/ String data) {
        this.cliente = cliente;
        /*this.doenca = doenca;*/
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
                    } catch (ParseException ex) {
            Logger.getLogger(Fila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtém um cliente da fila
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define um cliente da fila
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /*public Doenca getDoenca() {
        return doenca;
    }*/

    /**
     * Define a doença de um paciente da fila
     * @param doenca
     */


    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    /**
     * Obtém a data
     * @return
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

    /**
     * Retorna o paciente, sua doença e seu lugar na fila
     * @return
     */
    @Override
    public String toString() {
        String texto = String.format("\n========== FILA: %s ========"
                + "\nPaciente: %s"
                + "\nDoença: %s"
                + "\nLugar na fila: %d", getCliente(), getData());
        return texto;
    }
}


