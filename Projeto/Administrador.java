package Projeto;

public class Administrador extends Pessoa { 
    
    public Administrador(String nome, String codigoUsuario, String email, String senhaPessoal) {
        super(nome, codigoUsuario, email, senhaPessoal);
        setNivelAcesso(1);
    }

}