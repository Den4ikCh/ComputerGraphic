package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import javax.swing.*;

public class Main extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel paintArea;
    private DrawPanel dp;

    public Main() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        dp = new DrawPanel();
        paintArea.add(dp);
    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
