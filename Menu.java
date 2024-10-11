import java.util.Scanner;

public class Menu{

    public static void criarConta(){

        // Dados do usuario
        string cpf;
        string nome;
        string dataNascimento;
        string senha;
        string confirmaSenha;

        Scanner sc = new Scanner(System.in);

        // Insercao de dados do usuario
        limpaTela();
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.print("====================\nREGISTRO\n====================\n\n");
        System.out.print("CPF do usuário: ");
        cpf = sc.nextLine();
        System.out.print("Nome completo: ");
        nome = sc.nextLine();
        System.out.print("Data de nascimento: ");
        dataNascimento = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        System.out.print("Confirme a senha: ");
        confirmaSenha = sc.nextLine();

        if(senha == confirmaSenha){

        }
    }

    public static void limpaTela(){
        final String os = System.getProperty("os.name");
        if (os.contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int escolha;

        // Menu principal
        System.out.print("SISTEMA DE GESTÃO DE CURSOS\n\n");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Fazer cadastro");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("\nDigite sua escolha: ");

        escolha = Integer.parseInt(sc.nextLine());
        switch(escolha){
            case 1:

                break;

            case 2:

                break;

            case 3:
                return;
        }
    }
}
