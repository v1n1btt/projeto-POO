package Projeto;

import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;
import java.lang.NumberFormatException;

public class Menu {
    public static void main(String args[]) {
        Sistema sistema = new Sistema();
        Scanner teclado = new Scanner(System.in);

        int escolha = 0;

        do{
            try{
                //limpaTela();
                MenuInicial();
                escolha = Integer.parseInt(teclado.nextLine());
                switch(escolha) {
                    case 1:
                        limpaTela();
                        sistema.criarContaAluno();
                        break;
            
                    case 2:
                        limpaTela();
                        sistema.fazerLoginMenu();
                        break;
            
                    case 3:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.print("\nOpção inválida, tente novamente.");
                        break;
                }
            } catch(NumberFormatException numberFormatException) {
                System.out.print("\nEntrada inválida, tente novamente.");
                teclado.nextLine();
            }
        }while(escolha != 3);
        
        teclado.close();
    }

    public static void MenuInicial() {
        System.out.println();
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("SEJA BEM VINDO!!!!\n\n");
        System.out.print("Selecione uma opção:\n");
        System.out.println("1. Fazer cadastro para ser o nosso Aluno!");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("\nDigite sua escolha: ");
    }

    //método para limpar a tela
    public static void limpaTela(){

        try{
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033\143");
        } catch (IOException | InterruptedException ex) {}
    }
}