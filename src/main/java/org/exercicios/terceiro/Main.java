package org.exercicios.terceiro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- Editor de Texto ---");
            System.out.println("1. Adicionar texto");
            System.out.println("2. Remover texto");
            System.out.println("3. Desfazer última ação");
            System.out.println("4. Sair");
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
                    System.out.print("Digite o número de caracteres a serem removidos: ");
                    int caracteresRemover = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    textEditor.removeText(caracteresRemover);
                    textEditor.showText();
                    break;
                case 3:
                    textEditor.undo();
                    textEditor.showText();
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
