package Projeto;

public class Curso {

    private String nomeCurso;
    private String codigoCurso;
    private int cargaHorariaCurso;
    private String ementa;
    private String dataInicio; 
    private String dataFim; 
    private boolean status;
    private final int quantidadeMaximaAlunos = 50;


    public Curso(String nomeCurso, String codigoCurso, int cargaHorariaCurso, String ementa, String dataInicio, String dataFim) {
        setNomeCurso(nomeCurso);
        setCodigoCurso(codigoCurso);
        setCargaHorariaCurso(cargaHorariaCurso);
        setEmenta(ementa);
        setStatus(true);
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCargaHorariaCurso(int cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    public int getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataInicio() {
        return dataInicio;
    } 

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    public String getDataFim() {
        return dataFim;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public int getQuantidadeMaximaAlunos() {
        return quantidadeMaximaAlunos;
    }
}