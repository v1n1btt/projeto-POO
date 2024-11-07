package Projeto;

public class Turma extends Curso {

    private String horario;

    public Turma(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String dataInicio, String dataFim,int quantidadeAtualAlunos, Professor professor, String horario) {
        super(nomeCurso, codigoCurso, cargaHorariaCurso, ementa, dataInicio, dataFim, quantidadeAtualAlunos,professor);
        setHorario(horario);
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

}