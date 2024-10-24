package Projeto;

public class Turma extends Curso{
    private String sala;
    private String horario;
    private int quantidadeAlunos;

    public Turma(String nome, String codigo, int cargaHoraria, String ementa, String preRequisitos, String sala, String horario, int quantidadeAlunos){
        super(nome, codigo, cargaHoraria, ementa, preRequisitos);
        setSala(sala);
        setHorario(horario);
        setQuantidadeAlunos(quantidadeAlunos);
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public String getHorario() {
        return horario;
    }

    public String getSala() {
        return sala;
    }
}