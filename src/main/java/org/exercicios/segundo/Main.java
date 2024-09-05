package org.exercicios.segundo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Defina o tamanho máximo do histórico: ");
        int maxSize = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer após a entrada de número

        BrowserHistory browserHistory = new BrowserHistory(maxSize);

        int opcao = 0;
        while (opcao != 3) {
            System.out.println("\n--- Navegador Simulado ---");
            System.out.println("1. Adicionar nova URL");
            System.out.println("2. Exibir histórico de navegação");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a nova URL: ");
                    String url = scanner.nextLine();
                    browserHistory.addURL(url);
                    break;
                case 2:
                    browserHistory.showHistory();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}