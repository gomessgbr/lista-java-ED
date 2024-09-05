package org.exercicios.terceiro;

public class ActionNode {
    String action; // Ação realizada (adicionar/remover)
    String content; // Conteúdo associado à ação
    ActionNode next; // Próxima ação


    public ActionNode(String action, String content) {
        this.action = action;
        this.content = content;
        this.next = null;
    }
}
