public class Pessoa {
    
    private String nome; 
    private String codigoUsuario;

    public Pessoa(String nome, String codigoUsuario) {
        this.nome = nome; 
        this.codigoUsuario = codigoUsuario; 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigoUsuario;
    }

    public void setCodigo(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}