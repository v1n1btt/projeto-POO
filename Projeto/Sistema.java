package Projeto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema 
{

    private static int codigoUsuario = 1000;
    private static int contadorAluno = 0;
    private static int contadorAdministrador = 0;
    private static int contadorProfessor = 0; 
    private static int contadorCurso = 0; 
    private Aluno[] alunos = new Aluno[1000];
    private Administrador[] administradores = new Administrador[100]; 
    private Professor[] professoresSistema = new Professor[100];
    private Curso[] cursos = new Curso[100]; 

    Scanner teclado = new Scanner(System.in);

   /*  public void GerarAdministrador(String nome, String email, String senha) {
        int codigoUsuario; 
             codigoUsuario = GerarCodigoUsuario();
               Administrador administrador = new Administrador(nome, codigoUsuario, email, senha, "administrador");
               setAdministrador(administrador);
                System.out.println("Conta Criada com Sucesso!");
        
                // Criar arquivo para o administrador
                GeraArquivo.criarArquivoUsuario(administrador);
            }
        
            public void GerarProfessor(String nome, String email, String senha) {
                int codigoUsuario = 0; 
               codigoUsuario = GerarCodigoUsuario();
                Professor professor = new Professor(nome, codigoUsuario, email, senha, "professor");
                setProfessoresSistema(professor);
                System.out.println("Conta Criada com Sucesso!");
        
                // Criar arquivo para o professor
                GeraArquivo.criarArquivoUsuario(professor);
            }
        
            public void GerarCurso(nomeCurso, codigoCurso, cargaHoraria, ementa, dateInicio, dateFim, horario, professor, idProfessor) {
                if (veficaCargaProfessor(idProfessor, cargaHoraria) == true) {
                    Curso curso = new Curso(nome, codigo, cargaHoraria, ementa, dateInicio, dateFim, horario, professor);
                    setCurso(curso);
                    AdicionaCargaHorariaProfessor(contadorCurso);
                    System.out.println("Curso Criado com Sucesso!");
        
                    // Criar arquivo para o curso
                    GeraArquivo.criarArquivoCurso(nome, codigo, ementa, dateInicio, dateFim, horario, cargaHoraria, professor, curso.getAlunosMatriculados(), curso.getQuantidadeAtualAlunos());
                } else {
                    System.out.println("Esse professor não pode mais receber disciplinas!");
                }
            }*/

    public Sistema() 
    {
        Aluno aluno = new Aluno("Joao", 99997, "joao@.com", "joao", "aluno", "44412345810");
        Aluno aluno2 = new Aluno("Pedro", 99992, "pedro@.com", "pedro", "aluno", "44412145810");
        Administrador administrador = new Administrador("Admin", 99999, "admin@.com", "admin", "administrador");
        Professor professor = new Professor("Mario", 99998, "mario@.com", "mario", "professor");
        Professor professor2 = new Professor("Mauro", 99991, "mauro@.com", "mauro", "professor");
        Curso curso = new Curso("Matemática Básica", "MAT", 40,"...", "01/01/2024", "01/11/2024", "14h - 16h, quarta e sexta", professor);
        setAdministrador(administrador);
        setAluno(aluno);
        setAluno(aluno2);
        setProfessoresSistema(professor);
        setProfessoresSistema(professor2);
        setCurso(curso);
        AdicionaCargaHorariaProfessor(0);
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

    public void setProfessoresSistema(Professor professor) 
    {
        this.professoresSistema[contadorProfessor] = professor;
        contadorProfessor++; 
    }

    public Professor getProfessoresSistema(int i) 
    {
        return professoresSistema[i]; 
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
        for(int indiceAlunos = 0; indiceAlunos < contadorAluno; indiceAlunos++) 
        {
            if(VerificaVariaveis(getAluno(indiceAlunos).getEmail(), email) == true && VerificaVariaveis(getAluno(indiceAlunos).getSenhaPessoal(), senha) == true && VerificaVariaveis(getAluno(indiceAlunos).getNivelAcesso(), "aluno") == true) 
            {
                MenuAluno(indiceAlunos);
            } 
        }   
        System.out.println("Email ou senha Incorretos!"); 
    }

    public void fazerLoginUsuarioAdministrador(String email, String senha) 
    {
        for(int indiceAdministradores = 0; indiceAdministradores < contadorAdministrador; indiceAdministradores++) 
        {
            if(VerificaVariaveis(getAdministrador(indiceAdministradores).getEmail(), email) == true && VerificaVariaveis(getAdministrador(indiceAdministradores).getSenhaPessoal(), senha) == true && VerificaVariaveis(getAdministrador(indiceAdministradores).getNivelAcesso(), "administrador") == true) 
            {
                MenuAdministrador(indiceAdministradores);
            } 
        } 
        System.out.println("Email ou senha Incorretos!"); 
    }

    public void fazerLoginUsuarioProfessor(String email, String senha) 
    {
        for(int indiceProfessores = 0; indiceProfessores < contadorProfessor; indiceProfessores++) 
        {
            if(VerificaVariaveis(getProfessoresSistema(indiceProfessores).getEmail(), email) == true && VerificaVariaveis(getProfessoresSistema(indiceProfessores).getSenhaPessoal(), senha) == true && VerificaVariaveis(getProfessoresSistema(indiceProfessores).getNivelAcesso(), "professor") == true) 
            {
                MenuProfessor(indiceProfessores);
            } 
        }  
        System.out.println("Email ou senha Incorretos!");
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
        System.out.print("CPF (apenas números): ");
        cpf = teclado.nextLine();
        if(cpf.matches("[0-9]+") && cpf.length() == 11)
        {
            System.out.print("Nome completo: ");
            nome = teclado.nextLine();
            System.out.print("Digite seu Email: ");
            email = teclado.nextLine();
            if(email.matches("(.*)@(.*).com"))
            {
                if(VerificaCPF(cpf) == true) 
                {
                    do
                    {
                        System.out.print("Senha: ");
                        senha = teclado.nextLine();
                        System.out.print("Confirme a senha: ");
                        confirmaSenha = teclado.nextLine();
                        //verificacao de senha
                        boolean verifica = VerificaVariaveis(senha, confirmaSenha);
                        if(verifica == true) 
                        {
                            controle = true;
                            codigoUsuario = GerarCodigoUsuario();
                            Aluno aluno = new Aluno(nome, codigoUsuario, email, senha, "aluno", cpf);
                            setAluno(aluno);
                            System.out.println("Conta Criada com Sucesso!");
                            teclado.nextLine();
                        }else {
                            System.out.println("A senha não é igual!" + "Tente Novamente!"); 
                            System.out.println();
                        }
                
                        
                    } while(controle != true);
                } else {
                    System.out.println("Já existe um usuário cadastrado com esse CPF!");
                }
            }
            else {
                System.out.println("Formato do email inválido, tente novamente.");
                teclado.nextLine();
            }
        }
        else{
            System.out.println("Formato do CPF inválido, tente novamente.");
            teclado.nextLine();
        }
    }

    //Gera o menu que o aluno vê 
    public void MenuAluno(int idAluno) 
    {

        int escolha = 0; 

        do{
            try
            {
                System.out.println();
                System.out.println("===========================\nSISTEMA DE GESTÃO DE CURSOS\n===========================\n");
                System.out.println("MENU DO ALUNO\n");
                System.out.println("Bem vindo: " + " " + getAluno(idAluno).getNome() + "\n");
                System.out.println("    1 - Consultar seus Dados.");
                System.out.println("    2 - Consultar Cursos disponíveis.");
                System.out.println("    3 - Se matricular em Cursos disponíveis.");
                System.out.println("    4 - Cancelar matricula em um curso.");
                System.out.println("    5 - Obter o certificado de conclusão de um curso");
                System.out.println("    6 - Sair.");
                System.out.print("\nSelecione uma opção: ");

                escolha = Integer.parseInt(teclado.nextLine());

                switch(escolha) 
                {
                    case 1:
                        Menu.limpaTela();
                        DadosAluno(idAluno);
                        break;
                    case 2:
                        Menu.limpaTela();
                        CursosDisponiveisAluno();
                        break;
                    case 3:
                        Menu.limpaTela();
                        MatricularCurso(idAluno);
                        break;
                    case 4:

                        break;
                    case 5:
                        Menu.limpaTela();
                        break;
                    case 6:
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
        }while(escolha != 5);
    }

    //gera os dados do aluno 
    public void DadosAluno(int idAluno) 
    {
        System.out.println("Nome: " + getAluno(idAluno).getNome());
        System.out.println("Codigo do Usuário: " + getAluno(idAluno).getCodigoUsuario());
        System.out.println("Email: " + getAluno(idAluno).getEmail());
        System.out.println("CPF: " + getAluno(idAluno).getCPF());
    }

    //gera os cursos que estão disponíveis para a matrícula 
    public void CursosDisponiveisAluno() 
    {
        for( int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) {
            if (getCurso(indiceCursos).getStatus() == true && VerificaQuantidadeAlunosMatriculados(indiceCursos) == true) {
                System.out.println();
                System.out.println("Nome do curso: " + getCurso(indiceCursos).getNomeCurso());
                System.out.println("Código do curso: " + getCurso(indiceCursos).getCodigoCurso());
                System.out.println("Carga Horária do curso: " + getCurso(indiceCursos).getCargaHorariaCurso() + " Horas");
                System.out.println("Ementa do curso: " + getCurso(indiceCursos).getEmenta());
                System.out.println("Data Inicial do curso: " + getCurso(indiceCursos).getDateInicio());
                System.out.println("Data Final do curso: " + getCurso(indiceCursos).getDateFim());
                System.out.println("Professor do curso: " + getCurso(indiceCursos).getProfessor().getNome());
                System.out.println("Horários e dias do curso: " + getCurso(indiceCursos).getHorario());
                System.out.println("Quantidade de alunos matrículados: " + getCurso(indiceCursos).getQuantidadeAtualAlunos());
                System.out.println();
            }
        }
    }

    public void MatricularCurso(int idAluno) 
    {
        String codigo;

        CursosDisponiveisAluno();

        System.out.print("Digite o código do curso: ");
        codigo = teclado.nextLine();

        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(VerificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
            {
                if(getCurso(indiceCursos).getStatus() == true && VerificaQuantidadeAlunosMatriculados(indiceCursos) == true) 
                {
                   getCurso(indiceCursos).setAlunosMatriculados(getAluno(idAluno)); 
                    System.out.println("Matricula feita com sucesso!");
                    break;
                } else {
                    System.out.println("Esse curso está lotado ou não está disponível, não foi possível se matrícular!");
                    break;
                }
            } 
        }
    }

    public boolean VerificaQuantidadeAlunosMatriculados(int indiceCurso) 
    {
        if(getCurso(indiceCurso).getQuantidadeAtualAlunos() <= getCurso(indiceCurso).getQuantidadeMaximaAlunos()) 
        {
            return true; 
        }
        return false; 
    }

    public boolean VerificaCPF(String cpf) 
    {
        for(int indiceAlunos = 0; indiceAlunos < contadorAluno; indiceAlunos++) 
        {
            if(VerificaVariaveis(getAluno(indiceAlunos).getCPF(), cpf) == true) 
            {
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
                        EditarCurso();
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
        Administrador administrador = new Administrador(nome, codigoUsuario, email, senha, "administrador");
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
        Professor professor = new Professor(nome, codigoUsuario, email, senha, "professor");
        setProfessoresSistema(professor);
        System.out.println("Conta Criada com Sucesso!");
    }

    public void FormulariocadastrarCurso() 
    {

        String nome;
        String codigo;
        int cargaHoraria;
        String ementa;
        String dateInicio;
        String dateFim;
        String horario; 
        int escolhaProfessor; 
        boolean exception;
        // Formulario de cadastro de curso
        do{
            try{
                exception = false;
                Menu.limpaTela();
                if(getProfessoresSistema(0) != null) {
                    System.out.print("====================\nCADASTRO DE CURSO\n====================\n\n");
                    System.out.print("Nome do curso: ");
                    nome = teclado.nextLine();
                    System.out.print("Código do curso: ");
                    codigo = teclado.nextLine();
                    System.out.print("Ementa do curso: ");
                    ementa = teclado.nextLine();
                    System.out.print("Data de inicio do curso: ");
                    dateInicio = teclado.nextLine();
                    System.out.print("Data final do curso: ");
                    dateFim = teclado.nextLine();
                    System.out.print("Horarios e dias: ");
                    horario = teclado.nextLine();
                    System.out.print("Carga horária do curso: ");
                    cargaHoraria = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Escolha um professor:");
                    System.out.println("Indice do Professor: " + "  " + "Nome: " );  
                    for(int indiceProfessores = 0; indiceProfessores < contadorProfessor; indiceProfessores++) 
                    {
                        if(getProfessoresSistema(indiceProfessores).getCargaHorariaAtual() != getProfessoresSistema(indiceProfessores).getCargaHorariaMaxima()) 
                        {
                            System.out.println(indiceProfessores + " " + getProfessoresSistema(indiceProfessores).getNome());
                        }
                    }
                    System.out.print("Digite o número do professor acima: "); 
                    escolhaProfessor = teclado.nextInt();
                    teclado.nextLine();
                    CadastrarCurso(nome, codigo, cargaHoraria, ementa, dateInicio, dateFim, horario, getProfessoresSistema(escolhaProfessor), escolhaProfessor);
                } else {
                    System.out.println("Não há professores cadastrados!");
                }
            } catch(InputMismatchException inputMismatchException)
            {
                exception = true;
                System.out.print("\nEntrada inválida, tente novamente.\n");
                teclado.nextLine();
                teclado.nextLine();
            }
        } while(exception = true);
    }

    public void CadastrarCurso(String nome, String codigo,int cargaHoraria, String ementa, String dateInicio, String dateFim, String horario, Professor professor, int idProfessor) 
    {
        if(veficaCargaProfessor(idProfessor,cargaHoraria) == true) 
        {
            Curso curso = new Curso(nome, codigo, cargaHoraria, ementa, dateInicio, dateFim, horario, professor);
            AdicionaCargaHorariaProfessor(contadorCurso);
            setCurso(curso);
            System.out.println("Curso Criado com Sucesso!");
        } else {
            System.out.println("Esse professor não pode mais receber disciplinas!");
        }
    }

    public void DadosCursoAdministrativo() 
    {
        for(int indiceCurso = 0; indiceCurso < contadorCurso; indiceCurso++) {
            System.out.println("Nome: " + getCurso(indiceCurso).getNomeCurso());
            System.out.println("Código Curso: " + getCurso(indiceCurso).getCodigoCurso());
            System.out.println("Carga Horária: " + getCurso(indiceCurso).getCargaHorariaCurso());
            System.out.println("Ementa: " + getCurso(indiceCurso).getEmenta());
            System.out.println("Data Inicio: " + getCurso(indiceCurso).getDateInicio());
            System.out.println("Data Fim: " + getCurso(indiceCurso).getDateFim());
            System.out.println("Quantidade de Alunos Matriculados: " + getCurso(indiceCurso).getQuantidadeAtualAlunos());
            System.out.println("Horários: : " + getCurso(indiceCurso).getHorario());
            System.out.println("Professor do curso: " + getCurso(indiceCurso).getProfessor().getNome());
            if(getCurso(indiceCurso).getStatus() == true) {
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
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) {
            if(VerificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
            {
                if(getCurso(indiceCursos).getStatus() == false) 
                {
                    getCurso(indiceCursos).setStatus(true);
                    AdicionaCargaHorariaProfessor(indiceCursos);
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
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) {
            if(VerificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
            {
                if(getCurso(indiceCursos).getStatus() == true) 
                {
                    getCurso(indiceCursos).setStatus(false);
                    RetiraCargaHorariaProfessor(indiceCursos);
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

        DadosCursoAdministrativo();
        System.out.println("Digite o Código do curso: ");
        codigo = teclado.nextLine(); 
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(VerificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
            {
                System.out.println("1 - Nome: " + getCurso(indiceCursos).getNomeCurso());
                System.out.println("2 - Código Curso: " + getCurso(indiceCursos).getCodigoCurso());
                System.out.println("3 - Carga Horária: " + getCurso(indiceCursos).getCargaHorariaCurso());
                System.out.println("4 - Ementa: " + getCurso(indiceCursos).getEmenta());
                System.out.println("5 - Data Inicio: " + getCurso(indiceCursos).getDateInicio());
                System.out.println("6 - Data Fim: " + getCurso(indiceCursos).getDateFim());
                System.out.println("7 - Horários: : " + getCurso(indiceCursos).getHorario());
                System.out.println("8 - Professor do curso: " + getCurso(indiceCursos).getProfessor().getNome());
                System.out.println();
                System.out.println("Escolha uma opção para editar: ");
                opcao = teclado.nextInt();
                teclado.nextLine();
                Menu.limpaTela();
                switch (opcao) 
                {
                    case 1:
                        System.out.println("Digite o novo nome do curso: ");
                        String novoNome = teclado.nextLine();
                        getCurso(indiceCursos).setNomeCurso(novoNome);
                        System.out.println("Modificado com sucesso!");
                        return;
                    case 2:
                        System.out.println("Digite o novo Código do curso: ");
                        String novoCodigo = teclado.nextLine();
                        getCurso(indiceCursos).setCodigoCurso(novoCodigo);
                        System.out.println("Modificado com sucesso!");
                        return;
                    case 3:
                        System.out.println("Digite a nova Carga Horária do curso: ");
                        int novaCargaHoraria = teclado.nextInt();
                        teclado.nextInt();
                        getCurso(indiceCursos).setCargaHorariaCurso(novaCargaHoraria);
                        System.out.println("Modificado com sucesso!");
                        return;
                    case 4:
                        System.out.println("Digite a nova Ementa do curso: ");
                        String novaEmenta = teclado.nextLine();
                        getCurso(indiceCursos).setEmenta(novaEmenta);
                        System.out.println("Modificado com sucesso!");
                        return;
                    case 5:
                        System.out.println("Digite a nova Data de Inicio do curso: ");
                        String novaDataInicio = teclado.nextLine();
                        getCurso(indiceCursos).setDateInicio(novaDataInicio);;
                        System.out.println("Modificado com sucesso!");
                        return;
                    case 6:
                        System.out.println("Digite a nova Data de finalização do curso: ");
                        String novaDataFim = teclado.nextLine();
                        getCurso(indiceCursos).setDateFim(novaDataFim);
                        System.out.println("Modificado com sucesso!");
                        return;
                    case 7:
                        System.out.println("Digite os novos Horários do curso: ");
                        String novosHorarios = teclado.nextLine();
                        getCurso(indiceCursos).setHorario(novosHorarios);
                        System.out.println("Modificado com sucesso!");
                        return;
                    case 8:
                        System.out.println("Escolha um professor abaixo: ");
                        System.out.println("Indice do Professor: " + "  " + "Nome: " );  
                        for(int indiceProfessor = 0; indiceProfessor < contadorProfessor; indiceProfessor++) 
                        {
                            if(getProfessoresSistema(indiceProfessor).getCargaHorariaAtual() != getProfessoresSistema(indiceProfessor).getCargaHorariaMaxima()) 
                            {
                                System.out.println(indiceProfessor + " " + getProfessoresSistema(indiceProfessor).getNome());
                            }
                        }
                        System.out.print("Digite o número do professor acima: "); 
                        int escolhaProfessor = teclado.nextInt();
                        teclado.nextLine();
                        getCurso(indiceCursos).setProfessor(getProfessoresSistema(escolhaProfessor));
                        AdicionaCargaHorariaProfessor(indiceCursos);
                        RetiraCargaHorariaProfessor(indiceCursos);
                        return;
                    default:
                        break;
                }
            }
        }
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O PROFESSOR!!!!

    public void MenuProfessor(int idProfessor) 
    {

        int escolha = 0; 
        
        do{
            try{
                System.out.println();
                System.out.println("===========================\nSISTEMA DE GESTÃO DE CURSOS\n===========================\n");
                System.out.print("MENU DO PROFESSOR\n");
                System.out.println("Bem vindo: " + " " + getProfessoresSistema(idProfessor).getNome() + "\n");
                System.out.println("    1 - Consultar seus Dados.");
                System.out.println("    2 - Consultar os Cursos em que você é o responsável.");
                System.out.println("    3 - Adicionar notas de alunos de um curso e encerra o curso."); 
                System.out.println("    4 - Sair.");
                System.out.print("\nSelecione uma opção: ");
                escolha = Integer.parseInt(teclado.nextLine());
                switch(escolha) {
                    case 1:
                        Menu.limpaTela();
                        DadosProfessor(idProfessor);
                        break;
                    case 2:
                        Menu.limpaTela();
                        CursosProfessor(idProfessor);
                        break;
                    case 3:
                        Menu.limpaTela();
                        AdicionarNotas(idProfessor);
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

    public void DadosProfessor(int idProfessor) 
    {
        System.out.println("Nome: " + getProfessoresSistema(idProfessor).getNome());
        System.out.println("Codigo do Usuário: " + getProfessoresSistema(idProfessor).getCodigoUsuario());
        System.out.println("Email: " + getProfessoresSistema(idProfessor).getEmail());
        System.out.println("Carga Horário Atual: " + getProfessoresSistema(idProfessor).getCargaHorariaAtual());
    }

    //método que verifica se o professor pode receber a carga horaria
    public boolean veficaCargaProfessor(int idProfessor, int cargaHoraria) 
    {
        if(getProfessoresSistema(idProfessor).getCargaHorariaAtual() + cargaHoraria <= getProfessoresSistema(idProfessor).getCargaHorariaMaxima()) 
        {
            return true; 
        } else {
            return false; 
        }
    }

    // Adiciona a carga horaria do professor
    public void AdicionaCargaHorariaProfessor(int idCurso) 
    {
        getCurso(idCurso).getProfessor().setCargaHorariaAtual(getCurso(idCurso).getProfessor().getCargaHorariaAtual() + getCurso(idCurso).getCargaHorariaCurso()); 
    }

    // retira a carga horaria do professor
    public void RetiraCargaHorariaProfessor(int idCurso) 
    {
        getCurso(idCurso).getProfessor().setCargaHorariaAtual(getCurso(idCurso).getProfessor().getCargaHorariaAtual() - getCurso(idCurso).getCargaHorariaCurso());
    }

    public void CursosProfessor(int idProfessor) 
    {
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(getCurso(indiceCursos).getProfessor() == getProfessoresSistema(idProfessor)) 
            {
                System.out.println();
                System.out.println("Nome: " + getCurso(idProfessor).getNomeCurso());
                System.out.println("Código Curso: " + getCurso(idProfessor).getCodigoCurso());
                System.out.println("Carga Horária: " + getCurso(idProfessor).getCargaHorariaCurso());
                System.out.println("Ementa: " + getCurso(idProfessor).getEmenta());
                System.out.println("Data Inicio: " + getCurso(idProfessor).getDateInicio());
                System.out.println("Data Fim: " + getCurso(idProfessor).getDateFim());
                System.out.println("Quantidade de Alunos Matriculados: " + getCurso(idProfessor).getQuantidadeAtualAlunos());
                System.out.println("Horários: : " + getCurso(idProfessor).getHorario());
                System.out.println("Status do Curso: " + getCurso(idProfessor).getStatus());
                System.out.println();
            }
        }
    }

    public void AdicionarNotas(int idProfessor) 
    {

        String codigo;
        double nota; 

        CursosProfessor(idProfessor);
        System.out.print("Digite o Código do curso: ");
        codigo = teclado.nextLine();
        System.out.println();
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(VerificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true && getCurso(indiceCursos).getProfessor() == getProfessoresSistema(idProfessor)) 
            {
                for(int indiceAlunos = 0; indiceAlunos < getCurso(indiceCursos).getQuantidadeAtualAlunos(); indiceAlunos++) 
                {
                    if(getCurso(indiceCursos).getNota(indiceAlunos) == 0)
                    {
                        System.out.println("Nome: " + getCurso(indiceCursos).getAlunosMatriculados(indiceAlunos).getNome());
                        System.out.println("Código Usuário: " + getCurso(indiceCursos).getAlunosMatriculados(indiceAlunos).getCodigoUsuario());
                        System.out.print("Digite a nota do Aluno acima: ");
                        teclado.nextLine();
                        nota = teclado.nextDouble();
                        getCurso(indiceAlunos).setNota(nota);
                        System.out.println("A nota do aluno acima é: " + " " + getCurso(indiceCursos).getNota(indiceAlunos));
                    }
                }
                //getCurso(indiceCursos).setStatus(false);
                System.out.println("Todas as notas de todos os alunos foram cadastradas!");
                //System.out.println("O curso foi encerrado!");
            }
        }
    }   
}