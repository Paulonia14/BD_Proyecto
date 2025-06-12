package ar.edu.uncuyo.main;

import ar.edu.uncuyo.view.AdminPanelForm;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new AdminPanelForm().setVisible(true);
        });
    }
}
