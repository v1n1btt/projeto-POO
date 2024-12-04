package Projeto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     */

    public Curso(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String dateInicio, String dateFim, String horario, Professor professor) 
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

    /**
     * @return
     */
    public String salvaAluno() 
    {
        try 
        {
            FileWriter fw = new FileWriter("Curso.txt");
            PrintWriter pw = new PrintWriter("fw");
            pw.println("Nome do curso: "+this.nomeCurso);
            pw.println("Codigo do curso: "+this.codigoCurso);
            pw.println("Status: "+this.status);
            pw.println("Quantidade máxima de alunos: "+this.quantidadeMaximaAlunos);
            pw.println("Finalização do curso: "+this.dateFim);
            pw.println("Início do Curso: "+this.dateInicio);
            pw.println("Carga horária: "+this.cargaHorariaCurso);
            pw.flush();
            pw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param aluno
     */
    public void removerAlunoMatriculado(Aluno aluno) {
        throw new UnsupportedOperationException("Unimplemented method 'removerAlunoMatriculado'");
    }
}