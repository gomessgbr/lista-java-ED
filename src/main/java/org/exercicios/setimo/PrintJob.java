package org.exercicios.setimo;

public class PrintJob {
    private String documentName;   // Nome do documento
    private int pages;             // Número de páginas a serem impressas

    // Construtor
    public PrintJob(String documentName, int pages) {
        this.documentName = documentName;
        this.pages = pages;
    }

    // Métodos para obter os dados do trabalho de impressão
    public String getDocumentName() {
        return documentName;
    }

    public int getPages() {
        return pages;
    }

    // Método para exibir as informações do trabalho de impressão
    public void printInfo() {
        System.out.println("Documento: " + documentName + ", Páginas: " + pages);
    }
}
