package gui.panel;

import boot.GUIComponentParameter;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        setPreferredSize(GUIComponentParameter.controlPanelDimension());
        setMaximumSize(GUIComponentParameter.controlPanelDimension());
        setBackground(GUIComponentParameter.controlPanelColor);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        initializeButtons();
    }

    private void initializeButtons() {
        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton getTextFromText = new JButton("from text");
        getTextFromText.addActionListener(l -> System.out.println(Controller.getController().getCurrentText()));
        buttonList.add(getTextFromText);

        JButton getTextFromRequest = new JButton("from request");
        getTextFromRequest.addActionListener(l -> System.out.println(Controller.getController().getCurrentRequest()));
        buttonList.add(getTextFromRequest);

        JButton getTextFromKeywords = new JButton("from keywords");
        getTextFromKeywords.addActionListener(l -> System.out.println(Controller.getController().getCurrentKeys()));
        buttonList.add(getTextFromKeywords);

        JButton getTextFromSearch = new JButton("from searchs");
        getTextFromSearch.addActionListener(l -> System.out.println(Controller.getController().getCurrentSearchRequests()));
        buttonList.add(getTextFromSearch);

        JButton sendRequestToKeywords = new JButton("to keys");
        sendRequestToKeywords.addActionListener(l -> Controller.getController().addKeyword());
        buttonList.add(sendRequestToKeywords);

        JButton sendRequestToSearchRequest = new JButton("to searchs");
        sendRequestToSearchRequest.addActionListener(l -> Controller.getController().addSearchRequest());
        buttonList.add(sendRequestToSearchRequest);

        for(JButton button : buttonList){
            button.setPreferredSize(new Dimension(GUIComponentParameter.controlPanelDimension().width / 2 - 7, GUIComponentParameter.controlPanelDimension().height / 4 - 7));
            add(button);
        }
    }
}
