package Projeto;
public class Professor extends Pessoa {

    private int cargaHoraria;

    public Professor(String nome, String codigoUsuario, String email, String senhaPessoal,int cargaHoraria) {
        super(nome, codigoUsuario, email, senhaPessoal); 
        this.cargaHoraria = cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

}
