package gui.panel;

import boot.GUIComponentParameter;
import controller.Controller;
import exception.UnsupportedComponentException;
import interfaces.entity.gui.MainText;

import javax.swing.*;

public class TextPanel extends JTabbedPane implements MainText {
    private final JTextArea textArea;

    {
        textArea = new JTextArea();
    }

    public TextPanel() {
        setName("Основной текст");
        setPreferredSize(GUIComponentParameter.textPanelDimension());
        setBackground(GUIComponentParameter.textPanelColor);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea));
        register();
    }

    private void register() {
        try {
            new Controller().register(this);
        } catch (UnsupportedComponentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getSourceName() {
        return getName();
    }

    @Override
    public String getData() {
        return textArea.getText();
    }
}
