package org.exercicios.quinto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hand hand = new Hand();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- Jogo de Cartas ---");
            System.out.println("1. Adicionar carta");
            System.out.println("2. Remover carta");
            System.out.println("3. Mover carta");
            System.out.println("4. Exibir mão");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da carta a ser adicionada: ");
                    String cartaAdicionar = scanner.nextLine();
                    hand.addCard(cartaAdicionar);
                    hand.showHand();
                    break;
                case 2:
                    System.out.print("Digite o nome da carta a ser removida: ");
                    String cartaRemover = scanner.nextLine();
                    hand.removeCard(cartaRemover);
                    hand.showHand();
                    break;
                case 3:
                    System.out.print("Digite o nome da carta a ser movida: ");
                    String cartaMover = scanner.nextLine();
                    System.out.print("Digite a nova posição: ");
                    int novaPosicao = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    hand.moveCard(cartaMover, novaPosicao);
                    hand.showHand();
                    break;
                case 4:
                    hand.showHand();
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
