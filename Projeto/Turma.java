package Projeto;

public class Turma extends Curso {

    private String horario;

    public Turma(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, int quantidadeAlunos, String horario) {
        super(nomeCurso, codigoCurso, cargaHorariaCurso, ementa);
        setHorario(horario);
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

}