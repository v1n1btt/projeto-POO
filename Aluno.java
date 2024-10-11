package projeto-POO;
public class Aluno {
    private String nome;
    private String codigo;
    private int idade;
    private String CPF;
    private String plano;

    public Aluno(String nome, String codigo, int idade, String CPF, String plano) {
        this.nome = nome;
        this.codigo = codigo;
        this.idade = idade;
        this.CPF = CPF;
        this.plano = plano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getidade() {
        return idade;
    }

    public void setidade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getplano() {
        return plano;
    }

    public void setplano(String plano) {
        this.plano = plano;
    }

}
