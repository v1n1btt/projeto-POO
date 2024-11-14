package Projeto;

import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;
import java.lang.NumberFormatException;

public class Sistema 
{

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

    public Sistema() 
    {
        Aluno aluno = new Aluno("Joao", 99997, "joao", "joao", "44412345810");
        Administrador administrador = new Administrador("Admin", 99999, "admin", "admin");
        Professor professor = new Professor("Mario", 99998, "mario", "mario");
        Curso curso = new Curso( "Matemática Básica", "MAT", 40,"...", "01/01/2024", "01/11/2024", "14h - 16h, quart e sexta", professor);
        setAdministrador(administrador);
        setAluno(aluno);
        setProfessor(professor);
        setCurso(curso);
    }

    public void setAluno(Aluno aluno) 
    {
        this.alunos[contadorAluno] = aluno;
        contadorAluno++; 
    }

    public Aluno getAluno(int i) 
    {
        return alunos[i]; 
    }

    public void setAdministrador(Administrador administrador) 
    {
        this.administradores[contadorAdministrador] = administrador;
        contadorAdministrador++; 
    }

    public Administrador getAdministrador(int i) 
    {
        return administradores[i]; 
    }

    public void setProfessor(Professor professor) 
    {
        this.professores[contadorProfessor] = professor;
        contadorProfessor++; 
    }

    public Professor getProfessor(int i) 
    {
        return professores[i]; 
    }

    public void setCurso(Curso curso) 
    {
        this.cursos[contadorCurso] = curso;
        contadorCurso++; 
    }

    public Curso getCurso(int i) 
    {
        return cursos[i]; 
    }

