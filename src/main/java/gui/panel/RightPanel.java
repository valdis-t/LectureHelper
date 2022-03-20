package gui.panel;

import boot.GUIComponentParameter;
import util.TextFormatterForGUIComponent;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JTabbedPane {
    public RightPanel() {
        super(JTabbedPane.LEFT);
        setPreferredSize(GUIComponentParameter.rightPanelDimension());
        setMaximumSize(new Dimension(GUIComponentParameter.rightPanelDimension().width, GUIComponentParameter.screenDimension.height));
        setBackground(GUIComponentParameter.rightPanelColor);
        initializeTabs();
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private void initializeTabs() {
        JPanel keywordsPanel = new KeywordsPanel();
        add(new JScrollPane(new KeywordsPanel()), TextFormatterForGUIComponent.getDoubleColumnedVerticalText(keywordsPanel.getName()));

        JPanel searchRequestsPanel = new SearchRequestPanel();
        add(new JScrollPane(searchRequestsPanel), TextFormatterForGUIComponent.getDoubleColumnedVerticalText(searchRequestsPanel.getName()));

    }
}
