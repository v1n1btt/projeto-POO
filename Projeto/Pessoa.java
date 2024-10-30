package Projeto;

public class Pessoa {
    
    private String nome; 
    private String codigoUsuario;
    private String email; 
    private String senhaPessoal;
    private int nivelAcesso;

    public Pessoa(String nome, String codigoUsuario, String email, String senhaPessoal) {
        setNome(nome);
        setCodigoUsuario(codigoUsuario);
        setEmail(email);
        setSenhaPessoal(senhaPessoal);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenhaPessoal(String senhaPessoal) {
        this.senhaPessoal = senhaPessoal;
    }

    public String getSenhaPessoal() {
        return senhaPessoal;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso; 
    }

    public int getNivelAcesso() {
        return nivelAcesso; 
    }
    
}