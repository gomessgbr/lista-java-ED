package org.exercicios.sexto;

public class Client {
    private String name;   // Nome do cliente
    private int id;        // ID do cliente (número de atendimento)

    // Construtor
    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Métodos para obter os dados do cliente
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Método para exibir as informações do cliente sem usar o toString()
    public void printInfo() {
        System.out.println("Cliente " + id + ": " + name);
    }
}
