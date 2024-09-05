package org.exercicios.sexto;

import java.util.LinkedList;
import java.util.Queue;

public class BankQueue {
    private Queue<Client> clientQueue;  // Fila de clientes
    private int clientIdCounter;        // Contador de IDs dos clientes

    // Construtor
    public BankQueue() {
        this.clientQueue = new LinkedList<>();
        this.clientIdCounter = 1;  // O ID dos clientes começa em 1
    }

    // Adiciona um cliente à fila
    public void addClient(String name) {
        Client newClient = new Client(name, clientIdCounter);
        clientQueue.add(newClient);
        System.out.println("Cliente " + newClient.getId() + ": " + newClient.getName() + " entrou na fila.");
        clientIdCounter++;
    }

    // Chama o próximo cliente para atendimento
    public void callNextClient() {
        if (clientQueue.isEmpty()) {
            System.out.println("Nenhum cliente na fila.");
        } else {
            Client nextClient = clientQueue.poll();  // Remove e obtém o primeiro cliente
            System.out.println("Chamando o próximo cliente:");
            nextClient.printInfo();  // Exibe as informações do cliente
        }
    }

    // Exibe a fila de clientes
    public void showQueue() {
        if (clientQueue.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("\nFila de Clientes:");
            for (Client client : clientQueue) {
                client.printInfo();  // Exibe as informações do cliente
            }
        }
    }
}
