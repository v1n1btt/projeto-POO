package Projeto;
import java.util.Scanner;

public class Menu {

    
    /*public static void limpaTela(){
        final String os = System.getProperty("os.name");
        if (os.contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }*/

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int escolha;

        do{
            
            MenuInicial();
            escolha = Integer.parseInt(sc.nextLine());
            switch(escolha){
                case 1:
                    criarConta();
                    break;
    
                case 2:
                    fazerLogin();
                    break;
    
                case 3:
                    return;

                default:
                    System.out.print("\nOpção inválida, tente novamente.");
                    //getchar();
                    break;
            }
        }while(escolha != 3);
    }

    public static void MenuInicial() {
        // Menu principal
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Fazer cadastro");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("\nDigite sua escolha: ");
    }
}