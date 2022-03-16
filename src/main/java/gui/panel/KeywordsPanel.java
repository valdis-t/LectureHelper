package gui.panel;

import controller.Controller;
import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.Readable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KeywordsPanel extends JPanel implements Readable<String>, Changeable<String> {
    private final List<JComponent> requests;

    {
        requests = new ArrayList<>();
    }

    public KeywordsPanel() {
        super();
        initialize();
        register();
    }

    private void initialize() {
        mockRequests();
        setName("KEYWORDS");
        setBackground(Color.RED);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        for (JComponent component : requests) add(component);
    }

    private void register() {
        try {
            Controller.getController().registerComponent(this);
        } catch (UnsupportedComponentException e) {
            e.printStackTrace();
        }
    }

    private void mockRequests() {
        for (int k = 0; k < 20; k++) requests.add(new JLabel("ключевое слово №" + k + " из " + this.getName()));
    }

    @Override
    public String getData() {
        StringBuilder builder = new StringBuilder();
        for (JComponent component : requests) {
            builder.append(((JLabel) component).getText());
            builder.append("/n");
        }
        return builder.toString();
    }

    @Override
    public void setData(String data) {

    }
}
