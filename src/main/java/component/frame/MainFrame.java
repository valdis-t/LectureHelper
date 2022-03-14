package component.frame;

import boot.GUIComponentParameter;
import component.panel.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JPanel rootPanel;
    private final JTabbedPane textPanel;
    private final JTabbedPane searchRequestAndKeywordPanel;
    private final JPanel controlPanel;
    private final JPanel bottomPanel;

    {
        rootPanel = new RootPanel();
        textPanel = new TextPanel();
        searchRequestAndKeywordPanel = new SearchRequestAndKeywordPanel();
        controlPanel = new ControlPanel();
        bottomPanel = new BottomPanel();
    }

    public MainFrame() {
        super("LectureHelper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel textPlusBottonPanel = new JPanel();
        textPlusBottonPanel.setBackground(Color.black);
        textPlusBottonPanel.setLayout(new BoxLayout(textPlusBottonPanel, BoxLayout.Y_AXIS));
        textPlusBottonPanel.add(textPanel);
        textPlusBottonPanel.add(bottomPanel);

        JPanel requestsPlusControlPanel = new JPanel();
        requestsPlusControlPanel.setLayout(new BoxLayout(requestsPlusControlPanel, BoxLayout.Y_AXIS));
        requestsPlusControlPanel.add(searchRequestAndKeywordPanel);
        requestsPlusControlPanel.add(controlPanel);

        rootPanel.add(textPlusBottonPanel);
        rootPanel.add(requestsPlusControlPanel);
        add(rootPanel);
        pack();
        setMinimumSize(this.getSize());
        setVisible(true);
    }

    private void testPanel(JPanel panel) {
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(GUIComponentParameter.rightPanelDimension().width - 15, GUIComponentParameter.rightPanelDimension().height - 500));
        panel.add(new JScrollPane(textArea));
        panel.validate();
        textArea.setColumns(20);
        textArea.setRows(2);
    }
}
