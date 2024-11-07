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
    private String dataInicio; 
    private String dataFim; 
    private boolean status;
    private int quantidadeAtualAlunos;
    private Professor professor;  
    private final int quantidadeMaximaAlunos = 50;


    public Curso(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String dataInicio, String dataFim, int quantidadeAtualAlunos, Professor professor) {
        setNomeCurso(nomeCurso);
        setCodigoCurso(codigoCurso);
        setCargaHorariaCurso(cargaHorariaCurso);
        setEmenta(ementa);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setQuantidadeAtualAlunos(quantidadeAtualAlunos);
        setStatus(true);
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

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataInicio() {
        return dataInicio;
    } 

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataFim() {
        return dataFim;
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

    public String salvaAluno(){

        try {
            FileWriter fw = new FileWriter("Curso.txt");
            PrintWriter pw = new PrintWriter("fw");
            pw.println("Nome do curso: "+this.nomeCurso);
            pw.println("Codigo do curso: "+this.codigoCurso);
            pw.println("Status: "+this.status);
            pw.println("Quantidade máxima de alunos: "+this.quantidadeMaximaAlunos);
            pw.println("Finalização do curso: "+this.dataFim);
            pw.println("Início do Curso: "+this.dataInicio);
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