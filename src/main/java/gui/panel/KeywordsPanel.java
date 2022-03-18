package gui.panel;

import interfaces.entity.Keywords;

import java.awt.*;

public class KeywordsPanel extends RequestPanel implements Keywords {
    protected void initialize() {
        setName("KEYWORDS");
        setBackground(Color.RED);
    }
}
