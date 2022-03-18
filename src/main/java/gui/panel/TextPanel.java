package gui.panel;

import boot.GUIComponentParameter;
import controller.Controller;
import exception.UnsupportedComponentException;
import interfaces.Readable;
import interfaces.entity.MainText;

import javax.swing.*;

public class TextPanel extends JTabbedPane implements MainText {
    private final JTextArea textArea;

    {
        textArea = new JTextArea();
    }

    public TextPanel() {
        setPreferredSize(GUIComponentParameter.textPanelDimension());
        setBackground(GUIComponentParameter.textPanelColor);
        add(new JScrollPane(textArea));
        register();
    }

    private void register() {
        try {
            Controller.register(this);
        } catch (UnsupportedComponentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData() {
        return textArea.getText();
    }
}
