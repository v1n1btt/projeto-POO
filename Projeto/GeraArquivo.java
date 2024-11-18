package Projeto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GeraArquivo {
    
    // Método para criar um arquivo .txt com as informações do curso
    public static void criarArquivoCurso(String nomeCurso, String codigoCurso, String ementa, 
                                         String dateInicio, String dateFim, String horario, 
                                         int cargaHorariaCurso, Professor professor, Aluno[] alunosMatriculados, 
                                         int quantidadeAtualAlunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeCurso + ".txt"))) {
            writer.write("Nome do Curso: " + nomeCurso);
            writer.newLine();
            writer.write("Código do Curso: " + codigoCurso);
            writer.newLine();
            writer.write("Ementa: " + ementa);
            writer.newLine();
            writer.write("Data de Início: " + dateInicio);
            writer.newLine();
            writer.write("Data de Fim: " + dateFim);
            writer.newLine();
            writer.write("Horário: " + horario);
            writer.newLine();
            writer.write("Carga Horária: " + cargaHorariaCurso);
            writer.newLine();
            writer.write("Professor: " + professor.getNome()); // Supondo que Professor tenha um método getNome()
            writer.newLine();
            writer.write("Alunos Matriculados: " + quantidadeAtualAlunos);
            writer.newLine();
            writer.write("Lista de Alunos:");
            writer.newLine();
            for (int i = 0; i < quantidadeAtualAlunos; i++) {
                writer.write(alunosMatriculados[i].getNome()); // Supondo que Aluno tenha um método getNome()
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo do curso: " + e.getMessage());
        }
    }

    // Método para criar um arquivo .txt com as informações do usuário
    public static void criarArquivoUsuario(Pessoa usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usuario.getNome() + "_usuario.txt"))) {
            writer.write("Nome: " + usuario.getNome());
            writer.newLine();
            writer.write("Código do Usuário: " + usuario.getCodigoUsuario());
            writer.newLine();
            writer.write("Email: " + usuario.getEmail());
            writer.newLine();
            writer.write("Senha Pessoal: " + usuario.getSenhaPessoal());
            writer.newLine();
            writer.write("Nível de Acesso: " + usuario.getNivelAcesso());
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo do usuário: " + e.getMessage());
        }
    }
}