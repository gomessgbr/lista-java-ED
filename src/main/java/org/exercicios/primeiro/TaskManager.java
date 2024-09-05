package org.exercicios.primeiro;

public class TaskManager {
    Task head;

    public void addTask(String description) {
        Task newTask = new Task(description);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Tarefa adicionada: " + description);
    }

    public void removeTask(String description) {
        if (head == null) {
            System.out.println("Lista de tarefas vazia.");
            return;
        }

        if (head.description.equals(description)) {
            head = head.next;
            System.out.println("Tarefa removida: " + description);
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.description.equals(description)) {
                current.next = current.next.next;
                System.out.println("Tarefa removida: " + description);
                return;
            }
            current = current.next;
        }

        System.out.println("Tarefa não encontrada: " + description);
    }

    public void markTaskAsCompleted(String description) {
        Task current = head;
        while (current != null) {
            if (current.description.equals(description)) {
                current.isCompleted = true;
                System.out.println("Tarefa marcada como concluída: " + description);
                return;
            }
            current = current.next;
        }
        System.out.println("Tarefa não encontrada: " + description);
    }

    public void listTasks() {
        if (head == null) {
            System.out.println("Lista de tarefas vazia.");
            return;
        }

        Task current = head;
        while (current != null) {
            String status = current.isCompleted ? " (Concluída)" : " (Pendente)";
            System.out.println(current.description + status);
            current = current.next;
        }
    }
}
