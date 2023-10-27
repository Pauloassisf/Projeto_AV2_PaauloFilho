package q2_PauloFilho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

	public class SistemaDeLogin {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Escolha uma opção:");
	            System.out.println("1 - Cadastrar um novo usuário");
	            System.out.println("2 - Fazer login");
	            System.out.println("3 - Sair");

	            int opcao = scanner.nextInt();
	            scanner.nextLine(); // Consumir a quebra de linha após o número

	            switch (opcao) {
	                case 1:
	                    cadastrarUsuario();
	                    break;
	                case 2:
	                    fazerLogin();
	                    break;
	                case 3:
	                    System.out.println("Saindo do programa.");
	                    System.exit(0);
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            }
	        }
	    }

	    private static void cadastrarUsuario() {
	        try {
	            Scanner scanner = new Scanner(System.in);

	            System.out.print("Digite o nome de usuário: ");
	            String nomeUsuario = scanner.nextLine();

	            System.out.print("Digite a senha: ");
	            String senha = scanner.nextLine();

	            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true));
	            writer.write(nomeUsuario + "," + senha);
	            writer.newLine();
	            writer.close();

	            System.out.println("Usuário cadastrado com sucesso.");
	        } catch (IOException e) {
	            System.err.println("Erro ao cadastrar o usuário: " + e.getMessage());
	        }
	    }

	    private static void fazerLogin() {
	        try {
	            Scanner scanner = new Scanner(System.in);

	            System.out.print("Digite o nome de usuário: ");
	            String nomeUsuario = scanner.nextLine();

	            System.out.print("Digite a senha: ");
	            String senha = scanner.nextLine();

	            BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"));
	            String linha;
	            boolean sucesso = false;

	            while ((linha = reader.readLine()) != null) {
	                String[] partes = linha.split(",");
	                if (partes.length == 2 && partes[0].equals(nomeUsuario) && partes[1].equals(senha)) {
	                    sucesso = true;
	                    break;
	                }
	            }

	            if (sucesso) {
	                System.out.println("SUCESSO - Login realizado com sucesso!");
	            } else {
	                System.out.println("FRACASSO - Login ou senha incorretos.");
	            }
	        } catch (IOException e) {
	            System.err.println("Erro ao fazer o login: " + e.getMessage());
	        }
	    }
	}
