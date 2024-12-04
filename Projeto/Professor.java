package Projeto;

public class Professor extends Pessoa 
{
    private int cargaHorariaAtual;
    private final int cargaHorariaMaxima = 80; 

    /**
     * @param nome
     * @param codigoUsuario
     * @param email
     * @param senhaPessoal
     * @param nivelAcesso
     */
    public Professor(String nome, int codigoUsuario, String email, String senhaPessoal, String nivelAcesso) 
    {
        super(nome, codigoUsuario, email, senhaPessoal, nivelAcesso); 
        this.cargaHorariaAtual = 0;
    }

    /**
     * @param cargaHorariaAtual
     */
    public void setCargaHorariaAtual(int cargaHorariaAtual) 
    {
        this.cargaHorariaAtual = cargaHorariaAtual;
    }

    /**
     * @return
     */
    public int getCargaHorariaAtual() 
    {
        return cargaHorariaAtual;
    }

    /**
     * @return
     */
    public int getCargaHorariaMaxima() 
    {
        return cargaHorariaMaxima; 
    }
}