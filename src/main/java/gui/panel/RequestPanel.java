package gui.panel;

import controller.Controller;
import exception.UnsupportedComponentException;
import interfaces.Changeable;

import javax.swing.*;
import java.util.Stack;

public abstract class RequestPanel extends JPanel implements Changeable<String> {
    private final Stack<JComponent> requests;

    {
        requests = new Stack<>();
    }

    public RequestPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        register();
        initialize();
    }

    private void register() {
        try {
            new Controller().register(this);
        } catch (UnsupportedComponentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeLast() {
        if (!requests.empty()) {
            remove(requests.pop());
        }
        revalidate();
        repaint();
    }

    @Override
    public void removeAll() {
        requests.forEach(this::remove);
        requests.clear();
        revalidate();
        repaint();
    }

    @Override
    public String getSourceName() {
        return getName();
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

    protected abstract void initialize();
}
