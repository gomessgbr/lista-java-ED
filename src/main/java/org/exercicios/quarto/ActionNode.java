package org.exercicios.quarto;

public class ActionNode {
    String action;     // Tipo de ação (adicionar/remover)
    String content;    // Conteúdo associado à ação
    ActionNode prev;   // Referência para o nó anterior
    ActionNode next;   // Referência para o próximo nó

    public ActionNode(String action, String content) {
        this.action = action;
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
