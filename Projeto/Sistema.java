package Projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private Professor[] professoresSistema = new Professor[50];
    private Curso[] cursos = new Curso[100]; 

    Scanner teclado = new Scanner(System.in);

    public Sistema() 
    {
        
    }

    public void setAluno(Aluno aluno) 
    {
        this.alunos[contadorAluno] = aluno;
        contadorAluno++; 
    }

    /**
     * @param indiceAluno
     * @return
     */

    public Aluno getAluno(int indiceAluno) 
    {
        return alunos[indiceAluno]; 
    }

    /**
     * @param administrador
     */

    public void setAdministrador(Administrador administrador) 
    {
        this.administradores[contadorAdministrador] = administrador;
        contadorAdministrador++; 
    }

    /**
     * @param indiceAdministrador
     * @return
     */
    public Administrador getAdministrador(int indiceAdministrador) 
    {
        return administradores[indiceAdministrador]; 
    }

    /**
     * @param professor
     */

    public void setProfessoresSistema(Professor professor) 
    {
        this.professoresSistema[contadorProfessor] = professor;
        contadorProfessor++; 
    }

    /**
     * @param indiceProfessor
     * @return
     */

    public Professor getProfessoresSistema(int indiceProfessor) 
    {
        return professoresSistema[indiceProfessor]; 
    }

    /**
     * @param curso
     */

    public void setCurso(Curso curso) 
    {   
        this.cursos[contadorCurso] = curso;
        contadorCurso++; 
    }

    /**
     * @param indiceCurso
     * @return
     */
    
    public Curso getCurso(int indiceCurso) 
    {
        return cursos[indiceCurso]; 
    }

    //metodos para fazer os logins
    /**
     * @param email
     * @param senha
     */
    public void fazerLoginUsuarioAluno(String email, String senha) 
    {
        boolean sucesso = false;

        for (int indiceAlunos = 0; indiceAlunos < contadorAluno; indiceAlunos++) {
            if (verificaVariaveis(getAluno(indiceAlunos).getEmail(), email) == true &&
                verificaVariaveis(getAluno(indiceAlunos).getSenhaPessoal(), senha) == true &&
                verificaVariaveis(getAluno(indiceAlunos).getNivelAcesso(), "aluno") == true) {
                sucesso = true;
                MenuAluno(indiceAlunos);
            }
        }
        if (sucesso == false) {
            System.out.println("\nEmail ou senha Incorretos!");
            teclado.nextLine();
            Menu.limpaTela();
        }
    }
   
    /**
     * @param email
     * @param senha
     */
    public void fazerLoginUsuarioAdministrador(String email, String senha) 
    {
        boolean loginSucesso = false;
        for(int indiceAdministradores = 0; indiceAdministradores < contadorAdministrador; indiceAdministradores++) 
        {
            Administrador administrador = getAdministrador(indiceAdministradores);
            if (administrador != null && verificaVariaveis(administrador.getEmail(), email) == true && verificaVariaveis(administrador.getSenhaPessoal(), senha) == true && verificaVariaveis(administrador.getNivelAcesso(), "administrador") == true) 
            {
                MenuAdministrador(indiceAdministradores);
                loginSucesso = true;
                break;
            } 
        }   
        if (!loginSucesso) {
            System.out.println("\nEmail ou senha Incorretos!"); 
            teclado.nextLine();
            Menu.limpaTela();
        }
    }

    /**
     * @param email
     * @param senha
     */
    public void fazerLoginUsuarioProfessor(String email, String senha) 
    {
        boolean sucesso = false;

        for (int indiceProfessores = 0; indiceProfessores < contadorProfessor; indiceProfessores++) {
            if (verificaVariaveis(getProfessoresSistema(indiceProfessores).getEmail(), email) == true &&
                verificaVariaveis(getProfessoresSistema(indiceProfessores).getSenhaPessoal(), senha) == true &&
                verificaVariaveis(getProfessoresSistema(indiceProfessores).getNivelAcesso(), "professor") == true) {
                sucesso = true;
                MenuProfessor(indiceProfessores);
            }
        }
        if (sucesso == false) {
            System.out.println("\nEmail ou senha Incorretos!");
            teclado.nextLine();
            Menu.limpaTela();
        }
    }

    //método que verifica variaveis para ver se são iguais
    /**
    * @param variavel1
    * @param variavel2
    * @return
    */
    public boolean verificaVariaveis(String variavel1, String variavel2) 
    {
        if (variavel1.equals(variavel2)) 
        {
            return true; 
        } else {
            return false; 
        }
    }

    //metodo que gera um codigo para os usuarios
    /**
     * @return
     */
    public int GerarCodigoUsuario() 
    {
        codigoUsuario += 1;  
        return codigoUsuario; 
    }

    //Busca um curso no vetor cursos cadastrados
    /**
     * @param codigo
     * @return
     */
    public Curso buscaCurso(String codigo) 
    {
        int indiceCurso = 0;
        Curso CursoProcurado; 

        while(indiceCurso < contadorCurso && verificaVariaveis(getCurso(indiceCurso).getCodigoCurso(), codigo) == false)
        {
            indiceCurso = indiceCurso + 1;    
        }
        CursoProcurado = getCurso(indiceCurso);
        return CursoProcurado;
    }

    //AQUI ESTÃO OS MÉTODOS DOS ARQUIVOS 
    public void carregarProfessores() 
    {
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/professores.csv"))) {
            br.readLine();
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                int codigoUsuario = Integer.parseInt(dados[1]);
                String email = dados[2];
                String senha = dados[3];
                Professor professor = new Professor(nome, codigoUsuario, email, senha, "professor");
                setProfessoresSistema(professor);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar professores do arquivo professores.csv: " + e.getMessage());
        }
    }

    public void carregarAlunos() 
    {
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/alunos.csv"))) {
            br.readLine();
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                String cpf = dados[1];
                int codigoUsuario = Integer.parseInt(dados[2]);
                String email = dados[3];
                String senha = dados[4];
                Aluno aluno = new Aluno(nome, codigoUsuario, email, senha, "aluno", cpf);
                setAluno(aluno);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos do arquivo alunos.csv: " + e.getMessage());
        }
    }

    public void carregarAdministradores() 
    {
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/administradores.csv"))) {
            br.readLine();
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                int codigoUsuario = Integer.parseInt(dados[1]);
                String email = dados[2];
                String senha = dados[3];
                Administrador administrador = new Administrador(nome, codigoUsuario, email, senha, "administrador");
                setAdministrador(administrador);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar administradores do arquivo administradores.csv: " + e.getMessage());
        }
    }

    public void carregarCursos() 
{
    String linha;

    try (BufferedReader br = new BufferedReader(new FileReader("Projeto/cursos.csv"))) {
        br.readLine(); // Ignora o cabeçalho
        br.readLine(); // Ignora o cabeçalho
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            if (dados.length >= 8) { // Verifica se a linha tem pelo menos 8 colunas
                String nomeCurso = dados[0];
                String codigoCurso = dados[1];
                int cargaHoraria = Integer.parseInt(dados[2]);
                String ementa = dados[3];
                String dataInicio = dados[4];
                String dataFim = dados[5];
                String horario = dados[6];
                int codigoProfessor = Integer.parseInt(dados[7]);
                Professor professor = getProfessoresSistema(codigoProfessor);
                Curso curso = new Curso(nomeCurso, codigoCurso, cargaHoraria, ementa, dataInicio, dataFim, horario, professor, alunos, codigoProfessor, false, new double[0], codigoProfessor, 0);
                setCurso(curso);
            } else {
                System.out.println("Linha inválida: " + linha);
            }
        }
    } catch (IOException e) {
        System.out.println("Erro ao carregar cursos do arquivo cursos.csv: " + e.getMessage());
    }
}

    public void carregarMatriculas() {
        String linha1, linha2;
        try (BufferedReader brCursos = new BufferedReader(new FileReader("Projeto/cursos.csv"))) {
            brCursos.readLine();
            brCursos.readLine();
            try (BufferedReader brAlunos = new BufferedReader(new FileReader("Projeto/alunos.csv"))) {
                brAlunos.readLine();
                brAlunos.readLine();
                while ((linha1 = brCursos.readLine()) != null && (linha2 = brAlunos.readLine()) != null) {
                    String[] dadosCurso = linha1.split(",");
                    if (dadosCurso.length > 1) {
                        String codigoCurso = dadosCurso[1];
                        Curso curso = buscaCurso(codigoCurso);
                        if (curso != null) {
                            String[] dadosAluno = linha2.split(",");
                            if (dadosAluno.length > 2) {
                                int codigoAluno = Integer.parseInt(dadosAluno[2]);
                                Aluno aluno = buscaAlunoPorCodigo(codigoAluno);
                                if (aluno != null) {
                                    curso.setAlunosMatriculados(aluno);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao carregar alunos do arquivo alunos.csv: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar matrículas do arquivo cursos.csv: " + e.getMessage());
        }
    }

    public void carregarNotas()
    {
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/notas.csv"))) {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String codigoCurso = dados[0];
                int codigoAluno = Integer.parseInt(dados[1]);
                double nota = Double.parseDouble(dados[2]);
                Curso curso = buscaCurso(codigoCurso);
                Aluno aluno = buscaAlunoPorCodigo(codigoAluno);
                if (curso != null && aluno != null) {
                    curso.setNota(aluno, nota);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar notas do arquivo notas.csv: " + e.getMessage());
        }
    }

/*    public void salvarNotas() 
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Projeto/notas.csv"))) {
            for (int i = 0; i < contadorCurso; i++) {
                Curso curso = cursos[i];
                for (int j = 0; j < curso.getQuantidadeAtualAlunos(); j++) {
                    Aluno aluno = curso.getAlunosMatriculados(j);
                    double nota = curso.getNota(j);
                    bw.write(curso.getCodigoCurso() + "," + aluno.getCodigoUsuario() + "," + nota);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar notas no arquivo notas.csv: " + e.getMessage());
        }
    }
*/

    /**
    * @param curso
    */
    public void editarCursoNoArquivo(Curso curso) {
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/cursos.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("Projeto/cursos_temp.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if(dados[1].equals(curso.getCodigoCurso()))  {
                    bw.write(curso.getNomeCurso() + "," + curso.getCodigoCurso() + "," + curso.getCargaHorariaCurso() + "," + curso.getEmenta() + "," + curso.getDateInicio() + "," + curso.getDateFim() + "," + curso.getHorario() + "," + curso.getQuantidadeMaximaAlunos() + "," + curso.getProfessor().getCodigoUsuario());
                } else {
                    bw.write(linha);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao editar curso no arquivo cursos.csv: " + e.getMessage());
        }
        new File("cursos.csv").delete();
        new File("cursos_temp.csv").renameTo(new File("Projeto/cursos.csv"));
    }

    /**
    * @param idProfessor
    */
    public void carregarCursosProfessor(int idProfessor) {
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/cursos.csv"))) {
            br.readLine();
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length >= 8) {
                    String nomeCurso = dados[0];
                    String codigoCurso = dados[1];
                    int cargaHoraria = Integer.parseInt(dados[2]);
                    String ementa = dados[3];
                    String dataInicio = dados[4];
                    String dataFim = dados[5];
                    String horario = dados[6];
                    int codigoProfessor = Integer.parseInt(dados[7]);
                    if (codigoProfessor == getProfessoresSistema(idProfessor).getCodigoUsuario()) {
                        Professor professor = getProfessoresSistema(idProfessor);
                        Curso curso = new Curso(nomeCurso, codigoCurso, cargaHoraria, ementa, dataInicio, dataFim, horario, professor, alunos, 0, false, new double[0], 0, 0);
                        setCurso(curso);
                    }
                } else {
                    System.out.println("Linha inválida: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar cursos do arquivo cursos.csv: " + e.getMessage());
        }
    }

    // Edita o professor no arquivo professores.csv
    /**
    * @param professor
    */
    public void editarProfessorNoArquivo(Professor professor) {
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/professores.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("Projeto/Professores_temp.csv"))) {
            String linha;
            bw.write(br.readLine());
            bw.write("\n\n");
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[1].equals(String.valueOf(professor.getCodigoUsuario()))) {
                    bw.write(professor.getNome() + "," + professor.getCodigoUsuario() + "," + professor.getEmail() + "," + professor.getSenhaPessoal() + ",professor," + professor.getCargaHorariaAtual());
                } else {
                    bw.write(linha);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao editar professor no arquivo professores.csv: " + e.getMessage());
        }
        new File("professores.csv").delete();
        new File("professores_temp.csv").renameTo(new File("Projeto/professores.csv"));
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ALUNO !!!!
    //método que cria a conta do aluno
    public void criarContaAluno() {
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
        if (cpf.matches("[0-9]+") && cpf.length() == 11) {
            System.out.print("Nome completo: ");
            nome = teclado.nextLine();
            System.out.print("Digite seu Email: ");
            email = teclado.nextLine();
            if (email.matches("(.*)@(.*).(.*)") && !email.substring(0, email.indexOf("@")).isEmpty() && !email.substring(email.indexOf("@") + 1, email.indexOf(".")).isEmpty() && !email.substring(email.indexOf(".") + 1).isEmpty()) {
                if (VerificaCPF(cpf) == true && VerificaEmail(email) == true) {
                    do {
                        System.out.print("Senha: ");
                        senha = teclado.nextLine();
                        if (!senha.isEmpty()) {
                            System.out.print("Confirme a senha: ");
                            confirmaSenha = teclado.nextLine();
                            boolean verifica = verificaVariaveis(senha, confirmaSenha);
                            if (verifica == true) {
                                controle = true;
                                codigoUsuario = GerarCodigoUsuario();
                                Aluno aluno = new Aluno(nome, codigoUsuario, email, senha, "aluno", cpf);
                                setAluno(aluno);
                                System.out.print("Conta Criada com Sucesso!");
                                GeraArquivo.salvarAluno(aluno);
                                teclado.nextLine();
                            } else {
                                System.out.println("A senha não é igual, tente Novamente.\n");
                            }
                        } else {
                            System.out.println("A senha não pode estar em branco, tente novamente.\n");
                        }
                    } while (controle != true);
                } else {
                    System.out.println("Já existe um usuário cadastrado com esse CPF ou Email!\n");
                }
            } else {
                System.out.println("Formato do email inválido, tente novamente.\n");
                teclado.nextLine();
            }
        } else {
            System.out.println("Formato do CPF inválido, tente novamente.\n");
            teclado.nextLine();
        }
    }

    /**
     * @param email
     * @return
     */

    public boolean VerificaEmail(String email) {
        for (int indiceAlunos = 0; indiceAlunos < contadorAluno; indiceAlunos++) {
            if (verificaVariaveis(getAluno(indiceAlunos).getEmail(), email) == true) {
                return false;
            }
        }
        return true;
    }

    //Gera o menu que o aluno vê 
    /**
     * @param idAluno
     */

    public void MenuAluno(int idAluno) 
    {
        int escolha = 0; 

        do{
            try
            {
                Menu.limpaTela();
                System.out.println();
                System.out.println("===========================\nSISTEMA DE GESTÃO DE CURSOS\n===========================\n");
                System.out.println("MENU DO ALUNO\n");
                System.out.println("Bem vindo: " + " " + getAluno(idAluno).getNome() + "\n");
                System.out.println("    1 - Consultar seus Dados.");
                System.out.println("    2 - Consultar Cursos disponíveis.");
                System.out.println("    3 - Se matricular em Cursos disponíveis.");
                System.out.println("    4 - Consultar os cursos que você está matriculado.");
                System.out.println("    5 - Cancelar matricula em um curso.");
                System.out.println("    6 - Obter o certificado de conclusão de um curso");
                System.out.println("    7 - Sair.");
                System.out.print("\nSelecione uma opção: ");

                escolha = Integer.parseInt(teclado.nextLine());

                switch(escolha) 
                {
                    case 1:
                        Menu.limpaTela();
                        dadosAluno(idAluno);
                        System.out.print("\nPressione ENTER para continuar...");
                        teclado.nextLine();
                        break;
                    case 2:
                        Menu.limpaTela();
                        cursosDisponiveisAluno(idAluno);
                        System.out.print("\nPressione ENTER para continuar...");
                        teclado.nextLine();
                        break;
                    case 3:
                        Menu.limpaTela();
                        MatricularCurso(idAluno);
                        break;
                    case 4:
                        Menu.limpaTela();
                        CursosMatriculadosAluno(idAluno);
                        break;
                    case 5:
                        Menu.limpaTela();
                        CancelarMatriculaCurso(idAluno);
                        break;
                    case 6:
                        Menu.limpaTela();
                        break;
                    case 7:
                        Menu.limpaTela();
                        return;
                    default:
                        System.out.print("\nOpção inválida, tente novamente.");
                        teclado.nextLine();
                        break;
                }
            } catch(NumberFormatException numberFormatException)
            {
                System.out.print("\nEntrada inválida, tente novamente.");
                teclado.nextLine();
            }
        } while(escolha != 7);
    }

    //gera os dados do aluno 
    /**
     * @param idAluno
     */
    
    public void dadosAluno(int idAluno) 
    {
        System.out.println("Nome: " + getAluno(idAluno).getNome());
        System.out.println("Codigo do Usuário: " + getAluno(idAluno).getCodigoUsuario());
        System.out.println("Email: " + getAluno(idAluno).getEmail());
        System.out.println("CPF: " + getAluno(idAluno).getCPF());
    }

    public void mostrarDadosAlunos() 
    {
        for (int i = 0; i < contadorAluno; i++) {
            System.out.println("Nome: " + alunos[i].getNome());
            System.out.println("Código do Usuário: " + alunos[i].getCodigoUsuario());
            System.out.println("Email: " + alunos[i].getEmail());
            System.out.println("CPF: " + alunos[i].getCPF());
            System.out.println();
        }
    }

    //gera os cursos que estão disponíveis para a matrícula 
    /**
     * @param idAluno
     */
    public void cursosDisponiveisAluno(int idAluno) 
    {
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if (getCurso(indiceCursos).getStatus() == true && VerificaQuantidadeAlunosMatriculados(indiceCursos) == true && VerificaAlunoMatriculado(idAluno, indiceCursos) == false) 
            {
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

    //Metodo que imprime todos os cursos que um aluno está matriculado
    /**
     * @param idAluno
     */

    public void CursosMatriculadosAluno(int idAluno) 
    {
        System.out.println("Cursos que você está matriculado: ");
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {   
            if (getCurso(indiceCursos).getStatus() == true && VerificaAlunoMatriculado(idAluno, indiceCursos) == true) 
            {
                System.out.println();
                System.out.println("Nome do curso: " + getCurso(indiceCursos).getNomeCurso());
                System.out.println("Código do curso: " + getCurso(indiceCursos).getCodigoCurso());
                System.out.println("Carga iHorária do curso: " + getCurso(indiceCursos).getCargaHorariaCurso() + " Horas");
                System.out.println("Ementa do curso: " + getCurso(indiceCursos).getEmenta());
                System.out.println("Data Inicial do curso: " + getCurso(indiceCursos).getDateInicio());
                System.out.println("Data Final do curso: " + getCurso(indiceCursos).getDateFim());
                System.out.println("Professor do curso: " + getCurso(indiceCursos).getProfessor().getNome());
                System.out.println("Horários e dias do curso: " + getCurso(indiceCursos).getHorario());
                System.out.println("Quantidade de alunos matrículados: " + getCurso(indiceCursos).getQuantidadeAtualAlunos());
                //System.out.println("Sua nota é: " + getCurso(indiceCursos).getNota(indiceCursos));
                System.out.println();
            }
        }
    }

    /**
     * @param codigo
     * @return
     */
    
    public Aluno buscaAlunoPorCodigo(int codigo) 
    {
    
        for (int i = 0; i < contadorAluno; i++) {
            if (alunos[i].getCodigoUsuario() == codigo) {
                return alunos[i];
            }
        }
        return null;
    }

    public void mostrarCursosEProfessores() 
    {
        for (int i = 0; i < contadorCurso; i++) {
            Curso curso = cursos[i];
            System.out.println("Curso: " + curso.getNomeCurso());
            System.out.println("Código: " + curso.getCodigoCurso());
            System.out.println("Professor: " + curso.getProfessor().getNome());
            System.out.println("Quantidade de alunos matriculados: " + curso.getQuantidadeAtualAlunos());
            System.out.println();
        }
    }

    //Método para o aluno se matricular em um curso disponível
    /**
     * @param idAluno
     */

    public void MatricularCurso(int idAluno) 
    {
        String codigo;

        CursosDisponiveisAluno(idAluno); //imprime os cursos disponíveis 
        System.out.print("Digite o código do curso: ");
        codigo = teclado.nextLine();

        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(verificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
            {
                if(VerificaAlunoMatriculado(idAluno, indiceCursos) == false)
                {
                    if(getCurso(indiceCursos).getStatus() == true && VerificaQuantidadeAlunosMatriculados(indiceCursos) == true) 
                    {
                        getCurso(indiceCursos).setAlunosMatriculados(getAluno(idAluno));
                        GeraArquivo.salvarMatricula(getCurso(indiceCursos), getAluno(idAluno), "Nulo");
                        Menu.limpaTela();
                        System.out.println();
                        System.out.println("Matricula feita com sucesso!");
                        System.out.println();
                        break;
                    } else 
                    {
                        Menu.limpaTela();
                        System.out.println();
                        System.out.println("Esse curso está lotado ou não está disponível, não foi possível se matrícular!");
                        System.out.println();
                        break;
                    }
                } else 
                {
                    Menu.limpaTela();
                    System.out.println();
                    System.out.println("ERRO! Você já está matriculado nesse curso! Não é possível se matrícular novamente");
                    System.out.println();
                }
            } 
        }
    }
    
    //Método para que o aluno cancele a matrícula em um curso
    /**
     * @param idAluno
     */

    public void CancelarMatriculaCurso(int idAluno) {
        String codigo;

        System.out.print("Digite o código do curso que deseja cancelar a matrícula: ");
        codigo = teclado.nextLine();

        for (int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) {
            if (verificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) {
                if (VerificaAlunoMatriculado(idAluno, indiceCursos) == true) {
                    getCurso(indiceCursos).removerAlunoMatriculado(getAluno(idAluno));
                    atualizarArquivoMatriculas(getCurso(indiceCursos), getAluno(idAluno));
                    Menu.limpaTela();
                    System.out.println();
                    System.out.println("Matrícula cancelada com sucesso!");
                    System.out.println();
                    break;
                } else {
                    Menu.limpaTela();
                    System.out.println();
                    System.out.println("ERRO! Você não está matriculado nesse curso!");
                    System.out.println();
                }
            }
        }
    }
    public void cancelarMatriculaCursoPorArquivo(int idAluno) {
        String codigoCurso;
        System.out.print("Digite o código do curso que deseja cancelar a matrícula: ");
        codigoCurso = teclado.nextLine();

        try (BufferedReader brMatriculas = new BufferedReader(new FileReader("Projeto/matriculas.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("Projeto/matriculas_temp.csv"))) {

            String linhaMatricula;
            boolean matriculaEncontrada = false;

            while ((linhaMatricula = brMatriculas.readLine()) != null) {
                String[] dadosMatricula = linhaMatricula.split(",");
                String codigoCursoArquivo = dadosMatricula[0];
                int codigoAlunoArquivo = Integer.parseInt(dadosMatricula[1]);

                if (codigoCursoArquivo.equals(codigoCurso) && codigoAlunoArquivo == getAluno(idAluno).getCodigoUsuario()) {
                    matriculaEncontrada = true;
                } else {
                    bw.write(linhaMatricula);
                    bw.newLine();
                }
            }

            if (matriculaEncontrada) {
                System.out.println("Matrícula cancelada com sucesso!");
            } else {
                System.out.println("Matrícula não encontrada!");
            }

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo de matrículas: " + e.getMessage());
        }

        new File("Projeto/matriculas.csv").delete();
        new File("Projeto/matriculas_temp.csv").renameTo(new File("Projeto/matriculas.csv"));
    }

    private void atualizarArquivoMatriculas(Curso curso, Aluno aluno) {
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader("Projeto/matriculas.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("Projeto/matriculas_temp.csv"))) {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (!(dados[0].equals(curso.getCodigoCurso()) && dados[1].equals(String.valueOf(aluno.getCodigoUsuario())))) {
                    bw.write(linha);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao atualizar matrículas no arquivo matriculas.csv: " + e.getMessage());
        }
        new File("Projeto/matriculas.csv").delete();
        new File("Projeto/matriculas_temp.csv").renameTo(new File("Projeto/matriculas.csv"));
    }
    
    //Método que retorna true se um curso não estiver lotado e false se estiver
    /**
     * @param indiceCurso
     * @return
     */
    public boolean VerificaQuantidadeAlunosMatriculados(int indiceCurso) 
    {
        if(getCurso(indiceCurso).getQuantidadeAtualAlunos() <= getCurso(indiceCurso).getQuantidadeMaximaAlunos()) 
        {
            return true; 
        }
        return false; 
    }

    // Método que retorna a quantidade de alunos matriculados em um curso
    /**
     * @param indiceCurso
     * @return
     */

    public int getQuantidadeAlunosMatriculados(int indiceCurso) 
    {
        return getCurso(indiceCurso).getQuantidadeAtualAlunos();
    }

    //Método que verifica o CPF do aluno para não repetir
    /**
     * @param cpf
     * @return
     */

    public boolean VerificaCPF(String cpf) 
    {
        for(int indiceAlunos = 0; indiceAlunos < contadorAluno; indiceAlunos++) 
        {
            if(verificaVariaveis(getAluno(indiceAlunos).getCPF(), cpf) == true) 
            {
                return false;
            } 
        }
        return true; 
    }

    //Métodoque verifica se um aluno está matriculado no curso
    /**
     * @param idAluno
     * @param indiceCurso
     * @return
     */
    public boolean VerificaAlunoMatriculado(int idAluno, int indiceCurso) 
    {
        for(int indiceAlunos = 0; indiceAlunos < getCurso(indiceCurso).getQuantidadeAtualAlunos(); indiceAlunos++)
        {
            if(getCurso(indiceCurso).getAlunosMatriculados(indiceAlunos) == getAluno(idAluno))
            {
                return true; 
            }
        }
        return false;
    }

    /**
     * @param idAluno
     */
    public void GeraCertificadoAluno(int idAluno) 
    {
        String codigo;
       
        System.out.print("Digite o Código do curso: ");
        codigo = teclado.nextLine();
        System.out.println();
        Curso cursoProcurado = buscaCurso(codigo);
        if(cursoProcurado == null) 
        {
            System.out.println("Curso não Encontrado! Tente Novamente.");
            return;
        }
        if(cursoProcurado.getNota(idAluno) >= 5.0) 
        {
            System.out.println("Certificamos que o aluno: " + getAluno(idAluno).getNome());
            System.out.println("Concluiu o curso: " + cursoProcurado.getNomeCurso());
            System.out.println("E obteve nota: " + cursoProcurado.getNota(idAluno));
            System.out.println();
        } else {
            System.out.println("O aluno não atingiu a nota mínima para obter o certificado.");
        }
    }
   
    

    //AQUI COMEÇA TUDO O QUE ENVOLVE O ADMINISTRADOR!!!!
    /**
     * @param i
     */
    public void MenuAdministrador(int i) 
    {
        int escolha = 0;

        do {
            try
            {
                Menu.limpaTela();
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
                        FormulariocadastrarCurso();
                        break;
                    case 2:
                        Menu.limpaTela();
                        DadosCursoAdministrativo();
                        System.out.print("\nPressione ENTER para continuar...");
                        teclado.nextLine();
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
                        teclado.nextLine();
                        break;
                }
            } catch(NumberFormatException numberFormatException){
                System.out.print("\nEntrada inválida, tente novamente.");
                teclado.nextLine();
            }
        } while(escolha != 8);
    }

    /**
     * @param email
     * @return
     */
    public boolean VerificaEmailAdministrador(String email) 
    {
        carregarAdministradores();
        for (int indiceAdministradores = 0; indiceAdministradores < contadorAdministrador; indiceAdministradores++) {
            if (verificaVariaveis(getAdministrador(indiceAdministradores).getEmail(), email)) {
                return false;
            }
        }
        return true;
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
        if (email.matches("(.*)@(.*).(.*)") && !email.substring(0, email.indexOf("@")).isEmpty() && !email.substring(email.indexOf("@") + 1, email.indexOf(".")).isEmpty() && !email.substring(email.indexOf(".") + 1).isEmpty()) {
            if (VerificaEmailAdministrador(email)) {
                do {
                    System.out.print("Senha: ");
                    senha = teclado.nextLine();
                    if (!senha.isEmpty()) {
                        System.out.print("Confirme a senha: ");
                        confirmaSenha = teclado.nextLine();
                        boolean verifica = verificaVariaveis(senha, confirmaSenha);
                        if (verifica) {
                            controle = true;
                            CadastrarAdministrador(nome, email, confirmaSenha);
                        } else {
                            System.out.println("A senha não é igual! Tente Novamente!");
                            System.out.println();
                        }
                    } else {
                        System.out.println("A senha não pode estar em branco, tente novamente.");
                    }
                } while (!controle);
            } else {
                System.out.println("Já existe um administrador cadastrado com esse Email!");
            }
        } else {
            System.out.println("Formato do email inválido, tente novamente.");
            teclado.nextLine();
        }
    }

    /**
     * @param nome
     * @param email
     * @param senha
     */
    public void CadastrarAdministrador(String nome, String email, String senha) 
    {
        int codigoUsuario; 

        codigoUsuario = GerarCodigoUsuario();
        Administrador administrador = new Administrador(nome, codigoUsuario, email, senha, "administrador");
        setAdministrador(administrador);
        GeraArquivo.salvarAdministrador(administrador);
        System.out.println("Conta Criada com Sucesso!");
    }

    /**
     * @param email
     * @return
     */
    public boolean VerificaEmailExistente(String email) 
    {

        for (int i = 0; i < contadorAdministrador; i++) {
            if (administradores[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param nome
     * @param email
     * @param senha
     */
    public void CadastrarProfessor(String nome, String email, String senha) 
    {

        int codigoUsuario = 0; 

        codigoUsuario = GerarCodigoUsuario();
        Professor professor = new Professor(nome, codigoUsuario, email, senha, "professor");
        setProfessoresSistema(professor);
        GeraArquivo.salvarProfessor(professor);
        System.out.println("Conta Criada com Sucesso!");
    }

    /**
     * @param email
     * @return
     */
    public boolean VerificaEmailProfessor(String email) 
    {
        for (int indiceProfessores = 0; indiceProfessores < contadorProfessor; indiceProfessores++) {
            if (verificaVariaveis(getProfessoresSistema(indiceProfessores).getEmail(), email)) {
                return false;
            }
        }
        return true;
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
        if (email.matches("(.*)@(.*).(.*)") && !email.substring(0, email.indexOf("@")).isEmpty() && !email.substring(email.indexOf("@") + 1, email.indexOf(".")).isEmpty() && !email.substring(email.indexOf(".") + 1).isEmpty()) {
            if (VerificaEmailProfessor(email)) {
                do {
                    System.out.print("Senha: ");
                    senha = teclado.nextLine();
                    if (!senha.isEmpty()) {
                        System.out.print("Confirme a senha: ");
                        confirmaSenha = teclado.nextLine();
                        boolean verifica = verificaVariaveis(senha, confirmaSenha);
                        if (verifica) {
                            controle = true;
                            CadastrarProfessor(nome, email, confirmaSenha);
                        } else {
                            System.out.println("As senhas não são iguais! Tente Novamente!");
                            System.out.println();
                        }
                    } else {
                        System.out.println("A senha não pode estar em branco, tente novamente.");
                    }
                } while (!controle);
            } else {
                System.out.println("Já existe um professor cadastrado com esse Email!");
            }
        } else {
            System.out.println("Formato do email inválido, tente novamente.");
            teclado.nextLine();
        }
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

        // Formulario de cadastro de curso
        do{
            try{
                Menu.limpaTela();
                if(getProfessoresSistema(0) != null) 
                {
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
                    System.out.print("Digite o número correspondente ao professor que deseja escolher: ");
                    escolhaProfessor = teclado.nextInt();
                    teclado.nextLine();
                    CadastrarCurso(nome, codigo, cargaHoraria, ementa, dateInicio, dateFim, horario, getProfessoresSistema(escolhaProfessor), escolhaProfessor, escolhaProfessor, true);
                    break;
                } else {
                    System.out.println("Não há professores cadastrados!");
                    teclado.nextLine();
                }
            } catch(InputMismatchException inputMismatchException)
            {
                System.out.print("\nEntrada inválida, tente novamente.\n");
                teclado.nextLine();
                teclado.nextLine();
            } catch(NullPointerException nullPointerException){
                System.out.print("\nProfessor não encontrado, tente novamente.\n");
                teclado.nextLine();
            }
        } while(true);
    }

    /**
     * @param nome
     * @param codigo
     * @param cargaHoraria
     * @param ementa
     * @param dateInicio
     * @param dateFim
     * @param horario
     * @param professor
     * @param idProfessor
     */
    public void CadastrarCurso(String nome, String codigo,int cargaHoraria, String ementa, String dateInicio, String dateFim, String horario, Professor professor, int idProfessor, int quantidadeMaximaAlunos, boolean status) 
    {
        if(verificaCargaProfessor(idProfessor,cargaHoraria) == true) 
        {
            Curso curso = new Curso(nome, codigo, cargaHoraria, ementa, dateInicio, dateFim, horario, professor, alunos, quantidadeMaximaAlunos, status, null, quantidadeMaximaAlunos, quantidadeMaximaAlunos);
            setCurso(curso);
            AdicionaCargaHorariaProfessor(contadorCurso - 1);
            GeraArquivo.salvarCurso(curso);
            System.out.println("Curso Criado com Sucesso!");
            teclado.nextLine();
        } else {
            System.out.println("Esse professor não pode mais receber disciplinas!");
        }
    }
    
    public void DadosCursoAdministrativo() 
    {
        for(int indiceCurso = 0; indiceCurso < contadorCurso; indiceCurso++) 
        {
            System.out.println("Nome: " + getCurso(indiceCurso).getNomeCurso());
            System.out.println("Código Curso: " + getCurso(indiceCurso).getCodigoCurso());
            System.out.println("Carga Horária: " + getCurso(indiceCurso).getCargaHorariaCurso());
            System.out.println("Ementa: " + getCurso(indiceCurso).getEmenta());
            System.out.println("Data Inicio: " + getCurso(indiceCurso).getDateInicio());
            System.out.println("Data Fim: " + getCurso(indiceCurso).getDateFim());
            System.out.println("Quantidade de Alunos Matriculados: " + getCurso(indiceCurso).getQuantidadeAtualAlunos());
            System.out.println("Horários: : " + getCurso(indiceCurso).getHorario());
            System.out.println("Professor do curso: " + getCurso(indiceCurso).getProfessor().getNome());
            if(getCurso(indiceCurso).getStatus() == true) 
            {
                System.out.println("Status do Curso: Ativo\n");
            } else {
                System.out.println("Status do Curso: Desativado\n");
            }
        }
    }

    public void HabilitarCurso() 
    {
        String codigo; 

        DadosCursoAdministrativo();
        System.out.println("Digite o Código do curso: ");
        codigo = teclado.nextLine(); 
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(verificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
            {
                if(getCurso(indiceCursos).getStatus() == false) 
                {
                    getCurso(indiceCursos).setStatus(true);
                    AdicionaCargaHorariaProfessor(indiceCursos);
                    editarCursoNoArquivo(getCurso(indiceCursos));
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
            if(verificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
            {
                if(getCurso(indiceCursos).getStatus() == true) 
                {
                    getCurso(indiceCursos).setStatus(false);
                    RetiraCargaHorariaProfessor(indiceCursos);
                    editarCursoNoArquivo(getCurso(indiceCursos));
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
        System.out.print("\nDigite o Código do curso: ");
        codigo = teclado.nextLine(); 
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(verificaVariaveis(getCurso(indiceCursos).getCodigoCurso(), codigo) == true) 
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
                        break;
                    case 2:
                        System.out.println("Digite o novo Código do curso: ");
                        String novoCodigo = teclado.nextLine();
                        getCurso(indiceCursos).setCodigoCurso(novoCodigo);
                        System.out.println("Modificado com sucesso!");
                        break;
                    case 3:
                        System.out.println("Digite a nova Carga Horária do curso: ");
                        int novaCargaHoraria = teclado.nextInt();
                        teclado.nextLine();
                        getCurso(indiceCursos).setCargaHorariaCurso(novaCargaHoraria);
                        System.out.println("Modificado com sucesso!");
                        break;
                    case 4:
                        System.out.println("Digite a nova Ementa do curso: ");
                        String novaEmenta = teclado.nextLine();
                        getCurso(indiceCursos).setEmenta(novaEmenta);
                        System.out.println("Modificado com sucesso!");
                        break;
                    case 5:
                        System.out.println("Digite a nova Data de Inicio do curso: ");
                        String novaDataInicio = teclado.nextLine();
                        getCurso(indiceCursos).setDateInicio(novaDataInicio);
                        System.out.println("Modificado com sucesso!");
                        break;
                    case 6:
                        System.out.println("Digite a nova Data de finalização do curso: ");
                        String novaDataFim = teclado.nextLine();
                        getCurso(indiceCursos).setDateFim(novaDataFim);
                        System.out.println("Modificado com sucesso!");
                        break;
                    case 7:
                        System.out.println("Digite os novos Horários do curso: ");
                        String novosHorarios = teclado.nextLine();
                        getCurso(indiceCursos).setHorario(novosHorarios);
                        System.out.println("Modificado com sucesso!");
                        break;
                    case 8:
                        System.out.println("Escolha um professor:");
                        System.out.println("Indice do Professor: " + "  " + "Nome: " );  
                        for(int indiceProfessor = 0; indiceProfessor < contadorProfessor; indiceProfessor++) 
                        {
                            if(getProfessoresSistema(indiceProfessor).getCargaHorariaAtual() != getProfessoresSistema(indiceProfessor).getCargaHorariaMaxima()) 
                            {
                                System.out.println(indiceProfessor + " " + getProfessoresSistema(indiceProfessor).getNome());
                            }
                        }
                        System.out.print("Digite o número correspondente ao professor que deseja escolher: "); 
                        int escolhaProfessor = teclado.nextInt();
                        teclado.nextLine();
                        getCurso(indiceCursos).setProfessor(getProfessoresSistema(escolhaProfessor));
                        AdicionaCargaHorariaProfessor(indiceCursos);
                        RetiraCargaHorariaProfessor(indiceCursos);
                        break;
                    default:
                        break;
                }
                editarCursoNoArquivo(getCurso(indiceCursos));
            }
        }
    }

    //AQUI COMEÇA TUDO O QUE ENVOLVE O PROFESSOR!!!!
    //Menu que o professor pode ver depois do login
    /**
     * @param idProfessor
     */
    public void MenuProfessor(int idProfessor) 
    {
        int escolha = 0; 
        
        do 
        {
            try
            {
                Menu.limpaTela();
                System.out.println();
                System.out.println("===========================\nSISTEMA DE GESTÃO DE CURSOS\n===========================\n");
                System.out.print("MENU DO PROFESSOR\n");
                System.out.println("Bem vindo: " + " " + getProfessoresSistema(idProfessor).getNome() + "\n");
                System.out.println("    1 - Consultar seus Dados.");
                System.out.println("    2 - Consultar os Cursos em que você é o responsável.");
                System.out.println("    3 - Ver as notas dos alunos de um curso."); 
                System.out.println("    4 - Adicionar notas de alunos de um curso."); 
                System.out.println("    5 - Sair.");
                System.out.print("\nSelecione uma opção: ");
                escolha = Integer.parseInt(teclado.nextLine());
                switch(escolha) {
                    case 1:
                        Menu.limpaTela();
                        MostrarDadosProfessores(idProfessor);
                        System.out.println("Pressione ENTER para continuar...");
                        teclado.nextLine();
                        break;
                    case 2:
                        Menu.limpaTela();
                        CursosProfessor(idProfessor);
                        System.out.println("Pressione ENTER para continuar...");
                        teclado.nextLine();
                        break;
                    case 3:
                        Menu.limpaTela();
                        VerNotasAlunos(idProfessor);
                        break;
                    case 4:
                        Menu.limpaTela();
                        AdicionarNotas(idProfessor);
                        break;
                    case 5:
                        Menu.limpaTela();
                        return;
                    default:
                        System.out.print("\nOpção inválida, tente novamente.");
                        teclado.nextLine();
                        break;
                }
            } catch(NumberFormatException numberFormatException)
            {
                System.out.print("\nEntrada inválida, tente novamente.");
               teclado.nextLine();
            }
        } while(escolha != 5);
    }

    //metodo que imprime os dados do professor
    
    /**
     * @param idProfessor
     */

    public void MostrarDadosProfessores(int idProfessor)
    {
        for (int i = 0; i < contadorProfessor; i++) 
        {
            System.out.println("Nome: " + professoresSistema[i].getNome());
            System.out.println("Código do Usuário: " + professoresSistema[i].getCodigoUsuario());
            System.out.println("Email: " + professoresSistema[i].getEmail());
            System.out.println("Carga Horária Atual: " + professoresSistema[i].getCargaHorariaAtual());
            System.out.println();
        }
    }

    //método que verifica se o professor pode receber a carga horaria
    
    /**
     * @param idProfessor
     * @param cargaHoraria
     * @return
     */

    public boolean verificaCargaProfessor(int idProfessor, int cargaHoraria) 
    {
        if(getProfessoresSistema(idProfessor).getCargaHorariaAtual() + cargaHoraria <= getProfessoresSistema(idProfessor).getCargaHorariaMaxima()) 
        {
            return true; 
        } else {
            return false; 
        }
    }

    // Adiciona a carga horaria do professor
   
    /**
     * @param idCurso
     */

    public void AdicionaCargaHorariaProfessor(int idCurso) 
    {
        Professor professor = getCurso(idCurso).getProfessor();
        professor.setCargaHorariaAtual(professor.getCargaHorariaAtual() + getCurso(idCurso).getCargaHorariaCurso());
        editarProfessorNoArquivo(professor);
    }

    // retira a carga horaria do professor
   
    /**
     * @param idCurso
     */

    public void RetiraCargaHorariaProfessor(int idCurso) 
    {
        Professor professor = getCurso(idCurso).getProfessor();
        professor.setCargaHorariaAtual(professor.getCargaHorariaAtual() - getCurso(idCurso).getCargaHorariaCurso());
        editarProfessorNoArquivo(professor);
    }

    //Lista todos os cursos onde um professor aparece como responsável
    /**
     * @param idProfessor
     */

    public void CursosProfessor(int idProfessor) 
    {
        for(int indiceCursos = 0; indiceCursos < contadorCurso; indiceCursos++) 
        {
            if(VerificaProfessorResponsavel(idProfessor, getCurso(indiceCursos)) == true) 
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

    //imprimia as notas de cada aluno de um curso 
    /**
     * @param idProfessor
     */

    public void VerNotasAlunos(int idProfessor) 
    {
        String codigo;

        CursosProfessor(idProfessor);
        System.out.print("Digite o Código do curso: ");
        codigo = teclado.nextLine();
        System.out.println();
        Curso cursoProcurado = buscaCurso(codigo);
        if(cursoProcurado == null) 
        {
            System.out.println("Curso não Encontrado! Tente Novamente.");
            return;
        }
        if(cursoProcurado.getQuantidadeAtualAlunos() == 0) 
        {
            System.out.println("Não há alunos matriculados nesse curso!");
            return;
        }
        if(VerificaProfessorResponsavel(idProfessor, cursoProcurado) == false) 
        {
            System.out.println("Você não é o professor responsável por essa turma!");
            return;
        }
        for(int indiceAlunos = 0; indiceAlunos < cursoProcurado.getQuantidadeAtualAlunos(); indiceAlunos++) 
        {
            System.out.println();
            System.out.println("Nome: " + cursoProcurado.getAlunosMatriculados(indiceAlunos).getNome());
            System.out.println("Código Usuário: " + cursoProcurado.getAlunosMatriculados(indiceAlunos).getCodigoUsuario());
            System.out.println("A nota do aluno acima é: " + " " + cursoProcurado.getNota(indiceAlunos));
            System.out.println();
        }
    }  

    //premite que um professor adicione a nota dos alunos de um curso
   
    /**
     * @param idProfessor
     */

    public void AdicionarNotas(int idProfessor) 
    {
        String codigo;
        double nota; 

        CursosProfessor(idProfessor);
        System.out.print("Digite o Código do curso: ");
        codigo = teclado.nextLine();
        System.out.println();
        Curso cursoProcurado = buscaCurso(codigo);
        if(cursoProcurado == null) 
        {
            System.out.println("Curso não Encontrado! Tente Novamente.");
            return;
        }
        if(cursoProcurado.getQuantidadeAtualAlunos() == 0) 
        {
            System.out.println("Não há alunos matriculados nesse curso!");
            return;
        }
        if(VerificaProfessorResponsavel(idProfessor, cursoProcurado) == false) 
        {
            System.out.println("Você não é o professor responsável por essa turma!");
            return;
        }
        for(int indiceAlunos = 0; indiceAlunos < cursoProcurado.getQuantidadeAtualAlunos(); indiceAlunos++) 
        {
            System.out.println();
            System.out.println("Nome: " + cursoProcurado.getAlunosMatriculados(indiceAlunos).getNome());
            System.out.println("Código Usuário: " + cursoProcurado.getAlunosMatriculados(indiceAlunos).getCodigoUsuario());
            System.out.print("Digite a nota do Aluno acima: ");
            nota = teclado.nextDouble();
            cursoProcurado.getNota((int) nota);
            System.out.println();
            System.out.println("A nota do aluno acima é: " + " " + cursoProcurado.getNota(indiceAlunos));
            System.out.println();
        }
    }  

    //Verifica se o professor é o responsável pela turma
    
    /**
     * @param idProfessor
     * @param cursoProcurado
     * @return
     */

    public boolean VerificaProfessorResponsavel(int idProfessor, Curso cursoProcurado)
    {
        if(cursoProcurado.getProfessor() == getProfessoresSistema(idProfessor))
        {
            return true;
        }
        return false;
    }
}