package Projeto;

public class Aluno extends Pessoa 
{
    private String cpf;

    /**
     * @param nome
     * @param codigoUsuario
     * @param email
     * @param senhaPessoal
     * @param nivelAcesso
     * @param cpf
     */

    public Aluno(String nome, int codigoUsuario, String email, String senhaPessoal, String nivelAcesso, String cpf) 
    {
        super(nome, codigoUsuario, email, senhaPessoal, nivelAcesso);
        this.cpf = cpf;
    }

    /**
     * @param cpf
     */

    public void setCPF(String cpf) 
    {
        this.cpf = cpf;
    }

    /**
     * @return
     */

    public String getCPF() 
    {
        return cpf;
    }

}