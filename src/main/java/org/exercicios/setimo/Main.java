package org.exercicios.setimo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- Gerenciamento de Impressão ---");
            System.out.println("1. Adicionar trabalho de impressão");
            System.out.println("2. Processar próximo trabalho de impressão");
            System.out.println("3. Exibir fila de impressão");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após a entrada do número

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do documento: ");
                    String nomeDocumento = scanner.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    printQueue.addPrintJob(nomeDocumento, paginas);
                    break;
                case 2:
                    printQueue.processNextJob();
                    break;
                case 3:
                    printQueue.showQueue();
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
