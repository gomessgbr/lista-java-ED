package org.exercicios.setimo;
import java.util.LinkedList;
import java.util.Queue;


public class PrintQueue {
    private Queue<PrintJob> printQueue;  // Fila de trabalhos de impressão

    // Construtor
    public PrintQueue() {
        this.printQueue = new LinkedList<>();
    }

    // Adiciona um trabalho de impressão à fila
    public void addPrintJob(String documentName, int pages) {
        PrintJob newJob = new PrintJob(documentName, pages);
        printQueue.add(newJob);
        System.out.println("Trabalho de impressão adicionado: " + documentName + " (" + pages + " páginas)");
    }

    // Processa o próximo trabalho de impressão na fila
    public void processNextJob() {
        if (printQueue.isEmpty()) {
            System.out.println("Nenhum trabalho de impressão na fila.");
        } else {
            PrintJob nextJob = printQueue.poll();  // Remove e obtém o primeiro trabalho da fila
            System.out.println("Processando o próximo trabalho de impressão:");
            nextJob.printInfo();  // Exibe as informações do trabalho de impressão
        }
    }

    // Exibe os trabalhos de impressão na fila
    public void showQueue() {
        if (printQueue.isEmpty()) {
            System.out.println("A fila de impressão está vazia.");
        } else {
            System.out.println("\nFila de Impressão:");
            for (PrintJob job : printQueue) {
                job.printInfo();  // Exibe as informações do trabalho de impressão
            }
        }
    }
}