    //metodos para fazer os logins
    public void fazerLoginUsuarioAluno(String email, String senha) 
    {
        for(int i = 0; i < contadorAluno; i++) 
        {
            if(VerificaVariaveis(getAluno(i).getEmail(), email) == true && VerificaVariaveis(getAluno(i).getSenhaPessoal(), senha) == true && getAluno(i).getNivelAcesso() == 3) {
                MenuAluno(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    public void fazerLoginUsuarioAdministrador(String email, String senha) 
    {
        for(int i = 0; i < contadorAdministrador; i++) 
        {
            if(VerificaVariaveis(getAdministrador(i).getEmail(), email) == true && VerificaVariaveis(getAdministrador(i).getSenhaPessoal(), senha) == true && getAdministrador(i).getNivelAcesso() == 1) {
                MenuAdministrador(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    public void fazerLoginUsuarioProfessor(String email, String senha) 
    {
        for(int i = 0; i < contadorProfessor; i++) 
        {
            if(VerificaVariaveis(getProfessor(i).getEmail(), email) == true && VerificaVariaveis(getProfessor(i).getSenhaPessoal(), senha) == true && getProfessor(i).getNivelAcesso() == 2) {
                MenuProfessor(i);
            } else {
                System.out.println("Email ou senha Incorretos!"); 
            }
        }   
    }

    //método que verifica variaveis para ver se são iguais
    public boolean VerificaVariaveis(String variavel1, String variavel2) 
    {
        if (variavel1.equals(variavel2)) 
        {
            return true; 
        } else {
            return false; 
        }
    }

    //metodo que gera um codigo para os usuarios
    public int GerarCodigoUsuario() 
    {
        codigoUsuario += 1;  
        return codigoUsuario; 
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ALUNO !!!!

    //método que cria a conta do aluno
    public void criarContaAluno() 
    {
       
        String nome;
        String cpf;
        String email;
        String senha;
        String confirmaSenha;
        boolean controle = false;
        int codigoUsuario; 

        System.out.println();
        System.out.println("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("====================\nCADASTRO ALUNO\n====================\n\n");
        System.out.print("CPF: ");
        cpf = teclado.nextLine();
        System.out.print("Nome completo: ");
        nome = teclado.nextLine();
        System.out.print("Digite seu Email: ");
        email = teclado.nextLine();
        if(VerificaCPF(cpf) == true) {
            do{
                System.out.print("Senha: ");
                senha = teclado.nextLine();
                System.out.print("Confirme a senha: ");
                confirmaSenha = teclado.nextLine();
                //verificacao de senha
                boolean verifica = VerificaVariaveis(senha, confirmaSenha);
                if(verifica == true) {
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
        } else {
            System.out.println("Já existe um usuário cadastrado com esse CPF!");
        } 
    }

    //Gera o menu que o aluno vê 
    public void MenuAluno(int i) 
    {

        int escolha = 0; 

        do{
            try{
                
                System.out.println();
                System.out.println("===========================\nSISTEMA DE GESTÃO DE CURSOS\n===========================\n");
                System.out.println("MENU DO ALUNO\n");
                System.out.println("Bem vindo: " + " " + getAluno(i).getNome() + "\n");
                System.out.println("    1 - Consultar seus Dados.");
                System.out.println("    2 - Consultar Cursos disponíveis.");
                System.out.println("    3 - Se matricular em Cursos disponíveis.");
                System.out.println("    4 - Cancelar matricula em um curso.");
                System.out.println("    5 - Sair.");
                System.out.print("\nSelecione uma opção: ");

                escolha = Integer.parseInt(teclado.nextLine());

                switch(escolha) {
                    case 1:
                        Menu.limpaTela();
                        DadosAluno(i);
                        break;
                    case 2:
                        Menu.limpaTela();
                        CursosDisponiveisAluno();
                        break;
                    case 3:
                        Menu.limpaTela();
                        MatricularCurso(i);
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

    //gera os dados do aluno 
    public void DadosAluno(int i) 
    {
        System.out.println("Nome: " + getAluno(i).getNome());
        System.out.println("Codigo do Usuário: " + getAluno(i).getCodigoUsuario());
        System.out.println("Email: " + getAluno(i).getEmail());
        System.out.println("CPF: " + getAluno(i).getCPF());
    }

    //gera os cursos que estão disponíveis para a matrícula 
    public void CursosDisponiveisAluno() 
    {
        for( int i = 0; i < contadorCurso; i++) {
            if (getCurso(i).getStatus() == true && VerificaQuantidadeAlunosMatriculados(i) == true) {
                System.out.println();
                System.out.println("Nome do curso: " + getCurso(i).getNomeCurso());
                System.out.println("Código do curso: " + getCurso(i).getCodigoCurso());
                System.out.println("Carga Horária do curso: " + getCurso(i).getCargaHorariaCurso() + "horas");
                System.out.println("Ementa do curso: " + getCurso(i).getEmenta());
                System.out.println("Data Inicial do curso: " + getCurso(i).getDataInicio());
                System.out.println("Data Final do curso: " + getCurso(i).getDataFim());
                System.out.println("Professor do curso: " + getCurso(i).getProfessor().getNome());
                System.out.println();
            }
        }
    }

    public void MatricularCurso(int i) 
    {

        String codigo;
        CursosDisponiveisAluno();
        System.out.println("Digite o código do curso: ");
        codigo = teclado.nextLine();
        for(int j = 0; j < contadorCurso; j++) {
            if(VerificaVariaveis(getCurso(j).getCodigoCurso(), codigo) == true) {
                if(getCurso(i).getStatus() == true && VerificaQuantidadeAlunosMatriculados(j) == true) {
                    cursos[j].setAlunosMatriculados(alunos[i]); 
                    System.out.println("Matricula feita com sucesso!");
                    break;
                } else {
                    System.out.println("Esse curso está lotado ou não está disponível, não foi possível se matrícular!");
                    break;
                }
            } 
        }
    }

    public boolean VerificaQuantidadeAlunosMatriculados(int j) 
    {
        if(cursos[j].getQuantidadeAtualAlunos() < cursos[j].getQuantidadeMaximaAlunos()) {
            return true; 
        }
        return false; 
    }

    public boolean VerificaCPF(String cpf) 
    {
        for(int i = 0; i < contadorAluno; i++) {

            if(VerificaVariaveis(alunos[i].getCPF(), cpf) == true) {
                return false;
            } 
        }
        return true; 
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ADMINISTRADOR!!!!
    public void MenuAdministrador(int i) 
    {

        int escolha = 0;

        do {
            try
            {
                System.out.println();
                System.out.println("===========================\nSISTEMA DE GESTÃO DE CURSOS\n===========================\n");
                System.out.println("MENU DO ADMINISTRADOR\n");
                System.out.println("Bem vindo: " + " " + getAdministrador(i).getNome() + "\n");
                System.out.println("    1 - Cadastrar novo curso");
                System.out.println("    2 - Mostrar cursos cadastrados");
                System.out.println("    3 - Editar um curso cadastrado");
                System.out.println("    4 - Habilitar um curso cadastrado");
                System.out.println("    5 - Desabilitar um curso cadastrado");
                System.out.println("    6 - Cadastrar um novo Administrador");
                System.out.println("    7 - Cadastrar professor");
                System.out.println("    8 - Fazer logout");
                System.out.print("\nSelecione uma opção: ");
                escolha = Integer.parseInt(teclado.nextLine());
                switch(escolha) {
                    case 1:
                        Menu.limpaTela();
                        FormulariocadastrarCurso();
                        break;
                    case 2:
                        Menu.limpaTela();
                        DadosCursoAdministrativo();
                        break;
                    case 3:
                        Menu.limpaTela();
                        
                        break;
                    case 4:
                        Menu.limpaTela();
                        HabilitarCurso();
                        break;
                    case 5:
                        Menu.limpaTela();
                        DesabilitarCurso();
                        break;
                    case 6:
                        Menu.limpaTela();
                        FormularioCadastroAdministrador();
                        break;
                    case 7:
                        Menu.limpaTela();
                        FormulariocadastroProfessor();
                        break;
                    case 8:
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
        } while(escolha != 6);
    }

    public void FormularioCadastroAdministrador() 
    {
        
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
                controle = true;
                CadastrarAdministrador(nome, email, confirmaSenha);
            }else {
                System.out.println("A senha não é igual!" + "Tente Novamente!"); 
                System.out.println();
            }
        } while(controle != true);
    }

    public void CadastrarAdministrador(String nome, String email, String senha) 
    {
        int codigoUsuario; 
        codigoUsuario = GerarCodigoUsuario();
        Administrador administrador = new Administrador(nome, codigoUsuario, email, senha);
        setAdministrador(administrador);
        System.out.println("Conta Criada com Sucesso!");
    }

    public void FormulariocadastroProfessor() 
    {

        String nome; 
        String email; 
        String senha;
        String confirmaSenha;
        boolean controle = false; 

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
                controle = true;
                CadastrarProfessor(nome, email, confirmaSenha);
            }else {
                System.out.println("As senhas não são iguais!" + "Tente Novamente!"); 
                System.out.println();
            }
        } while(controle != true);
    }

    public void CadastrarProfessor(String nome, String email, String senha) 
    {

        int codigoUsuario = 0; 

        codigoUsuario = GerarCodigoUsuario();
        Professor professor = new Professor(nome, codigoUsuario, email, senha);
        setProfessor(professor);
        System.out.println("Conta Criada com Sucesso!");
    }

    public void FormulariocadastrarCurso() 
    {

        String nome;
        String codigo;
        int cargaHoraria;
        String ementa;
        String dataInicio;
        String dataFim;
        String horario; 
        int escolhaProfessor; 
        //boolean exception = false;
        // Formulario de cadastro de curso
        //do{
            //try{
                if(getProfessor(0) != null) {
                    System.out.print("====================\nCADASTRO DE CURSO\n====================\n\n");
                    System.out.print("Nome do curso: ");
                    nome = teclado.nextLine();
                    System.out.print("Código do curso: ");
                    codigo = teclado.nextLine();
                    System.out.print("Ementa do curso: ");
                    ementa = teclado.nextLine();
                    System.out.print("Data de inicio do curso: ");
                    dataInicio = teclado.nextLine();
                    System.out.print("Data final do curso: ");
                    dataFim = teclado.nextLine();
                    System.out.print("Horarios e dias: ");
                    horario = teclado.nextLine();
                    System.out.print("Carga horária do curso: ");
                    cargaHoraria = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Escolha um professor:");
                    System.out.println("Indice do Professor: " + "  " + "Nome: " );  
                    for(int i = 0; i < contadorProfessor; i++) {
                        if(getProfessor(i).getCargaHorariaAtual() != getProfessor(i).getCargaHorariaMaxima()) {
                            System.out.println(i + " " + getProfessor(i).getNome());
                        }
                    }
                    System.out.print("Digite o número do professor acima: "); 
                    escolhaProfessor = teclado.nextInt();
                    teclado.nextLine();
                    CadastrarCurso(nome, codigo, cargaHoraria, ementa, dataInicio, dataFim, horario, escolhaProfessor);
                } else {
                    System.out.println("Não há professores cadastrados!");
                }
            //} catch(NumberFormatException numberFormatException){
                //exception = true;
                //System.out.print("\nEntrada inválida, tente novamente.");
                //teclado.nextLine();
            //}
        //} while(exception = true);
    }

    public void CadastrarCurso(String nome, String codigo,int cargaHoraria, String ementa, String dataInicio, String dataFim, String horario, int escolhaProfessor) 
    {
        if(veficaCargaProfessor(escolhaProfessor,cargaHoraria) == true) {
            Curso curso = new Curso(nome, codigo, cargaHoraria, ementa, dataInicio, dataFim, horario, professores[escolhaProfessor]);
            setCurso(curso);
            professores[escolhaProfessor].setCargaHorariaAtual(professores[escolhaProfessor].getCargaHorariaAtual() + cargaHoraria);
            System.out.println("Curso Criado com Sucesso!");
        } else {
            System.out.println("Esse professor não pode mais receber disciplinas!");
        }
    }

    public void DadosCursoAdministrativo() 
    {
        for(int i = 0; i < contadorCurso; i++) {
            System.out.println("Nome: " + getCurso(i).getNomeCurso());
            System.out.println("Código Curso: " + getCurso(i).getCodigoCurso());
            System.out.println("Carga Horária: " + getCurso(i).getCargaHorariaCurso());
            System.out.println("Ementa: " + getCurso(i).getEmenta());
            System.out.println("Data Inicio: " + getCurso(i).getDataInicio());
            System.out.println("Data Fim: " + getCurso(i).getDataFim());
            System.out.println("Quantidade de Alunos Matriculados: " + getCurso(i).getQuantidadeAtualAlunos());
            System.out.println("Horários: : " + getCurso(i).getHorario());
            System.out.println("Professor do curso: " + getCurso(i).getProfessor().getNome());
            if(getCurso(i).getStatus() == true) {
                System.out.println("Status do Curso: " + "Ativo");
            } else {
                System.out.println("Status do Curso: " + "Desativado");
            }
            System.out.println();
        }
    }

    public void HabilitarCurso() 
    {

        String codigo; 

        DadosCursoAdministrativo();
        System.out.println("Digite o Código do curso: ");
        codigo = teclado.nextLine(); 
        for(int i = 0; i < contadorCurso; i++) {
            if(VerificaVariaveis(getCurso(i).getCodigoCurso(), codigo) == true) {
                if(getCurso(i).getStatus() == false) {
                    getCurso(i).setStatus(true);
                    getCurso(i).getProfessor().setCargaHorariaAtual(getCurso(i).getProfessor().getCargaHorariaAtual() + getCurso(i).getCargaHorariaCurso()); // Adiciona a carga horaria do professor
                    System.out.println("Curso habilitado");
                    break;
                } else {
                    System.out.println("Esse curso já está habilitado!");
                    break;
                }
            }
        }
    }

    public void DesabilitarCurso() 
    {
       
        String codigo; 

        DadosCursoAdministrativo();
        System.out.println("Digite o Código do curso: ");
        codigo = teclado.nextLine(); 
        for(int i = 0; i < contadorCurso; i++) {
            if(VerificaVariaveis(getCurso(i).getCodigoCurso(), codigo) == true) {
                if(getCurso(i).getStatus() == true) {
                    getCurso(i).setStatus(false);
                    getCurso(i).getProfessor().setCargaHorariaAtual(getCurso(i).getProfessor().getCargaHorariaAtual() - getCurso(i).getCargaHorariaCurso());// retira a carga horaria do professor
                    System.out.println("Curso desabilitado");
                break;
                } else {
                    System.out.println("Esse curso já está desabilitado!");
                }
            }
        }
    }

    public void EditarCurso() 
    {

        String codigo;
        int opcao; 

        System.out.println("Digite o Código do curso: ");
        codigo = teclado.nextLine(); 
        for(int i = 0; i < contadorCurso; i++) {
            if(VerificaVariaveis(getCurso(i).getCodigoCurso(), codigo) == true) {
                System.out.println("Nome: " + getCurso(i).getNomeCurso());
                System.out.println("Código Curso: " + getCurso(i).getCodigoCurso());
                System.out.println("Carga Horária: " + getCurso(i).getCargaHorariaCurso());
                System.out.println("Ementa: " + getCurso(i).getEmenta());
                System.out.println("Data Inicio: " + getCurso(i).getDataInicio());
                System.out.println("Data Fim: " + getCurso(i).getDataFim());
                System.out.println("Quantidade de Alunos Matriculados: " + getCurso(i).getQuantidadeAtualAlunos());
                System.out.println("Horários: : " + getCurso(i).getHorario());
                System.out.println("Professor do curso: " + getCurso(i).getProfessor().getNome());
                System.out.println("Status do Curso: " + getCurso(i).getStatus());
                System.out.println();
                System.out.println("Escolha uma opção para editar: ");
                opcao = teclado.nextInt(); 
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o novo nome do curso: "); 
                        break;
                
                    default:
                        break;
                }

                break;
            }
        }
               
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O PROFESSOR!!!!

    public void MenuProfessor(int i) 
    {

        int escolha = 0; 
        
        do{
            try{
                System.out.println();
                System.out.println("===========================\nSISTEMA DE GESTÃO DE CURSOS\n===========================\n");
                System.out.print("MENU DO PROFESSOR\n");
                System.out.println("Bem vindo: " + " " + getProfessor(i).getNome() + "\n");
                System.out.println("    1 - Consultar seus Dados.");
                System.out.println("    2 - Consultar seus Cursos.");
                System.out.println("    3 - Adicionar notas de alunos de um curso."); 
                System.out.println("    4 - Sair.");
                System.out.print("\nSelecione uma opção: ");
                escolha = Integer.parseInt(teclado.nextLine());
                switch(escolha) {
                    case 1:
                        Menu.limpaTela();
                        DadosProfessor(i);
                        break;
                    case 2:
            
                        break;
                    case 3:
                        AdicionarNotas(i);
                        break;
                    case 4:
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
        } while(escolha != 4);
    }

    public void DadosProfessor(int i) 
    {
        System.out.println("Nome: " + getProfessor(i).getNome());
        System.out.println("Codigo do Usuário: " + getProfessor(i).getCodigoUsuario());
        System.out.println("Email: " + getProfessor(i).getEmail());
        System.out.println("Carga Horário Atual: " + getProfessor(i).getCargaHorariaAtual());
    }

    //método que verifica se o professor pode receber a carga horaria
    public boolean veficaCargaProfessor(int i, int cargaHoraria) 
    {
        if(getProfessor(i).getCargaHorariaAtual() + cargaHoraria <= getProfessor(i).getCargaHorariaMaxima()) {
            return true; 
        } else {
            return false; 
        }
    }

    public void CursosProfessor(int i) 
    {
        for(int j = 0; j < contadorCurso; j++) {
            if(getCurso(j).getProfessor() == getProfessor(i)) {
                System.out.println();
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
    }

    public void AdicionarNotas(int i) 
    {

        String codigo;
        double nota; 

        CursosDisponiveisAluno();
        System.out.print("Digite o Código do curso: ");
        codigo = teclado.nextLine(); 
        for(int j = 0; j < contadorCurso; j++) {
            if(VerificaVariaveis(getCurso(j).getCodigoCurso(), codigo) == true) {
                for(int k = 0; k < getCurso(j).getQuantidadeAtualAlunos(); k++) {
                    System.out.println("Nome: " + getCurso(j).getAlunosMatriculados(k).getNome());
                    System.out.print("Digite a nota do Aluno acima: ");
                    //nota = teclado.nextDouble();
                    //setAluno(null);

                }
            }
        }
    }   
}