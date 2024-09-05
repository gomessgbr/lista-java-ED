package org.exercicios.terceiro;

public class TextEditor {
    private ActionNode head;  // Referência para a primeira ação (mais antiga)
    private ActionNode tail;  // Referência para a última ação (mais recente)
    private StringBuilder currentText; // Texto atual


    public TextEditor() {
        this.head = null;
        this.tail = null;
        this.currentText = new StringBuilder(); // Inicialmente, o texto está vazio
    }


    public void addText(String text) {
        ActionNode newNode = new ActionNode("adicionar", text);

        // Adiciona a nova ação à lista
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        // Atualiza o texto atual
        currentText.append(text);
        System.out.println("Texto adicionado: " + text);
    }


    public void removeText(int n) {
        if (n > currentText.length()) {
            System.out.println("Não é possível remover mais caracteres do que o texto atual.");
            return;
        }

        String removedText = currentText.substring(currentText.length() - n);
        ActionNode newNode = new ActionNode("remover", removedText);

        // Adiciona a nova ação à lista
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        // Atualiza o texto atual removendo os últimos n caracteres
        currentText.delete(currentText.length() - n, currentText.length());
        System.out.println("Texto removido: " + removedText);
    }


    public void undo() {
        if (head == null) {
            System.out.println("Nenhuma ação a desfazer.");
            return;
        }

        // Percorre até o penúltimo nó
        ActionNode current = head;
        ActionNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        // Desfaz a ação mais recente
        if (current.action.equals("adicionar")) {
            int length = current.content.length();
            currentText.delete(currentText.length() - length, currentText.length());
            System.out.println("Desfeita a ação de adicionar texto: " + current.content);
        } else if (current.action.equals("remover")) {
            currentText.append(current.content);
            System.out.println("Desfeita a ação de remover texto: " + current.content);
        }

        // Remove o último nó da lista
        if (previous == null) {
            head = null; // Se a lista só tinha um nó
            tail = null;
        } else {
            previous.next = null;
            tail = previous;
        }
    }

    // Exibe o texto atual
    public void showText() {
        System.out.println("\nTexto atual: " + currentText.toString());
    }
}
