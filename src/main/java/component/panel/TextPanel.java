package component.panel;

import boot.GUIComponentParameter;
import form.Readable;

import javax.swing.*;

public class TextPanel extends JTabbedPane implements Readable {
    private final JTextArea textArea;

    public TextPanel() {
        setPreferredSize(GUIComponentParameter.textPanelDimension());
        setBackground(GUIComponentParameter.textPanelColor);
        add(new JScrollPane(textArea));
    }

    @Override
    public String readText() {
        return null;
    }

    {
        textArea = new JTextArea();
    }
}
