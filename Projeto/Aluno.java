package Projeto;

public class Aluno extends Pessoa {

    private String cpf;
    private String plano;

    public Aluno(String nome, int codigoUsuario, String email, String senhaPessoal, String cpf, String plano) {
        super(nome, codigoUsuario, email, senhaPessoal);
        setCPF(cpf);
        setPlano(plano);
        setNivelAcesso(3);
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCPF() {
        return cpf;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getPlano() {
        return plano;
    }

}