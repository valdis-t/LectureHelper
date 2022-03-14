package component.panel;

import boot.GUIComponentParameter;
import form.Readable;
import util.TextFormatterForGUIComponent;

import javax.swing.*;
import java.awt.*;

public class SearchRequestAndKeywordPanel extends JTabbedPane implements Readable {
    public SearchRequestAndKeywordPanel() {
        super(JTabbedPane.LEFT);
        setPreferredSize(GUIComponentParameter.rightPanelDimension());
        setMaximumSize(new Dimension(GUIComponentParameter.rightPanelDimension().width, GUIComponentParameter.screenDimension.height));
        setBackground(GUIComponentParameter.rightPanelColor);
        initializeTabs();
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

    }

    private void initializeTabs() {
        /*
        initialization of keywords panel
         */
        JPanel keywordsPanel = new JPanel();
        keywordsPanel.setName("KEYWORDS");
        keywordsPanel.setBackground(Color.yellow);
        keywordsPanel.setLayout(new BoxLayout(keywordsPanel, BoxLayout.PAGE_AXIS));
        for (int k = 0; k < 20; k++)
            keywordsPanel.add(new JLabel("ключевое слово №" + k + " из " + keywordsPanel.getName()));
        add(new JScrollPane(keywordsPanel), TextFormatterForGUIComponent.getVerticalText(keywordsPanel.getName()));

        /*
        initialization of search request
         */
        JPanel searchRequestsPanel = new JPanel();
        searchRequestsPanel.setName("SEARCH REQUESTS");
        keywordsPanel.setBackground(Color.CYAN);
        searchRequestsPanel.setLayout(new BoxLayout(searchRequestsPanel, BoxLayout.PAGE_AXIS));
        for (int k = 0; k < 20; k++)
            searchRequestsPanel.add(new JLabel("поисковый запрос №" + k + " из " + searchRequestsPanel.getName()));
        add(new JScrollPane(searchRequestsPanel), TextFormatterForGUIComponent.getVerticalText(searchRequestsPanel.getName()));
    }

    @Override
    public String readText() {
        return null;
    }
}
