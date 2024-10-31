package Projeto;

public class Turma extends Curso {

    private String horario;

    public Turma(String getNomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, boolean status, int quantidadeAlunos, String horario) {
        super(nomeCurso, codigoCursp, cargaHorariaCurso, ementa, status, quantidadeAlunos);
        setHorario(horario);
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

}