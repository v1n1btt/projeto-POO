package Projeto;

public class Administrador extends Pessoa 
{ 
    /**
     * @param nome
     * @param codigoUsuario
     * @param email
     * @param senhaPessoal
     * @param nivelAcesso
     */
    
    public Administrador(String nome, int codigoUsuario, String email, String senhaPessoal, String nivelAcesso) 
    {
        super(nome, codigoUsuario, email, senhaPessoal, nivelAcesso);
    }
}