package Projeto;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GeraArquivo {
    private String nomeArquivo;

    public GeraArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void gerarCadastro() {
        Scanner sc = new Scanner(System.in);
        int nroPessoa, i;
        ObjectOutputStream oos = null;
        int codigoUsuario;
        String nome, email, senhaPessoal, line;
        int nivelAcesso;
        Pessoa[] cadastro;

        // Leitura do número de Pessoas a serem cadastradas
        do {
            System.out.print("Entre com o numero de Pessoa: ");
            line = sc.nextLine();
            try {
                nroPessoa = Integer.parseInt(line);
            } catch (NumberFormatException nfe) {
                System.out.println("Formato Invalido: " + line);
                nroPessoa = -1;
            }
        } while (nroPessoa <= 0);

        // Leitura das informações das Pessoas
        cadastro = new Pessoa[nroPessoa];
        for (i = 0; i < nroPessoa; i++) {
            do {
                System.out.print("Entre com o codigo do usuario: ");
                line = sc.nextLine();
                try {
                    codigoUsuario = Integer.parseInt(line);
                } catch (NumberFormatException nfe) {
                    System.out.println("Formato Invalido: " + line);
                    codigoUsuario = -1;
                }
            } while (codigoUsuario <= 0 || verificaCadastro(cadastro, codigoUsuario, i));

            System.out.print("Entre com o nome: ");
            nome = sc.nextLine();

            System.out.print("Entre com o email: ");
            email = sc.nextLine();

            System.out.print("Entre com a senha pessoal: ");
            senhaPessoal = sc.nextLine();

            do {
                System.out.print("Entre com o nivel de acesso: ");
                line = sc.nextLine();
                try {
                    nivelAcesso = Integer.parseInt(line);
                } catch (NumberFormatException nfe) {
                    System.out.println("Formato Invalido: " + line);
                    nivelAcesso = -1;
                }
            } while (nivelAcesso < 0);

            cadastro[i] = new Pessoa(nome, codigoUsuario, email, senhaPessoal);
            System.out.println(); // pula linha
        }

        // Salva informações das Pessoas para arquivo
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.nomeArquivo));
            for (i = 0; i < nroPessoa; i++)
                oos.writeObject(cadastro[i]);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not open file: " + this.nomeArquivo);
            System.err.println(fnfe);
            System.exit(0);
        } catch (InvalidClassException ice) {
            System.err.println("Could not write object: " + ice);
            System.exit(0);
        } catch (NotSerializableException nse) {
            System.err.println("Could not serialize object: " + nse);
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println("Could not write object to file: " + ioe);
            System.exit(0);
        }

        // Fecha arquivo
        try {
            if (oos != null) {
                oos.close();
            }
        } catch (IOException ioe) {
            System.err.println("Could not close file: " + ioe);
            System.exit(0);
        }
    }

    public void gerarDisciplina(String nomeArquivoDisciplina) {
        Scanner sc = new Scanner(System.in);
        String nomeCurso, codigoCurso, ementa, dataInicio, dataFim, horario;
        int cargaHorariaCurso;
        Professor professor; // Supondo que você tenha uma classe Professor
        Aluno[] alunosMatriculados = new Aluno[50]; // Supondo que você tenha uma classe Aluno
        int quantidadeAtualAlunos = 0;
        boolean status;

        // Leitura das informações da disciplina
        System.out.print("Entre com o nome do curso: ");
        nomeCurso = sc.nextLine();

        System.out.print("Entre com o código do curso: ");
        codigoCurso = sc.nextLine();

        System.out.print(" Entre com a carga horária do curso: ");
        cargaHorariaCurso = Integer.parseInt(sc.nextLine());

        System.out.print("Entre com a ementa: ");
        ementa = sc.nextLine();

        System.out.print("Entre com a data de início: ");
        dataInicio = sc.nextLine();

        System.out.print("Entre com a data de fim: ");
        dataFim = sc.nextLine();

        System.out.print("Entre com o horário: ");
        horario = sc.nextLine();

        // Aqui você pode adicionar a lógica para capturar o professor e os alunos matriculados, se necessário

        // Salva informações da disciplina para arquivo
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(nomeArquivoDisciplina))) {
            writer.println("Nome do Curso: " + nomeCurso);
            writer.println("Código do Curso: " + codigoCurso);
            writer.println("Carga Horária: " + cargaHorariaCurso);
            writer.println("Ementa: " + ementa);
            writer.println("Data de Início: " + dataInicio);
            writer.println("Data de Fim: " + dataFim);
            writer.println("Horário: " + horario);
            // Adicione mais informações conforme necessário
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not open file: " + nomeArquivoDisciplina);
            System.err.println(fnfe);
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println("Could not write to file: " + ioe);
            System.exit(0);
        }
    }

    public static boolean verificaCadastro(Pessoa[] cadastro, int codigoUsuario, int index) {
        boolean resp = false;

        for (int i = 0; i < index; i++) {
            if (cadastro[i].getCodigoUsuario() == codigoUsuario) {
                resp = true;
                break;
            }
        }

        return resp;
    }
}