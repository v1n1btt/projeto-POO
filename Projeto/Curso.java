package Projeto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Curso 
{
    private String nomeCurso;
    private String codigoCurso;
    private int cargaHorariaCurso;
    private String ementa;
    private String dateInicio; 
    private String dateFim; 
    private String horario;
    private Professor professor; 
    private int quantidadeAtualAlunos;
    private boolean status;
    private Aluno[] alunosMatriculados;
    private double[] notas;
    private final int quantidadeMaximaAlunos = 40;
   
    
    private static int indiceNotas = 0;


    /**
     * @param nomeCurso
     * @param codigoCurso
     * @param cargaHorariaCurso
     * @param ementa
     * @param dateInicio
     * @param dateFim
     * @param horario
     * @param professor
     * @param indiceNotas2 
     * @param quantidadeMaximaAlunos2 
     * @param notas2 
     * @param status2 
     * @param capacidade 
     * @param alunos 
     */

    public Curso(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String dateInicio, String dateFim, String horario, Professor professor, Aluno[] alunos, int capacidade, boolean status2, double[] notas2, int quantidadeMaximaAlunos2, int indiceNotas2) 
    {
        this.nomeCurso = nomeCurso;
        this.codigoCurso = codigoCurso; 
        this.cargaHorariaCurso = cargaHorariaCurso; 
        this.ementa = ementa; 
        this.dateInicio = dateInicio; 
        this.dateFim = dateFim; 
        this.horario = horario; 
        this.professor = professor;
        this.status = true;
        this.quantidadeAtualAlunos = 0; 
        alunosMatriculados = new Aluno[getQuantidadeMaximaAlunos()];
        notas = new double[getQuantidadeMaximaAlunos()];
    }

    /**
     * @param nomeCurso
     */

    public void setNomeCurso(String nomeCurso) 
    {
        this.nomeCurso = nomeCurso;
    }

    /**
     * @return
     */
    
    public String getNomeCurso() 
    {
        return nomeCurso;
    }

    /**
     * @param codigoCurso
     */

    public void setCodigoCurso(String codigoCurso) 
    {
        this.codigoCurso = codigoCurso;
    }

    /**
     * @return
     */

    public String getCodigoCurso() 
    {
        return codigoCurso;
    }

    /**
     * @param cargaHorariaCurso
     */
    
    public void setCargaHorariaCurso(int cargaHorariaCurso) 
    {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    /**
     * @return
     */

    public int getCargaHorariaCurso() 
    {
        return cargaHorariaCurso;
    }

    /**
     * @param ementa
     */

    public void setEmenta(String ementa) 
    {
        this.ementa = ementa;
    }

    /**
     * @return
     */
    
    public String getEmenta() 
    {
        return ementa;
    }

    /**
     * @param dateInicio
     */

    public void setDateInicio(String dateInicio) 
    {
        this.dateInicio = dateInicio;
    }

    /**
     * @return
     */

    public String getDateInicio() 
    {
        return dateInicio;
    } 

    /**
     * @param dateFim
     */

    public void setDateFim(String dateFim) 
    {
        this.dateFim = dateFim;
    }

    /**
     * @return
     */
    public String getDateFim() 
    {
        return dateFim;
    }

    /**
     * @param horario
     */
    public void setHorario(String horario) 
    {
        this.horario = horario;
    }

    /**
     * @return
     */
    public String getHorario() 
    {
        return horario;
    }

    /**
     * @param professor
     */
    public void setProfessor(Professor professor) 
    {
        this.professor = professor;
    }

    /**
     * @return
     */
    public Professor getProfessor() 
    {
        return professor;
    }

    /**
     * @param status
     */
    public void setStatus(boolean status) 
    {
        this.status = status;
    }

    /**
     * @return
     */
    public boolean getStatus() 
    {
        return status;
    }

    /**
     * @param quantidadeAtualAlunos
     */
    public void setQuantidadeAtualAlunos(int quantidadeAtualAlunos) 
    {
        this.quantidadeAtualAlunos = quantidadeAtualAlunos;
    }

    /**
     * @return
     */
    public int getQuantidadeAtualAlunos() 
    {
        return quantidadeAtualAlunos;
    }

    /**
     * @param aluno
     */
    public void setAlunosMatriculados(Aluno aluno) 
    {
        this.alunosMatriculados[quantidadeAtualAlunos] = aluno;
        setQuantidadeAtualAlunos(getQuantidadeAtualAlunos() + 1);
    }

    /**
     * @param indiceAluno
     * @return
     */
    public Aluno getAlunosMatriculados(int indiceAluno) 
    {
        return alunosMatriculados[indiceAluno];
    }

    /**
     * @param aluno
     * @param nota
     */
    public void setNota(Aluno aluno, double nota)
     {
        if(nota < 0.0) {
            throw new IllegalArgumentException("A nota não pode ser menor que zero!");
        } else {
            this.notas[indiceNotas] = nota;
            indiceNotas++; 
        }
    }

    /**
     * @param indiceNotas
     * @return
     */
    public double getNota(int indiceNotas) 
    {
        return notas[indiceNotas];
    }

    /**
     * @return
     */
    public int getQuantidadeMaximaAlunos() 
    {
        return quantidadeMaximaAlunos;
    }

    public void removerAlunoMatriculado(Aluno aluno) {
        throw new UnsupportedOperationException("Unimplemented method 'removerAlunoMatriculado'");
    }

    public void removerAlunoMatriculado(int codigoAluno) {
        // Implementação do método para remover a matrícula do aluno
        try {
            List<String> linhas = Files.readAllLines(Paths.get("matriculas.csv"));
            List<String> novasLinhas = new ArrayList<>();

            for (String linha : linhas) {
                String[] dados = linha.split(",");
                if (!dados[1].equals(String.valueOf(codigoAluno))) {
                    novasLinhas.add(linha);
                }
            }

            Files.write(Paths.get("matriculas.csv"), novasLinhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}