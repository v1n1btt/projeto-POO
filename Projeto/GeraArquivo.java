/*package Projeto;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.IOException;
import java.util.Scanner;


public class GeraArquivo {
    
    public static void main(String[] args) {
        Scanner sc;
        int nroPessoa, i;
        ObjectOutputStream oos;
        int codigoUsuario;
        String nome, email, senhaPessoal, line;
        int nivelAcesso;
        Pessoa[] cadastro;
        
        if (args.length != 1){ // testa entrada de argumentos
            System.err.println("Nro de argumentos invalidos: "+args.length);
            System.err.println("Uso: java GeraArquivo <NomeArquivoSaida>");
            System.exit(0);
        }
       
        // inicializacao das variaveis
        sc = new Scanner(System.in);
        oos = null;
        
        // leitura numero de Pessoas a serem cadastradas
        do{
            System.out.print("Entre com o numero de Pessoa: ");
            line = sc.nextLine();
            try{
               nroPessoa = Integer.parseInt(line); 
            } catch (NumberFormatException nfe){
                System.out.println("Formato Invalido: "+line);
                nroPessoa = -1;
            }
        }while (nroPessoa <= 0);
        
        // leitura informacoes das Pessoa
        cadastro = new Pessoa[nroPessoa];
        for (i = 0; i < nroPessoa; i++){
            do{
                System.out.print("Entre com o codigo do usuario: ");
                line = sc.nextLine();
                try{
                    codigoUsuario = Integer.parseInt(line); 
                } catch (NumberFormatException nfe){
                    System.out.println("Formato Invalido: "+line);
                    codigoUsuario = -1;
                }
            }while (codigoUsuario <= 0 || verificaCadastro(cadastro, codigoUsuario, i));
            
            System.out.print("Entre com o nome: ");
            nome = sc.nextLine();
            
            System.out.print("Entre com o email: ");
            email = sc.nextLine();
            
            System.out.print("Entre com a senha pessoal: ");
            senhaPessoal = sc.nextLine();
            
            do{
                System.out.print("Entre com o nivel de acesso: ");
                line = sc.nextLine();
                try{
                    nivelAcesso = Integer.parseInt(line); 
                } catch (NumberFormatException nfe){
                    System.out.println("Formato Invalido: "+line);
                    nivelAcesso = -1;
                }
            }while (nivelAcesso < 0);
            
            cadastro[i] = new Pessoa(nome, codigoUsuario, email, senhaPessoal);
            System.out.println(); // pula linha
        }
        
        // Salva informacoes das Pessoa para arquivo
        try{
            oos = new ObjectOutputStream(new FileOutputStream(args[0]));
            for (i = 0; i < nroPessoa; i++)
                oos.writeObject(cadastro[i]);
        }catch (FileNotFoundException fnfe){
            System.err.println("Could not open file: "+args[0]);
            System.err.println(fnfe);
            System.exit(0);
        }catch (InvalidClassException ice){
            System.err.println("Could not write object: "+ice);
            System.exit(0);
        }catch (NotSerializableException nse){
            System.err.println("Could not serialize object: "+nse);
            System.exit(0);
        }catch (IOException ioe){
            System.err.println("Could not write object to file: "+ioe);
            System.exit(0);
        } 
        
        // fecha arquivo
        try{
            oos.close();    
        }catch (IOException ioe){
            System.err.println("Could not close file: "+ioe);
            System.exit(0);
        }
    }
    
    public static boolean verificaCadastro(Pessoa[] cadastro, int codigoUsuario, int index){
        boolean resp = false;
        
        for (int i = 0; i < index; i++) {
            if (cadastro[i].getCodigoUsuario() == codigoUsuario) {
                resp = true;
                break;
            }
        }
        
        return resp;
    }
}*/