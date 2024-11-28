package Projeto; 
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 

public class GeraArquivo { 

    // Método para criar um arquivo .csv com as informações do curso 
    public static void criarArquivoCurso(String nomeCurso, String codigoCurso, String ementa, 
                                          String dateInicio, String dateFim, String horario, 
                                          int cargaHorariaCurso, Professor professor, Aluno[] alunosMatriculados, 
                                          int quantidadeAtualAlunos) { 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeCurso + ".csv"))) { 
            // Cabeçalho do CSV
            writer.write("Nome do Curso,Código do Curso,Ementa,Data de Início,Data de Fim,Horário,Carga Horária,Professor,Quantidade de Alunos Matriculados,Lista de Alunos");
            writer.newLine(); 
            // Dados do curso
            writer.write(nomeCurso + "," + codigoCurso + "," + ementa + "," + dateInicio + "," + dateFim + "," + horario + "," + cargaHorariaCurso + "," + professor.getNome() + "," + quantidadeAtualAlunos + ",");
            for (int i = 0; i < quantidadeAtualAlunos; i++) { 
                writer.write(alunosMatriculados[i].getNome());
                if (i < quantidadeAtualAlunos - 1) {
                    writer.write("; "); // Separador entre os nomes dos alunos
                }
            }
            writer.newLine(); 
        } catch (IOException e) { 
            System.out.println("Erro ao criar arquivo do curso: " + e.getMessage()); 
        } 
    } 

    // Método para criar um arquivo .csv com as informações do usuário 
    public static void criarArquivoUsuario(Pessoa usuario) { 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usuario.getNome() + "_usuario.csv"))) { 
            // Cabeçalho do CSV
            writer.write("Nome,Código do Usuário,Email,Senha Pessoal,Nível de Acesso");
            writer.newLine(); 
            // Dados do usuário
            writer.write(usuario.getNome() + "," + usuario.getCodigoUsuario() + "," + usuario.getEmail() + "," + usuario.getSenhaPessoal() + "," + usuario.getNivelAcesso()); 
            writer.newLine(); 
        } catch (IOException e) { 
            System.out.println("Erro ao criar arquivo do usuário: " + e.getMessage()); 
        } 
    } 
}