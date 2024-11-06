package Projeto;

public class Professor extends Pessoa {

    private int cargaHoraria;

    public Professor(String nome, int codigoUsuario, String email, String senhaPessoal) {
        super(nome, codigoUsuario, email, senhaPessoal); 
        setCargaHoraria(0);
        setNivelAcesso(2);
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

}