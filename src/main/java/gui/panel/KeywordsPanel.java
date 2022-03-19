package gui.panel;

import interfaces.entity.gui.Keywords;

import java.awt.*;

public class KeywordsPanel extends RequestPanel implements Keywords {
    protected void initialize() {
        setName("Ключевые слова");
        setBackground(Color.RED);
    }
}
