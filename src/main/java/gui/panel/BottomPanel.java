package gui.panel;

import boot.GUIComponentParameter;
import controller.Controller;
import exception.UnsupportedComponentException;
import interfaces.Changeable;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel implements Changeable<String> {
    private final String EMPTY_TEXT = "";
    private final JTextField textField = new JTextField();
    private final JLabel label = new JLabel("REQUEST");

    public BottomPanel() {
        setPreferredSize(GUIComponentParameter.bottomPanelDimension());
        setMaximumSize(new Dimension(GUIComponentParameter.screenDimension.width, GUIComponentParameter.bottomPanelDimension().height));
        setBackground(GUIComponentParameter.bottomPanelColor);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        textField.setFont(new Font("Default", Font.PLAIN, 24));
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setFont(new Font("Default", Font.PLAIN, 18));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label);
        add(textField);
        register();
        revalidate();
        repaint();
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
        return textField.getText();
    }


    @Override
    public void setData(String data) {
    }

    @Override
    public void removeLast() {
        this.removeAll();
    }

    @Override
    public void removeAll() {
        textField.setText(EMPTY_TEXT);
    }
}
