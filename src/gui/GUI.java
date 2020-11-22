package gui;

import gui.Tree;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI {
    private final JDialog mainDialog;
    private final JComboBox<Tree> treeSelector;

    private boolean started;

    public GUI() {
        mainDialog = new JDialog();
        mainDialog.setTitle("Select tree type");
        mainDialog.setModal(true);
        mainDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainDialog.getContentPane().add(mainPanel);

        JPanel treeSelectionPanel = new JPanel();
        treeSelectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel treeSelectionLabel = new JLabel("Select tree:");
        treeSelectionPanel.add(treeSelectionLabel);

        treeSelector = new JComboBox<>(Tree.values());
        treeSelectionPanel.add(treeSelector);

        mainPanel.add(treeSelectionPanel);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            started = true;
            close();
        });
        mainPanel.add(startButton);

        mainDialog.pack();
    }

    public boolean isStarted() {
        return started;
    }

    public Tree getSelectedTree() {
        return (Tree) treeSelector.getSelectedItem();
    }

    public void open() {
        mainDialog.setVisible(true);
    }

    public void close() {
        mainDialog.setVisible(false);
        mainDialog.dispose();
    }
}
