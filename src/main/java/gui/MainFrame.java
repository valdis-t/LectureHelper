package gui;

import boot.GUIComponentParameter;
import gui.panel.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JPanel rootPanel;
    private final JPanel textPanel;
    private final JTabbedPane searchRequestAndKeywordPanel;
    private final JPanel controlPanel;
    private final JPanel bottomPanel;

    {
        rootPanel = new RootPanel();
        textPanel = new TextPanel();
        searchRequestAndKeywordPanel = new RightPanel();
        controlPanel = new ControlPanel();
        bottomPanel = new BottomPanel();
    }

    public MainFrame() {
        super("LectureHelper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel textPlusBottomPanel = new JPanel();
        textPlusBottomPanel.setBackground(Color.black);
        textPlusBottomPanel.setLayout(new BoxLayout(textPlusBottomPanel, BoxLayout.Y_AXIS));
        textPlusBottomPanel.add(textPanel);
        textPlusBottomPanel.add(bottomPanel);

        JPanel requestsPlusControlPanel = new JPanel();
        requestsPlusControlPanel.setLayout(new BoxLayout(requestsPlusControlPanel, BoxLayout.Y_AXIS));
        requestsPlusControlPanel.add(searchRequestAndKeywordPanel);
        requestsPlusControlPanel.add(controlPanel);

        rootPanel.add(textPlusBottomPanel);
        rootPanel.add(requestsPlusControlPanel);
        add(rootPanel);
        pack();
        setMinimumSize(this.getSize());
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
