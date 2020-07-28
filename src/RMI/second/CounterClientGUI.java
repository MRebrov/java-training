package RMI.second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CounterClientGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    protected Counter counter;
    protected JLabel counterLabel;

    public CounterClientGUI(final Counter counter) {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.counter = counter;
        this.counterLabel = new JLabel("0", SwingConstants.CENTER);
        final JButton incrementButton = new JButton("Plus");
        final JButton resetButton = new JButton("Reset");

        incrementButton.addActionListener(this::incrementClicked);
        resetButton.addActionListener(this::resetClicked);

        this.setLayout(new GridLayout(0, 1));
        this.add(this.counterLabel);
        this.add(incrementButton);
        this.add(resetButton);
        this.setSize(300, 200);
        this.setVisible(true);
    }

    protected void incrementClicked(final ActionEvent ev) {
        new Thread(this::incrementOnGUI).start();
    }

    protected void resetClicked(final ActionEvent ev) {
        new Thread(this::resetOnGUI).start();
    }

    protected void incrementOnGUI() {
        try {
            final int doAndGetIncrement = this.counter.increment();
            final String newLabelText = String.valueOf(doAndGetIncrement);
            EventQueue.invokeLater(() -> this.counterLabel.setText(newLabelText));
        } catch (final RemoteException ex) {
            final String message = "Error: " + ex.getMessage();
            EventQueue.invokeLater(() -> JOptionPane.showMessageDialog(this, message));
        }
    }

    protected void resetOnGUI() {
        try {
            final int doAndGetReset = this.counter.reset();
            final String newLabelText = String.valueOf(doAndGetReset);
            EventQueue.invokeLater(() -> this.counterLabel.setText(newLabelText));
        } catch (final RemoteException ex) {
            final String message = "Error: " + ex.getMessage();
            EventQueue.invokeLater(() -> JOptionPane.showMessageDialog(this, message));
        }
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost");
        Counter counter = (Counter) reg.lookup(Counter.NAME);

        new CounterClientGUI(counter);
    }

}
