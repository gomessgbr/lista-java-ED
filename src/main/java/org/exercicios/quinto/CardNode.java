package org.exercicios.quinto;

public class CardNode {
    String card;      // Valor da carta (por exemplo, "Ás de Espadas", "Rei de Copas")
    CardNode prev;    // Referência para o nó anterior
    CardNode next;    // Referência para o próximo nó

    // Construtor
    public CardNode(String card) {
        this.card = card;
        this.prev = null;
        this.next = null;
    }
}
