/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 */
public enum Plantao {
    
    /**
     * Define os plantões dos funcionários
     */
    MANHA(1),

    /**
     *
     */
    TARDE(2),

    /**
     *
     */
    NOITE(3);
    
    private final int periodo;

    Plantao(int periodo) {
        this.periodo = periodo;
    }

    /**
     * Obtém a descrição do plantão
     * @return
     */
    public int getDescricao() {
        return periodo;
    }

}
