package gui.panel;

import controller.Controller;
import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.Readable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchRequestPanel extends JPanel implements Readable<String>, Changeable<String> {
    private final List<JComponent> requests;

    {
        requests = new ArrayList<>();
    }

    public SearchRequestPanel() {
        super();
        initialize();
        register();
    }

    private void register() {
        try {
            Controller.getController().registerComponent(this);
        } catch (UnsupportedComponentException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        setName("SEARCH REQUESTS");
        setBackground(Color.CYAN);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        for (JComponent component : requests) add(component);
    }

    @Override
    public String getData() {
        StringBuilder builder = new StringBuilder();
        for (JComponent component : requests) {
            builder.append(((JLabel) component).getText());
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public void setData(String data) {
        JLabel label = new JLabel(data);
        requests.add(label);
        add(label);
        revalidate();
    }
}
