package org.exercicios.primeiro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- Gerenciador de Tarefas ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Marcar tarefa como concluída");
            System.out.println("3. Remover tarefa");
            System.out.println("4. Listar tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa a linha após a leitura do número

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    taskManager.addTask(descricao);
                    break;
                case 2:
                    System.out.print("Digite a descrição da tarefa a marcar como concluída: ");
                    String tarefaConcluir = scanner.nextLine();
                    taskManager.markTaskAsCompleted(tarefaConcluir);
                    break;
                case 3:
                    System.out.print("Digite a descrição da tarefa a remover: ");
                    String tarefaRemover = scanner.nextLine();
                    taskManager.removeTask(tarefaRemover);
                    break;
                case 4:
                    System.out.println("\nTarefas:");
                    taskManager.listTasks();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
