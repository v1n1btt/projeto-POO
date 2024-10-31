package Projeto;

import java.util.Scanner; 

public class Sistema {
    Scanner sc = new Scanner(System.in);

    public void cadastrarCurso() {

        String nome;
        String codigo;
        int cargaHoraria;
        String ementa;
        String preRequisitos;
        boolean confirma;

        // Formulario de cadastro de curso
        //Menu.limpaTela();
        System.out.print("====================\nCADASTRO DE CURSO\n====================\n\n");
        System.out.print("Nome do curso: ");
        nome = sc.nextLine();
        System.out.print("Código do curso: ");
        codigo = sc.nextLine();
        System.out.print("Carga horária do curso: ");
        cargaHoraria = Integer.parseInt(sc.nextLine());
        System.out.print("Ementa do curso: ");
        ementa = sc.nextLine();
        System.out.print("Pré-requisitos do curso: ");
        preRequisitos = sc.nextLine();

        System.out.print("\nConfirma o cadastro do curso? Digite 1 para confirmar, e 0 para cancelar: ");
        confirma = Boolean.parseBoolean(sc.nextLine());

        if(confirma == true){

        }
        else
            return;

    }

    public void cadastrarProfessor() {

        String nome; 
        String codigoUsuario;
        String email; 
        String senhaPessoal;
        int cargaHoraria;
        boolean confirma;

        // Formulario de cadastro de professor
        //Menu.limpaTela();
        System.out.print("====================\nCADASTRO DE PROFESSOR\n====================\n\n");
        System.out.print("Nome do professor: ");
        nome = sc.nextLine();
        System.out.print("Código de usuário do professor: ");
        codigoUsuario = sc.nextLine();
        System.out.print("Endereço de email do professor: ");
        email = sc.nextLine();
        System.out.print("Senha do professor: ");
        senhaPessoal = sc.nextLine();
        System.out.print("Carga horária do professor: ");
        cargaHoraria = Integer.parseInt(sc.nextLine());

        System.out.print("\nConfirma o cadastro do professor? Digite 1 para confirmar, e 0 para cancelar: ");
        confirma = Boolean.parseBoolean(sc.nextLine());

        if(confirma == true){

        }
        else
            return;
    }

    public void menuAdmin(){

        int escolha;
        
        do{
            // Menu do administrador
            //Menu.limpaTela();
            System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como administrador\n\n");
            System.out.println("Selecione uma opção:");
            System.out.println("    1. Cadastrar novo curso");
            System.out.println("    2. Gerenciar curso");
            System.out.println("    3. Cadastrar professor");
            System.out.println("    4. Fazer logout");
            System.out.print("\nDigite uma opção: ");

            escolha = Integer.parseInt(sc.nextLine());
            switch(escolha){
                case 1:
                    cadastrarCurso();
                    break;

                case 2:
                
                    break;

                case 3:
                    cadastrarProfessor();
                    break;

                case 4:
                    return;
                
                default:
                    System.out.print("\nOpção inválida, tente novamente.");
                    //getchar();
                    break;
                
            }
        }while(escolha != 4);
    }

    public static void criarConta() {

        // Dados do usuario
        String CPF;
        String nome;
        String dataNascimento;
        String senha;
        String confirmaSenha;

        Scanner sc = new Scanner(System.in);

        // Menu de cadastro
        //limpaTela();
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("====================\nREGISTRO\n====================\n\n");
        System.out.print("CPF do usuário: ");
        CPF = sc.nextLine();
        System.out.print("Nome completo: ");
        nome = sc.nextLine();
        System.out.print("Data de nascimento: ");
        dataNascimento = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        System.out.print("Confirme a senha: ");
        confirmaSenha = sc.nextLine();

        if(senha == confirmaSenha){

        }
    }

    public static void fazerLogin(){

        // Dados do usuário
        String CPF;
        String senha;

        Scanner sc = new Scanner(System.in);

        // Menu de login
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("====================\nLOGIN\n====================\n\n");
        System.out.print("CPF do usuário: ");
        CPF = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();

    }

}