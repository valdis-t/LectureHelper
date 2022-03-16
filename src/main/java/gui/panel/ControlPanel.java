package gui.panel;

import boot.GUIComponentParameter;
import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        setPreferredSize(GUIComponentParameter.controlPanelDimension());
        setMaximumSize(GUIComponentParameter.controlPanelDimension());
        setBackground(GUIComponentParameter.controlPanelColor);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        initializeButtons();
    }

    private void initializeButtons() {
        for (int i = 0; i <= 6; ++i) {
            JButton button = new JButton("button " + i);
            button.setPreferredSize(new Dimension(GUIComponentParameter.controlPanelDimension().width / 2 - 7, GUIComponentParameter.controlPanelDimension().height / 3 - 7));
            add(button);
            button.addActionListener(l -> System.out.println(Controller.getController().isInitialised()));
        }
    }
}
