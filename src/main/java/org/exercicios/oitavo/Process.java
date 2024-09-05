package org.exercicios.oitavo;

/**
 * @param pid         Identificador único do processo (PID)
 * @param description Descrição do processo
 */
public record Process(int pid, String description) {
    // Construtor

    // Método para exibir as informações do processo
    public void printInfo() {
        System.out.println("Processo PID: " + pid + ", Descrição: " + description);
    }
}
