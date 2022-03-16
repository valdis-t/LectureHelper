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
        add(new JScrollPane(new KeywordsPanel()), TextFormatterForGUIComponent.getVerticalText(keywordsPanel.getName()));

        JPanel searchRequestsPanel = new SearchRequestPanel();
        add(new JScrollPane(searchRequestsPanel), TextFormatterForGUIComponent.getVerticalText(searchRequestsPanel.getName()));

        JPanel imagesPanel = new ImagePanel();
        imagesPanel.setName("IMAGES");
        add(new JScrollPane(imagesPanel), TextFormatterForGUIComponent.getVerticalText(imagesPanel.getName()));
    }
}
