package Projeto;

import java.util.Scanner; 

public class Sistema {

    private static int codigoUsuario = 10000;
    private static int contadorAluno = 0; 
    private Aluno[] alunos = new Aluno[1000]; 

    Scanner sc = new Scanner(System.in);

    //método que cria a conta do aluno
    public void criarContaAluno() {

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
        boolean verifica = VerificaSenha(senha, confirmaSenha);
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

    //método que verifica senhas
    public boolean VerificaSenha(String senha, String confirmaSenha) {

        if (senha.equals(confirmaSenha)) {
            return true; 
        } else {
            return false; 
        }
    }
    
    //metodo que gera um codigo para o usuario
    public int GerarCodigoUsuario() {
        codigoUsuario += 1;  
        return codigoUsuario; 
    };

    public void setAluno(Aluno aluno) {

        this.alunos[contadorAluno] = aluno;
        contadorAluno++; 
    }

    public Aluno getAluno(int i) {
        return alunos[i]; 
    }

    //metodo para coletar os dados do login
    public void fazerLoginMenu(){

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

        fazerLoginUsuario(email, senha); 

    }

    //metodo para fazer o login
    public void fazerLoginUsuario(String email, String senha) {

        for(int i = 0; i < contadorAluno; i++) {
            if(VerificaSenha(getAluno(i).getEmail(), email) == true && VerificaSenha(getAluno(i).getSenhaPessoal(), senha) == true) {
                MenuAluno(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   

    }

    public void MenuAluno(int i) {

        Scanner teclado = new Scanner(System.in);

        int escolha = 0; 

        do{ 

            System.out.println("1 - Consultar seus Dados. ");
            System.out.println("2 - Consultar Cursos disponíveis. ");
            System.out.println("3 - Sair. ");

            escolha = Integer.parseInt(teclado.nextLine());

            switch(escolha) {
                case 1:
                    Dados(i);
                    break;
    
                case 2:
                    
                    break;
    
                case 3:
                    
                    return;

                default:
                    System.out.print("\nOpção inválida, tente novamente.");
                    break;
            }
        }while(escolha != 3);
    }

    public void Dados(int i) {
        System.out.println("Nome: " + getAluno(i).getNome());
        System.out.println("Codigo do Usuário: " + getAluno(i).getCodigoUsuario());
        System.out.println("Email: " + getAluno(i).getEmail());
        System.out.println("CPF: " + getAluno(i).getCPF());
        System.out.println("Plano: " + getAluno(i).getPlano());
    }
    


























    /*public static void cadastrarCurso() {

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

    public static void cadastrarProfessor() {

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

    public static void menuAdmin(){

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
    } */

}