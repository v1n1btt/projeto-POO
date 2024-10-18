public class Aluno extends Pessoa {
    
    private int idade;
    private String cpf;
    private String plano;

    public Aluno(String nome, String codigoUsuario, int idade, String cpf, String plano) {
        super(nome, codigoUsuario);
        this.idade = idade;
        this.cpf = cpf;
        this.plano = plano;
    }

    public int getidade() {
        return idade;
    }

    public void setidade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getplano() {
        return plano;
    }

    public void setplano(String plano) {
        this.plano = plano;
    }

}
