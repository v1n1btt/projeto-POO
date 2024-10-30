package Projeto;
public class Curso {

    private String nomeCurso;
    private String codigoCurso;
    private int cargaHorariaCurso;
    private String ementa;
    private boolean status; 

    public Curso(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa) {
        setNomeCurso(nomeCurso);
        setCodigoCurso(codigoCurso);
        setCargaHorariaCurso(cargaHorariaCurso);
        setEmenta(ementa);
        setStatus(true);
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public void setCargaHorariaCurso(int cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
