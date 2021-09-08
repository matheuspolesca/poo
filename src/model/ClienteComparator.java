/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author tulio
 */
public class ClienteComparator implements Comparator <Cliente>{

    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        //Comparação do idTriagem
        if((cliente1.getIdTriagem()!=null)&&(cliente2.getIdTriagem()!=null)){
            int idTriagemCompare = cliente2.getIdTriagem().compareTo(cliente1.getIdTriagem());
            if(idTriagemCompare!=0)
                return idTriagemCompare;
        }

        //Comparação do horário de atendimento
        if((cliente1.getData()!=null)&&(cliente2.getData()!=null)){
            int dataCompare = cliente2.getData().compareTo(cliente1.getData());
            if(dataCompare!=0)
                return dataCompare;
        }
        
        //Comparação da quantidade de doenças
        int clienteDoencasSizeCompare = cliente2.getClienteDoencas().size() - cliente1.getClienteDoencas().size();
        if(clienteDoencasSizeCompare!=0)
            return clienteDoencasSizeCompare;
        
        //Comparação de idades
        int idadeCompare = cliente2.getIdade() - cliente1.getIdade();
        if(idadeCompare!=0)
            return idadeCompare;
        
        //Comparação de nomes
        if((cliente1.getNome()!=null)&&(cliente2.getNome()!=null)){
            int nomeCompare = cliente2.getNome().compareTo(cliente1.getNome());
            if(idadeCompare!=0)
                return nomeCompare;
        }
        
        //Comparação de sobrenomes
        int sobrenomeCompare = cliente2.getSobrenome().compareTo(cliente1.getSobrenome());      
        return sobrenomeCompare;
    }
}
