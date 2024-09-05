package org.exercicios.segundo;

public class URLNode {
    String url;   // URL armazenada no nó
    URLNode next; // Referência para o próximo nó (próxima URL)


    public URLNode(String url) {
        this.url = url;
        this.next = null;
    }
}
