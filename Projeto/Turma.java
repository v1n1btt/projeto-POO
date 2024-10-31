package Projeto;

public class Turma extends Curso {

    private String horario;
    private int quantidadeAlunos;

    public Turma(String getNomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String horario, int quantidadeAlunos) {
        super(nomeCurso, codigoCursp, cargaHorariaCurso, ementa);
        setHorario(horario);
        setQuantidadeAlunos(quantidadeAlunos);
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

}