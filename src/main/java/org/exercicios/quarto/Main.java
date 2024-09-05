package org.exercicios.quarto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- Editor de Texto ---");
            System.out.println("1. Adicionar texto");
            System.out.println("2. Desfazer última ação (Undo)");
            System.out.println("3. Refazer última ação (Redo)");
            System.out.println("4. Exibir texto atual");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após a entrada do número

            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto a ser adicionado: ");
                    String textoAdicionar = scanner.nextLine();
                    textEditor.addText(textoAdicionar);
                    textEditor.showText();
                    break;
                case 2:
                    textEditor.undo();
                    textEditor.showText();
                    break;
                case 3:
                    textEditor.redo();
                    textEditor.showText();
                    break;
                case 4:
                    textEditor.showText();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
