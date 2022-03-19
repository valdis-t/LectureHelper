package gui.panel;

import interfaces.entity.gui.SearchRequests;

import java.awt.*;

public class SearchRequestPanel extends RequestPanel implements SearchRequests {
    protected void initialize() {
        setName("SEARCH REQUESTS");
        setBackground(Color.CYAN);
    }
}
