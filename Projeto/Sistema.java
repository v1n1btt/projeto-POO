package Projeto;

import java.util.Scanner;

public class Sistema {

    private static int codigoUsuario = 10000;
    private static int contadorAluno = 0;
    private static int contadorAdministrador = 0;
    private static int contadorProfessor = 0; 
    private Aluno[] alunos = new Aluno[1000];
    private Administrador[] administradores = new Administrador[100]; 
    private Professor[] professores = new Professor[100];

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

    public void setProfessor(Professor professor) {

        this.professores[contadorProfessor] = professor;
        contadorProfessor++; 
    }

    public Professor getProfessor(int i) {

        return professores[i]; 
    }

    //metodos para fazer os logins
    public void fazerLoginUsuarioAluno(String email, String senha) {

        for(int i = 0; i < contadorAluno; i++) {
            if(VerificaSenha(getAluno(i).getEmail(), email) == true && VerificaSenha(getAluno(i).getSenhaPessoal(), senha) == true && getAluno(i).getNivelAcesso() == 3) {
                MenuAluno(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    public void fazerLoginUsuarioAdministrador(String email, String senha) {

        for(int i = 0; i < contadorAdministrador; i++) {
            if(VerificaSenha(getAdministrador(i).getEmail(), email) == true && VerificaSenha(getAdministrador(i).getSenhaPessoal(), senha) == true && getAdministrador(i).getNivelAcesso() == 1) {
                MenuAdministrador(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    public void fazerLoginUsuarioProfessor(String email, String senha) {

        for(int i = 0; i < contadorAdministrador; i++) {
            if(VerificaSenha(getProfessor(i).getEmail(), email) == true && VerificaSenha(getProfessor(i).getSenhaPessoal(), senha) == true && getProfessor(i).getNivelAcesso() == 2) {
                MenuProfessor(i);
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
        int opcao; 

        // Menu de login
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.println("Opções para Login: ");
        System.out.println("1 - Aluno , 2 - Administrador ou 3 - Professor");
        System.out.println("Escolha uma opção: ");
        opcao = teclado.nextInt();
        teclado.nextLine();
        System.out.print("====================\nLOGIN\n====================\n\n");
        System.out.print("email: ");
        email = teclado.nextLine();
        System.out.print("Senha: ");
        senha = teclado.nextLine();
        

        if(opcao == 1) {
            Menu.limpaTela();
            fazerLoginUsuarioAluno(email, senha);
        } else if(opcao == 2) {
            Menu.limpaTela();
            fazerLoginUsuarioAdministrador(email, senha);
        } else {
            Menu.limpaTela();
            fazerLoginUsuarioProfessor(email, senha);
        }
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ALUNO !!!!

    //método que cria a conta do aluno

    public void criarContaAluno() {
       
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
        System.out.println();
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
                codigoUsuario = GerarCodigoUsuario();
                Aluno aluno = new Aluno(nome, codigoUsuario, email, senha, cpf, plano);
                setAluno(aluno);
                System.out.println("Conta Criada com Sucesso!");
            }else {
                System.out.println("A senha não é igual!" + "Tente Novamente!"); 
                System.out.println();
            }

        } while(controle != true);
    }

    public void MenuAluno(int i) {

        int escolha = 0; 

        do{ 
            System.out.println();
            System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como Aluno\n\n");
            System.out.println("Bem vindo: " + getAluno(i).getNome());
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Consultar seus Dados. ");
            System.out.println("2 - Consultar Cursos disponíveis. ");
            System.out.println("3 - Sair. ");

            escolha = Integer.parseInt(teclado.nextLine());

            switch(escolha) {
                case 1:
                    Menu.limpaTela();
                    DadosAluno(i);
                    break;
    
                case 2:
                    
                    break;
    
                case 3:
                    Menu.limpaTela();
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

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ADMINISTRADOR!!!!

    public void CadastrarAdministrador(String nome, String email, String senha) {
        int codigoUsuario = 0; 
        codigoUsuario = GerarCodigoUsuario();
        Administrador administrador = new Administrador(nome, codigoUsuario, email, senha);
        setAdministrador(administrador);
        System.out.println("Conta Criada com Sucesso!");
    }

    public void MenuAdministrador(int i) {

        int escolha;
        
        do {
            System.out.println();
            System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como administrador\n\n");
            System.out.println("Bem vindo: " + getAdministrador(i).getNome());
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
                    Menu.limpaTela();
                    FormularioCadastroAdministrador();
                    break;

                case 4:
                    Menu.limpaTela();
                    FormulariocadastroProfessor();
                    break;
                
                case 5:
                    Menu.limpaTela();
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

    public void FormulariocadastroProfessor() {

        String nome; 
        String email; 
        String senha;
        String confirmaSenha;
        boolean controle = false; 
       //boolean confirma;

        // Formulario de cadastro de professor
        //Menu.limpaTela();
        System.out.print("====================\nCADASTRO DE PROFESSOR\n====================\n\n");
        System.out.print("Nome do professor: ");
        nome = teclado.nextLine();
        System.out.print("Endereço de email do professor: ");
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
                CadastrarProfessor(nome, email, confirmaSenha);
            }else {
                System.out.println("A senha não é igual!" + "Tente Novamente!"); 
                System.out.println();
            }
        } while(controle != true);

        /*System.out.print("\nConfirma o cadastro do professor? Digite 1 para confirmar, e 0 para cancelar: ");
        confirma = Boolean.parseBoolean(teclado.nextLine());

        if(confirma == true){

        }
        else
            return;
        */
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O PROFESSOR!!!!

    public void CadastrarProfessor(String nome, String email, String senha) {
        int codigoUsuario = 0; 
        codigoUsuario = GerarCodigoUsuario();
        Professor professor = new Professor(nome, codigoUsuario, email, senha);
        setProfessor(professor);
        System.out.println("Conta Criada com Sucesso!");
    }

    public void MenuProfessor(int i) {

        int escolha = 0; 

        do{
            System.out.println();
            System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como Professor\n\n");
            System.out.println("Bem vindo: " + getProfessor(i).getNome());
            System.out.println("1 - Consultar seus Dados. ");
            System.out.println("2 - Consultar Cursos disponíveis. ");
            System.out.println("3 - Sair. ");

            escolha = Integer.parseInt(teclado.nextLine());

            switch(escolha) {
                case 1:
                    //DadosAluno(i);
                    break;
    
                case 2:
                    
                    break;
    
                case 3:
                    Menu.limpaTela();
                    return;

                default:
                    System.out.print("\nOpção inválida, tente novamente.");
                    break;
            }
        }while(escolha != 3);
    }
}