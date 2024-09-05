package org.exercicios.oitavo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProcessQueue processQueue = new ProcessQueue();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- Gerenciamento de Processos ---");
            System.out.println("1. Adicionar processo à fila");
            System.out.println("2. Executar próximo processo");
            System.out.println("3. Exibir fila de processos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após a entrada do número

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição do processo: ");
                    String descricaoProcesso = scanner.nextLine();
                    processQueue.addProcess(descricaoProcesso);
                    break;
                case 2:
                    processQueue.executeNextProcess();
                    break;
                case 3:
                    processQueue.showQueue();
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
