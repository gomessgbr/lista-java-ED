package org.exercicios.quarto;

public class TextEditor {
    private ActionNode head;       // Referência ao início da lista de ações
    private ActionNode tail;       // Referência ao final da lista de ações
    private ActionNode current;    // Posição atual na lista de ações (para desfazer/refazer)
    private StringBuilder text;    // Texto atual

    // Construtor
    public TextEditor() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.text = new StringBuilder();  // Texto inicial vazio
    }

    // Adiciona texto ao editor
    public void addText(String content) {
        ActionNode newNode = new ActionNode("adicionar", content);

        // Adiciona a nova ação ao final da lista
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        current = tail;  // Atualiza a posição atual
        text.append(content);  // Atualiza o texto com o novo conteúdo
        System.out.println("Texto adicionado: " + content);
    }

    // Desfaz a última ação
    public void undo() {
        if (current == null) {
            System.out.println("Nenhuma ação para desfazer.");
            return;
        }

        // Desfaz a última ação adicionada
        if (current.action.equals("adicionar")) {
            int length = current.content.length();
            text.delete(text.length() - length, text.length());
            System.out.println("Desfeita a ação de adicionar: " + current.content);
        } else if (current.action.equals("remover")) {
            text.append(current.content);
            System.out.println("Desfeita a ação de remover: " + current.content);
        }

        // Move o ponteiro para o nó anterior
        if (current.prev != null) {
            current = current.prev;
        } else {
            current = null; // Se não há ações anteriores, define current como null
        }
    }

    // Refaz a última ação desfeita
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nenhuma ação para refazer.");
            return;
        }

        // Move para o próximo nó e refaz a ação
        current = current.next;

        if (current.action.equals("adicionar")) {
            text.append(current.content);
            System.out.println("Refeita a ação de adicionar: " + current.content);
        } else if (current.action.equals("remover")) {
            int length = current.content.length();
            text.delete(text.length() - length, text.length());
            System.out.println("Refeita a ação de remover: " + current.content);
        }
    }

    // Exibe o texto atual
    public void showText() {
        System.out.println("\nTexto atual: " + text.toString());
    }
}
