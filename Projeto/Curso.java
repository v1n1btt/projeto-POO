package Projeto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Curso {

    private String nomeCurso;
    private String codigoCurso;
    private int cargaHorariaCurso;
    private String ementa;
    private String dateInicio; 
    private String dateFim; 
    private String horario;
    protected Professor professor; 
    private int quantidadeAtualAlunos;
    private final int quantidadeMaximaAlunos = 40;
    private boolean status;
    private Aluno[] alunosMatriculados;


    public Curso(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String dateInicio, String dateFim, String horario, Professor professor) {
        setNomeCurso(nomeCurso);
        setCodigoCurso(codigoCurso);
        setCargaHorariaCurso(cargaHorariaCurso);
        setEmenta(ementa);
        setDateInicio(dateInicio);
        setDateFim(dateFim);
        setHorario(horario);
        setProfessor(professor);
        setQuantidadeAtualAlunos(0);
        setStatus(true);
        alunosMatriculados = new Aluno[getQuantidadeMaximaAlunos()];
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCargaHorariaCurso(int cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    public int getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setDateInicio(String dateInicio) {
        this.dateInicio = dateInicio;
    }

    public String getDateInicio() {
        return dateInicio;
    } 

    public void setDateFim(String dateFim) {
        this.dateFim = dateFim;
    }

    public String getDateFim() {
        return dateFim;
    }

    public void setQuantidadeAtualAlunos(int quantidadeAtualAlunos) {
        this.quantidadeAtualAlunos = quantidadeAtualAlunos;
    }

    public int getQuantidadeAtualAlunos() {
        return quantidadeAtualAlunos;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getQuantidadeMaximaAlunos() {
        return quantidadeMaximaAlunos;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setAlunosMatriculados(Aluno aluno) {
        this.alunosMatriculados[quantidadeAtualAlunos] = aluno;
        setQuantidadeAtualAlunos(getQuantidadeAtualAlunos() + 1);
    }

    public Aluno getAlunosMatriculados(int i) {
        return alunosMatriculados[i];
    }

    public String salvaAluno() {

        try {
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

        } catch (IOException ex){
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}