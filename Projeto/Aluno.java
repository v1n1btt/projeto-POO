package Projeto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aluno extends Pessoa {

    private String cpf;
    private String plano;

    public Aluno(String nome, int codigoUsuario, String email, String senhaPessoal, String cpf, String plano) {
        super(nome, codigoUsuario, email, senhaPessoal);
        setCPF(cpf);
        setPlano(plano);
        setNivelAcesso(3);
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCPF() {
        return cpf;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getPlano() {
        return plano;
    }
    public String salvaAluno(){

        try {
            FileWriter fw = new FileWriter("Aluno.txt");
            PrintWriter pw = new PrintWriter("fw");
            pw.println("CPF: "+this.cpf);
            pw.println("Plano: "+this.plano);
            pw.flush();
            pw.close();
            fw.close();

        } catch (IOException ex){
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}