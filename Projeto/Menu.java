package Projeto;
import java.util.Scanner;

public class Menu {

    Sistema sistema = new Sistema();
    public static void main(String args[]) {

        Scanner teclado = new Scanner(System.in);

        int escolha;

        do{
            
            MenuInicial();
            escolha = Integer.parseInt(teclado.nextLine());
            switch(escolha) {
                case 1:
                    criarContaAluno();
                    break;
    
                case 2:
                    sistema.fazerLoginMenu();
                    break;
    
                case 3:
                    System.out.println("Saindo...");
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
        System.out.print("SEJA BEM VINDO!!!!\n\n");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Fazer cadastro para ser o nosso Aluno!");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("\nDigite sua escolha: ");
    }

    public static void criarContaAluno() {

        Scanner teclado = new Scanner(System.in);

        // Dados do usuario
        String nome;
        String cpf;
        String plano;
        String email;
        String senha;
        String confirmaSenha;
        boolean controle = false; 

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
                GerarCodigoUsuario();
                Aluno aluno = new Aluno(nome, codigoUsuario, email, senha, cpf, plano);
                setAluno(aluno);
                System.out.println("Conta Criada com Sucesso!");
            }else {
                System.out.println("A senha não é igual!" + "Tente Novamente!"); 
                System.out.println();
            }

        } while(controle != true);
    }

}