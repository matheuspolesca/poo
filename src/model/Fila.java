package model;

import model.Doenca;
import model.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fila{
    private Cliente cliente;
    private Doenca doenca;
    private Date data;

    public Fila(Cliente cliente, /*Doenca doenca,*/ String data) {
        this.cliente = cliente;
        /*this.doenca = doenca;*/
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
                    } catch (ParseException ex) {
            Logger.getLogger(Fila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /*public Doenca getDoenca() {
        return doenca;
    }*/

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    @Override
    public String toString() {
        String texto = String.format("\n========== FILA: %s ========"
                + "\nPaciente: %s"
                + "\nDoença: %s"
                + "\nLugar na fila: %d", getCliente(), getData());
        return texto;
    }
}


