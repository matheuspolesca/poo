/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import model.Cliente;
import model.IdTriagem;
import projetohospital.Main;
/**
 *
 * @author brend
 */
public class TriagemApplication {
    
    public static void alterarIdTriagem(Cliente cliente){
        if ("Enfermeiro".equals(Main.getProfissao()) || "Administrador".equals(Main.getProfissao())) {
            System.out.println("\n========= ALTERAR IDTRIAGEM =========");
                Scanner sc = new Scanner(System.in);
                System.out.println("\nDigite o número referente ao nova Id de Triagem:"
                                + "\n1 - Vermelha       2 - Amarela       3 - Verde");
                int acesso = sc.nextInt();
                sc.nextLine();

                switch (acesso) {
                    case 1:
                        cliente.setIdTriagem(IdTriagem.VERMELHO);
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 2:
                        cliente.setIdTriagem(IdTriagem.AMARELO);
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 3:
                        cliente.setIdTriagem(IdTriagem.VERDE);
                        System.out.println((char) 27 + "[32m\nAlterado com sucesso\u001B[0m");
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println((char) 27 + "[31m\nOpção invalida\u001B[0m");
                }
        } else {
            System.out.println((char) 27 + "[31mVocê não tem permissão para acessar essa opção.\u001B[0m");
        }
    }
}
