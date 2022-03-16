package component.panel;

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
        mockRequests();
        setName("SEARCH REQUESTS");
        setBackground(Color.CYAN);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        for (JComponent component : requests) add(component);
    }

    private void mockRequests() {
        for (int k = 0; k < 20; k++) requests.add(new JLabel("поисковый запрос №" + k + " из " + this.getName()));
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
