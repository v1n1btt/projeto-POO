package Projeto;

import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;

public class Sistema {

    private static int codigoUsuario = 10000;
    private static int contadorAluno = 0;
    private static int contadorAdministrador = 0;
    private Aluno[] alunos = new Aluno[1000];
    private Administrador[] administradores = new Administrador[100]; 

    Scanner teclado = new Scanner(System.in);

    public Sistema() {

        Administrador administrador = new Administrador("Admin", 99999, "admin", "admin");
        setAdministrador(administrador);
    }

    public void setAluno(Aluno aluno) {

        this.alunos[contadorAluno] = aluno;
        contadorAluno++; 
    }

    public Aluno getAluno(int i) {

        return alunos[i]; 
    }

    public void setAdministrador(Administrador administrador) {

        this.administradores[contadorAdministrador] = administrador;
        contadorAdministrador++; 
    }

    public Administrador getAdministrador(int i) {

        return administradores[i]; 
    }

    //metodo para fazer o login
    public void fazerLoginUsuario(String email, String senha) {

        for(int i = 0; i < contadorAluno; i++) {
            if(VerificaSenha(getAluno(i).getEmail(), email) == true && VerificaSenha(getAluno(i).getSenhaPessoal(), senha) == true && getAluno(i).getNivelAcesso() == 3) {
                MenuAluno(i);
            } else if(VerificaSenha(getAdministrador(i).getEmail(), email) == true && VerificaSenha(getAdministrador(i).getSenhaPessoal(), senha) == true && getAdministrador(i).getNivelAcesso() == 1) {
                MenuAdministrador(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
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
    }

     //metodo para coletar os dados do login
     public void fazerLoginMenu(){

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

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ALUNO !!!!

    //método que cria a conta do aluno

    public void MenuAluno(int i) {

        int escolha = 0; 

        do{ 

            System.out.println("1 - Consultar seus Dados. ");
            System.out.println("2 - Consultar Cursos disponíveis. ");
            System.out.println("3 - Sair. ");

            escolha = Integer.parseInt(teclado.nextLine());

            switch(escolha) {
                case 1:
                    DadosAluno(i);
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

    public void DadosAluno(int i) {
        System.out.println("Nome: " + getAluno(i).getNome());
        System.out.println("Codigo do Usuário: " + getAluno(i).getCodigoUsuario());
        System.out.println("Email: " + getAluno(i).getEmail());
        System.out.println("CPF: " + getAluno(i).getCPF());
        System.out.println("Plano: " + getAluno(i).getPlano());
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ADMINISRADOR!!!!

    public void MenuAdministrador(int i) {

        int escolha;
        
        do {
            System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como administrador\n\n");
            System.out.println("Selecione uma opção:");
            System.out.println("    1. Cadastrar novo curso");
            System.out.println("    2. Gerenciar curso");
            System.out.println("    3. Cadastrar um novo Administrador");
            System.out.println("    4. Cadastrar professor");
            System.out.println("    5. Fazer logout");
            System.out.print("\nDigite uma opção: ");

            escolha = Integer.parseInt(teclado.nextLine());
            switch(escolha) {
                case 1:
                   
                    break;

                case 2:
                
                    break;

                case 3:
                    FormularioCadastroAdministrador();
                    break;

                case 4:

                    break;
                
                case 5:

                    break;
                
                default:
                    System.out.print("\nOpção inválida, tente novamente.");
                    break;
            }
                
        } while(escolha != 5);
    }

    public void FormularioCadastroAdministrador() {

        // Dados do usuario
        String nome;
        String email;
        String senha;
        String confirmaSenha;
        boolean controle = false; 

        // Menu de cadastro
        System.out.print("====================\nREGISTRO\n====================\n\n");
        System.out.print("Nome completo: ");
        nome = teclado.nextLine();
        System.out.print("Digite seu Email: ");
        email = teclado.nextLine();
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
                CadastrarAdministrador(nome, email, confirmaSenha);
            }else {
                System.out.println("A senha não é igual!" + "Tente Novamente!"); 
                System.out.println();
            }
        } while(controle != true);
    }

    public void CadastrarAdministrador(String nome, String email, String senha) {

        GerarCodigoUsuario();
        Administrador administrador = new Administrador(nome, codigoUsuario, email, senha);
        setAdministrador(administrador);
        System.out.println("Conta Criada com Sucesso!");
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

        public static void limpaTela(){

            try{
            if (System.getProperty("os.name").contains("Windows"))
    
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    
            else
    
                System.out.print("\033\143");

        } catch (IOException | InterruptedException ex) {}

    }
    */

}
