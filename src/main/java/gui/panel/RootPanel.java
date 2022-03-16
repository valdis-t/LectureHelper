package gui.panel;

import boot.GUIComponentParameter;

import javax.swing.*;
import java.awt.*;

public class RootPanel extends JPanel {
    public RootPanel() {
        setPreferredSize(GUIComponentParameter.rootPanelDimension());
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.black);
    }
}
