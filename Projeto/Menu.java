package Projeto;

import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;
import java.lang.NumberFormatException;

public class Menu {
    public static void main(String args[]) {

        Scanner teclado = new Scanner(System.in);

        int escolha = 0;

        do{
            try{
                limpaTela();
                MenuInicial();
                escolha = Integer.parseInt(teclado.nextLine());
                switch(escolha) {
                    case 1:
                        limpaTela();
                        criarContaAluno();
                        break;
            
                    case 2:
                        limpaTela();
                        fazerLoginMenu();
                        break;
            
                    case 3:
                        System.out.println("Saindo...");
                        return;
        
                    default:
                        System.out.print("\nOpção inválida, tente novamente.");
                        break;
                }
            } catch(NumberFormatException numberFormatException){
                System.out.print("\nEntrada inválida, tente novamente.");
                teclado.nextLine();
            }
        }while(escolha != 3);
        
        teclado.close();
    }

    public static void MenuInicial() {
    
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("SEJA BEM VINDO!!!!\n\n");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Fazer cadastro para ser o nosso Aluno!");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("\nDigite sua escolha: ");
    }

    public static void criarContaAluno() {

        Sistema sistema = new Sistema();
        Scanner teclado = new Scanner(System.in);

        // Dados do usuario
        String nome;
        String cpf;
        String plano;
        String email;
        String senha;
        String confirmaSenha;
        boolean controle = false;
        int codigoUsuario; 

        // Menu de cadastro
        System.out.println("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("====================\nREGISTRO\n====================\n\n");
        System.out.print("CPF: ");
        cpf = teclado.nextLine();
        System.out.print("Nome completo: ");
        nome = teclado.nextLine();
        System.out.print("Digite seu Email: ");
        email = teclado.nextLine();
        System.out.println("Escolha um plano: " + "1 - 19,90 Completo " + " 2 - 9,99 Básico");
        plano = teclado.nextLine();
        do{
            System.out.print("Senha: ");
            senha = teclado.nextLine();
            System.out.print("Confirme a senha: ");
            confirmaSenha = teclado.nextLine();
            //verificacao de senha
            boolean verifica = sistema.VerificaSenha(senha, confirmaSenha);
            if(verifica == true) {
                System.out.println("As senhas são iguais!");
                controle = true;
                codigoUsuario = sistema.GerarCodigoUsuario();
                Aluno aluno = new Aluno(nome, codigoUsuario, email, senha, cpf, plano);
                sistema.setAluno(aluno);
                System.out.println("Conta Criada com Sucesso!");
            }else {
                System.out.println("A senha não é igual!" + "Tente Novamente!"); 
                System.out.println();
            }

        } while(controle != true);
    }

    //metodo para coletar os dados do login
    public static void fazerLoginMenu(){

        Sistema sistema = new Sistema();
        Scanner teclado = new Scanner(System.in);

        // Dados do usuário
        String email;
        String senha;

        // Menu de login
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("====================\nLOGIN\n====================\n\n");
        System.out.print("email: ");
        email = teclado.nextLine();
        System.out.print("Senha: ");
        senha = teclado.nextLine();

        sistema.fazerLoginUsuario(email, senha);
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
