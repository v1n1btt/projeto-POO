package Projeto;
import java.util.Scanner;

public class Menu {
    public static void main(String args[]) {
        
        Scanner teclado = new Scanner(System.in);
        int escolha;

        do{
            
            MenuInicial();
            escolha = Integer.parseInt(teclado.nextLine());
            switch(escolha){
                case 1:
                    Sistema.criarContaAluno();
                    break;
    
                case 2:
                    //Sistema.fazerLogin();
                    break;
    
                case 3:
                    return;

                default:
                    System.out.print("\nOpção inválida, tente novamente.");
                    break;
            }
        }while(escolha != 3);
        teclado.close();
    }

    public static void MenuInicial() {
    
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Fazer cadastro");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("\nDigite sua escolha: ");
    }
}