package Projeto;

import java.util.Scanner;
//import java.io.IOException;
//import java.lang.InterruptedException;
//import java.lang.NumberFormatException;

public class Sistema {

    private static int codigoUsuario = 1000;
    private static int contadorAluno = 0;
    private static int contadorAdministrador = 0;
    private static int contadorProfessor = 0; 
    private static int contadorCurso = 0; 
    private Aluno[] alunos = new Aluno[1000];
    private Administrador[] administradores = new Administrador[100]; 
    private Professor[] professores = new Professor[100];
    private Curso[] cursos = new Curso[100]; 

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

    public void setTurma(Curso curso) {

        this.cursos[contadorCurso] = curso;
        contadorCurso++; 
    }

    public Curso getCurso(int i) {

        return cursos[i]; 
    }

    //metodos para fazer os logins
    public void fazerLoginUsuarioAluno(String email, String senha) {

        for(int i = 0; i < contadorAluno; i++) {
            if(VerificaVariaveis(getAluno(i).getEmail(), email) == true && VerificaVariaveis(getAluno(i).getSenhaPessoal(), senha) == true && getAluno(i).getNivelAcesso() == 3) {
                Menu.limpaTela();
                MenuAluno(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    public void fazerLoginUsuarioAdministrador(String email, String senha) {

        for(int i = 0; i < contadorAdministrador; i++) {
            if(VerificaVariaveis(getAdministrador(i).getEmail(), email) == true && VerificaVariaveis(getAdministrador(i).getSenhaPessoal(), senha) == true && getAdministrador(i).getNivelAcesso() == 1) {
                MenuAdministrador(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    public void fazerLoginUsuarioProfessor(String email, String senha) {

        for(int i = 0; i < contadorAdministrador; i++) {
            if(VerificaVariaveis(getProfessor(i).getEmail(), email) == true && VerificaVariaveis(getProfessor(i).getSenhaPessoal(), senha) == true && getProfessor(i).getNivelAcesso() == 2) {
                MenuProfessor(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    //método que verifica variaveis para ver se são iguais
    public boolean VerificaVariaveis(String variavel1, String variavel2) {

        if (variavel1.equals(variavel2)) {
            return true; 
        } else {
            return false; 
        }
    }

    //metodo que gera um codigo para os usuarios
    public int GerarCodigoUsuario() {
        codigoUsuario += 1;  
        return codigoUsuario; 
    }

    //metodo para coletar os dados do login
    public void fazerLoginMenu(){

        // Dados do usuário
        String email;
        String senha;
        int opcao = 0;

        // Menu de login
        //do{
            //try{
                do {
                    Menu.limpaTela();
                    System.out.print("======================\nSISTEMA DE GESTÃO DE CURSOS\n=====================\n\n");
                    System.out.println("Opções para Login: \n");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Administrador");
                    System.out.println("3 - Professor");
                    System.out.println("4 - Voltar");
                    System.out.print("\nEscolha uma opção: ");
                    opcao = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcao) {
                        case 1:
                            Menu.limpaTela();
                            System.out.print("====================\nLOGIN NO SISTEMA\n====================\n\n");
                            System.out.print("\nInsira seu email: ");
                            email = teclado.nextLine();
                            System.out.print("\nInsira sua Senha: ");
                            senha = teclado.nextLine();
                            fazerLoginUsuarioAluno(email, senha);
                            break;
                        case 2:
                            Menu.limpaTela();
                            System.out.print("====================\nLOGIN NO SISTEMA\n====================\n\n");
                            System.out.print("\n Insira seu email: ");
                            email = teclado.nextLine();
                            System.out.print("\nInsira sua Senha: ");
                            senha = teclado.nextLine();
                            fazerLoginUsuarioAdministrador(email, senha);
                            break;
                        case 3:
                            Menu.limpaTela();
                            System.out.print("====================\nLOGIN NO SISTEMA\n====================\n\n");
                            System.out.print("\n Insira seu email: ");
                            email = teclado.nextLine();
                            System.out.print("\nInsira sua Senha:");
                            senha = teclado.nextLine();
                            fazerLoginUsuarioProfessor(email, senha);
                            break;
                        case 4:
                            Menu.limpaTela();
                            return;
                        default:
                            System.out.print("\nOpção inválida, tente novamente.");
                            break;
                    }
                } while(opcao != 4); 
            //} catch(NumberFormatException numberFormatException){
                //System.out.print("\nEntrada inválida, tente novamente.");
                //teclado.nextLine();
            //}
        //} while(opcao != 1 || opcao != 2 || opcao != 3);
        
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ALUNO !!!!

    //método que cria a conta do aluno
    public void criarContaAluno() {
       
        // Dados do usuario
        String nome;
        String cpf;
        String email;
        String senha;
        String confirmaSenha;
        boolean controle = false;
        int codigoUsuario; 

        // Menu de cadastro
        System.out.println();
        System.out.println("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("====================\nCADASTRO ALUNO\n====================\n\n");
        System.out.print("CPF: ");
        cpf = teclado.nextLine();
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
            boolean verifica = VerificaVariaveis(senha, confirmaSenha);
            if(verifica == true) {
                System.out.println("As senhas são iguais!");
                controle = true;
                codigoUsuario = GerarCodigoUsuario();
                Aluno aluno = new Aluno(nome, codigoUsuario, email, senha, cpf);
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
            try{
                System.out.println();
                System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como Aluno\n\n");
                System.out.print("Bem vindo: " + getAluno(i).getNome());
                System.out.print("Selecione uma opção:\n\n");
                System.out.println("1 - Consultar seus Dados. ");
                System.out.println("2 - Consultar Cursos disponíveis. ");
                System.out.println("3 - Se matricular em Cursos disponíveis. ");
                System.out.println("4 - Cancelar matricula em um curso. ");
                System.out.println("5 - Sair. ");

                escolha = Integer.parseInt(teclado.nextLine());

                switch(escolha) {
                    case 1:
                        Menu.limpaTela();
                        DadosAluno(i);
                        break;
                    case 2:
                        CursosDisponiveis();
                        break;
                    case 3:
                        
                        break;
                    case 4:

                        break;
                    case 5:
                        Menu.limpaTela();
                        break;
                    default:
                        System.out.print("\nOpção inválida, tente novamente.");
                        break;
                }
            } catch(NumberFormatException numberFormatException){
                System.out.print("\nEntrada inválida, tente novamente.");
                teclado.nextLine();
            }
        }while(escolha != 5);
    }

    public void DadosAluno(int i) {
        System.out.println("Nome: " + getAluno(i).getNome());
        System.out.println("Codigo do Usuário: " + getAluno(i).getCodigoUsuario());
        System.out.println("Email: " + getAluno(i).getEmail());
        System.out.println("CPF: " + getAluno(i).getCPF());
    }

    public void CursosDisponiveis() {

        for( int i = 0; i < contadorCurso; i++) {
            if (getCurso(i).getStatus() == true) {
                System.out.println();
                System.out.println("Nome do curso: " + getCurso(i).getNomeCurso());
                System.out.println("Código do curso: " + getCurso(i).getCodigoCurso());
                System.out.println("Carga Horária do curso: " + getCurso(i).getCargaHorariaCurso() + "horas");
                System.out.println("Ementa do curso: " + getCurso(i).getEmenta());
                System.out.println("Data Inicial do curso: " + getCurso(i).getDataInicio());
                System.out.println("Data Final do curso: " + getCurso(i).getDataFim());
                System.out.println("Professor do curso: " + getCurso(i).getProfessor());
                System.out.println();
            }
        }
    }

    public void MatricularCurso() {

        int codigo;
        System.out.println("Digite o código do curso: ");
        codigo = teclado.nextInt(); 
        //setAlunosMatriculados();
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ADMINISTRADOR!!!!

    public void CadastrarAdministrador(String nome, String email, String senha) {

        int codigoUsuario; 
        codigoUsuario = GerarCodigoUsuario();
        Administrador administrador = new Administrador(nome, codigoUsuario, email, senha);
        setAdministrador(administrador);
        System.out.println("Conta Criada com Sucesso!");
    }

    public void MenuAdministrador(int i) {

        int escolha = 0;
        do {
            try{
                Menu.limpaTela();
                System.out.println();
                System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como administrador\n\n");
                System.out.println("BEM VINDO: " + getAdministrador(i).getNome() + "\n");
                System.out.println("Selecione uma opção:");
                System.out.println("    1. Cadastrar novo curso");
                System.out.println("    2. Mostrar cursos cadastrados");
                System.out.println("    3. Cadastrar um novo Administrador");
                System.out.println("    4. Cadastrar professor");
                System.out.println("    5. Fazer logout");
                System.out.print("\nDigite uma opção: ");
                escolha = Integer.parseInt(teclado.nextLine());
                switch(escolha) {
                    case 1:
                        Menu.limpaTela();
                        FormulariocadastrarCurso();
                        break;
                    case 2:
                        Menu.limpaTela();
                        DadosTurmas();
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
            } catch(NumberFormatException numberFormatException){
                System.out.print("\nEntrada inválida, tente novamente.");
                teclado.nextLine();
            }
        } while(escolha != 5);
    }

    public void FormularioCadastroAdministrador() {
        
        String nome;
        String email;
        String senha;
        String confirmaSenha;
        boolean controle = false; 
        System.out.print("====================\nCADASTRO ADMINISTRADOR\n====================\n\n");
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
            boolean verifica = VerificaVariaveis(senha, confirmaSenha);
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
            boolean verifica = VerificaVariaveis(senha, confirmaSenha);
            if(verifica == true) {
                System.out.println("As senhas são iguais!");
                controle = true;
                CadastrarProfessor(nome, email, confirmaSenha);
            }else {
                System.out.println("As senhas não são iguais!" + "Tente Novamente!"); 
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

    public void FormulariocadastrarCurso() {

        String nome;
        String codigo;
        int cargaHoraria;
        String ementa;
        String dataInicio;
        String dataFim;
        String horario; 
        int escolhaProfessor; 
        //boolean exception = false;
        //boolean confirma;
        // Formulario de cadastro de curso
        //do{
            //try{
                Menu.limpaTela();
                System.out.print("====================\nCADASTRO DE CURSO\n====================\n\n");
                System.out.print("Nome do curso: ");
                nome = teclado.nextLine();
                System.out.print("Código do curso: ");
                codigo = teclado.nextLine();
                System.out.print("Ementa do curso: ");
                ementa = teclado.nextLine();
                System.out.print("Data de inicio curso: ");
                dataInicio = teclado.nextLine();
                System.out.print("Data de inicio curso: ");
                dataFim = teclado.nextLine();
                System.out.print("horario: ");
                horario = teclado.nextLine();
                System.out.print("Carga horária do curso: ");
                cargaHoraria = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Escolha um professor:"); 
                for(int i = 0; i < contadorProfessor; i++) {
                    System.out.println("Indice do professor:  " + i + " Nome do professor:  " + getProfessor(i).getNome());
                }
                System.out.println("Digite o número do professor acima: "); 
                escolhaProfessor = teclado.nextInt();
                CadastrarCurso(nome, codigo, cargaHoraria, ementa, dataInicio, dataFim, horario, escolhaProfessor);
            //} catch(NumberFormatException numberFormatException){
                //exception = true;
                //System.out.print("\nEntrada inválida, tente novamente.");
                //teclado.nextLine();
            //}
        //} while(exception = true);

        /*System.out.print("\nConfirma o cadastro do curso? Digite 1 para confirmar, e 0 para cancelar: ");
        confirma = Boolean.parseBoolean(teclado.nextLine());

        if(confirma == true){

        }
        else
            return;
        */
    }

    public void CadastrarCurso(String nome, String codigo,int cargaHoraria, String ementa, String dataInicio, String dataFim, String horario, int i) {

        Professor professores = getProfessor(i);
        Curso curso = new Curso(nome, codigo, cargaHoraria, ementa, dataInicio, dataFim, professores, horario);
        setTurma(curso);
        System.out.println("Curso Criado com Sucesso!");
    }

    public void DadosTurmas() {

        for(int i = 0; i < contadorCurso; i++) {
            System.out.println("Nome: " + getCurso(i).getNomeCurso());
            System.out.println("Código Curso: " + getCurso(i).getCodigoCurso());
            System.out.println("Carga Horária: " + getCurso(i).getCargaHorariaCurso());
            System.out.println("Ementa: " + getCurso(i).getEmenta());
            System.out.println("Data Inicio: " + getCurso(i).getDataInicio());
            System.out.println("Data Fim: " + getCurso(i).getDataFim());
            System.out.println("Quantidade de Alunos Matriculados: " + getCurso(i).getQuantidadeAtualAlunos());
            System.out.println("Horários: : " + getCurso(i).getHorario());
            System.out.println("Status do Curso: " + getCurso(i).getStatus());
            System.out.println();
        }
    }

    public void DadosCursosAluno() {

        for(int i = 0; i < contadorCurso; i++) {
            if(getCurso(i).getStatus() == true) {
            System.out.println("Nome: " + getCurso(i).getNomeCurso());
            System.out.println("Código Curso: " + getCurso(i).getCodigoCurso());
            System.out.println("Carga Horária: " + getCurso(i).getCargaHorariaCurso());
            System.out.println("Ementa: " + getCurso(i).getEmenta());
            System.out.println("Data Inicio: " + getCurso(i).getDataInicio());
            System.out.println("Data Fim: " + getCurso(i).getDataFim());
            System.out.println("Quantidade de Alunos Matriculados: " + getCurso(i).getQuantidadeAtualAlunos());
            System.out.println("Horários: : " + getCurso(i).getHorario());
            System.out.println();
            } 
        }
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
            try{
                Menu.limpaTela();
                System.out.println();
                System.out.print("SISTEMA DE GESTÃO DE CURSOS\nLogado como Professor\n\n");
                System.out.println("Bem vindo: " + getProfessor(i).getNome());
                System.out.println("1 - Consultar seus Dados. ");
                System.out.println("2 - Consultar Cursos disponíveis. ");
                System.out.println("3 - Sair. ");

                escolha = Integer.parseInt(teclado.nextLine());

                switch(escolha) {
                    case 1:
                        
                        break;
        
                    case 2:
                        DadosCursosAluno();
                        break;
        
                    case 3:
                        Menu.limpaTela();
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
    }
}