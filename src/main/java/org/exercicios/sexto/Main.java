package org.exercicios.sexto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankQueue bankQueue = new BankQueue();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- Simulador de Fila de Atendimento ---");
            System.out.println("1. Adicionar cliente à fila");
            System.out.println("2. Chamar próximo cliente");
            System.out.println("3. Exibir fila");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após a entrada do número

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    bankQueue.addClient(nomeCliente);
                    break;
                case 2:
                    bankQueue.callNextClient();
                    break;
                case 3:
                    bankQueue.showQueue();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
