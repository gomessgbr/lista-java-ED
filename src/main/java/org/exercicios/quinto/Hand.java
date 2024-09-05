package org.exercicios.quinto;

public class Hand {
    private CardNode head;   // Referência ao primeiro nó (primeira carta)
    private CardNode tail;   // Referência ao último nó (última carta)
    private int size;        // Tamanho da mão (número de cartas)

    // Construtor
    public Hand() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Adiciona uma carta ao final da mão
    public void addCard(String card) {
        CardNode newNode = new CardNode(card);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Carta adicionada: " + card);
    }

    // Remove uma carta da mão
    public void removeCard(String card) {
        if (head == null) {
            System.out.println("A mão está vazia.");
            return;
        }

        CardNode current = head;
        while (current != null && !current.card.equals(card)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Carta não encontrada na mão.");
        } else {
            // Remove o nó da lista
            if (current == head) {
                head = current.next;
                if (head != null) {
                    head.prev = null;
                }
            } else if (current == tail) {
                tail = current.prev;
                if (tail != null) {
                    tail.next = null;
                }
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
            System.out.println("Carta removida: " + card);
        }
    }

    // Mover uma carta para uma nova posição
    public void moveCard(String card, int newPosition) {
        if (newPosition < 1 || newPosition > size) {
            System.out.println("Posição inválida.");
            return;
        }

        // Localiza a carta a ser movida
        CardNode current = head;
        while (current != null && !current.card.equals(card)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Carta não encontrada na mão.");
            return;
        }

        // Remove o nó atual da lista
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        // Insere o nó na nova posição
        if (newPosition == 1) {
            current.next = head;
            current.prev = null;
            if (head != null) {
                head.prev = current;
            }
            head = current;
        } else {
            CardNode temp = head;
            int count = 1;
            while (count < newPosition - 1) {
                temp = temp.next;
                count++;
            }

            current.next = temp.next;
            current.prev = temp;
            if (temp.next != null) {
                temp.next.prev = current;
            }
            temp.next = current;

            if (current.next == null) {
                tail = current;
            }
        }

        System.out.println("Carta movida: " + card + " para a posição " + newPosition);
    }

    // Exibir a mão do jogador
    public void showHand() {
        if (head == null) {
            System.out.println("A mão está vazia.");
            return;
        }

        System.out.println("\nMão do Jogador:");
        CardNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.card);
            current = current.next;
            position++;
        }
    }
}
