package Projeto;

public class Turma extends Curso {

    private String horario;
    private Aluno[] alunosMatriculados;

    public Turma(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String dataInicio, String dataFim,int quantidadeAtualAlunos, Professor professor, String horario) {
        super(nomeCurso, codigoCurso, cargaHorariaCurso, ementa, dataInicio, dataFim, quantidadeAtualAlunos,professor);
        setHorario(horario);
        alunosMatriculados = new Aluno[getQuantidadeMaximaAlunos()];
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setAlunosMatriculados(Aluno aluno) {
        for(int i = getQuantidadeAtualAlunos(); i <= getQuantidadeMaximaAlunos(); i++){
            this.alunosMatriculados[i] = aluno;
            setQuantidadeAtualAlunos(getQuantidadeAtualAlunos() + 1);
        }
    }

    public Aluno getAlunosMatriculados(int i) {
        return alunosMatriculados[i];
    }

}