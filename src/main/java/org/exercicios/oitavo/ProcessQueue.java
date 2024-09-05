package org.exercicios.oitavo;
import java.util.LinkedList;
import java.util.Queue;

public class ProcessQueue {
    private final Queue<Process> processQueue;  // Fila de processos
    private int processIdCounter;         // Contador de PIDs

    // Construtor
    public ProcessQueue() {
        this.processQueue = new LinkedList<>();
        this.processIdCounter = 1;  // PID inicial
    }

    // Adiciona um processo à fila
    public void addProcess(String description) {
        Process newProcess = new Process(processIdCounter, description);
        processQueue.add(newProcess);
        System.out.println("Processo adicionado: PID " + newProcess.pid() + " (" + newProcess.description() + ")");
        processIdCounter++;
    }

    // Executa o processo mais antigo (primeiro na fila)
    public void executeNextProcess() {
        if (processQueue.isEmpty()) {
            System.out.println("Nenhum processo na fila.");
        } else {
            Process nextProcess = processQueue.poll();  // Remove e obtém o primeiro processo
            System.out.println("Executando o próximo processo:");
            nextProcess.printInfo();  // Exibe as informações do processo
        }
    }

    // Exibe a fila de processos
    public void showQueue() {
        if (processQueue.isEmpty()) {
            System.out.println("A fila de processos está vazia.");
        } else {
            System.out.println("\nFila de Processos:");
            for (Process process : processQueue) {
                process.printInfo();  // Exibe as informações de cada processo
            }
        }
    }
}
