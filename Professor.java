public class Professor extends Pessoa {

    private int cargaHoraria;

    public Professor(String nome, String codigoUsuario, int cargaHoraria) {
        super(nome, codigoUsuario); 
        this.cargaHoraria = cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

}
