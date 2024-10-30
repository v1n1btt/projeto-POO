package Projeto;

public class Pessoa {
    
    private String nome; 
    private String codigoUsuario;
    private String email; 
    private String senhaPessoal;

    public Pessoa(String nome, String codigoUsuario, String email, String senhaPessoal) {
        this.nome = nome; 
        this.codigoUsuario = codigoUsuario;
        this.email = email; 
        this.senhaPessoal = senhaPessoal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigo() {
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
    
}