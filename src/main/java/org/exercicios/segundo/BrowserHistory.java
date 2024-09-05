package org.exercicios.segundo;

public class BrowserHistory {
    private URLNode head;   // Primeira URL da lista (mais antiga)
    private URLNode tail;   // Última URL da lista (mais recente)
    private int size;       // Número de URLs armazenadas atualmente
    private final int maxSize; // Tamanho máximo do histórico

    // Construtor da classe BrowserHistory
    public BrowserHistory(int maxSize) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.maxSize = maxSize;
    }


    public void addURL(String url) {
        URLNode newNode = new URLNode(url);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Aponta o nó atual para o novo
            tail = newNode;      // Atualiza o tail para o novo nó
        }
        size++;

        // Se o histórico exceder o tamanho máximo, remover a URL mais antiga
        if (size > maxSize) {
            removeOldestURL();
        }

        System.out.println("URL adicionada: " + url);
    }


    private void removeOldestURL() {
        if (head != null) {
            System.out.println("Removendo URL mais antiga: " + head.url);
            head = head.next; // O segundo nó se torna o head
            size--;
        }
    }


    public void showHistory() {
        if (head == null) {
            System.out.println("Histórico de navegação vazio.");
            return;
        }

        System.out.println("\nHistórico de Navegação:");
        URLNode current = head;
        while (current != null) {
            System.out.println(current.url);
            current = current.next;
        }
    }
}
