package Projeto;
public class Aluno extends Pessoa {

    private int idade;
    private String cpf;
    private String plano;

    public Aluno(String nome, String codigoUsuario, String email, String senhaPessoal, int idade, String cpf, String plano) {
        super(nome, codigoUsuario, email, senhaPessoal);
        this.idade = idade;
        this.cpf = cpf;
        this.plano = plano;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

}
