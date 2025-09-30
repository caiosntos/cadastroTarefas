package com.mycompany.cadastroTarefas;

public class Main {

    /**
     * Método principal.
     *
     * @param args argumentos da linha de comando.
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new com.mycompany.cadastroTarefas.View.MainView().setVisible(true);
        });
    }
}
