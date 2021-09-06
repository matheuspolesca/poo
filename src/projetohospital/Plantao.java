/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohospital;

/**
 *
 * @author brend
 */
public enum Plantao {
    
    MANHA(1),
    TARDE(2),
    NOITE(3);
    
    private final int periodo;

    Plantao(int periodo) {
        this.periodo = periodo;
    }

    public int getDescricao() {
        return periodo;
    }

}
