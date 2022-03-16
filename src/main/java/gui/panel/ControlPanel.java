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

        JButton getTextFromText = new JButton("getTextFromText");
        getTextFromText.addActionListener(l -> System.out.println(Controller.getController().getCurrentText()));
        buttonList.add(getTextFromText);
        JButton getTextFromRequest = new JButton("getTextFromRequest");
        getTextFromRequest.addActionListener(l -> System.out.println(Controller.getController().getCurrentRequest()));
        buttonList.add(getTextFromRequest);
        JButton getTextFromKeywords = new JButton("getTextFromKeywords");
        getTextFromKeywords.addActionListener(l -> System.out.println(Controller.getController().getCurrentKeys()));
        buttonList.add(getTextFromKeywords);
        JButton getTextFromSearch = new JButton("getTextFromSearch");
        getTextFromSearch.addActionListener(l -> System.out.println(Controller.getController().getCurrentSearchRequests()));
        buttonList.add(getTextFromSearch);
        JButton checkIsInitialised = new JButton("checkIsInitialised");
        checkIsInitialised.addActionListener(l -> System.out.println("is initialised " + Controller.getController().isInitialised()));
        buttonList.add(checkIsInitialised);


        for(JButton button : buttonList){
            button.setPreferredSize(new Dimension(GUIComponentParameter.controlPanelDimension().width / 2 - 7, GUIComponentParameter.controlPanelDimension().height / 3 - 7));
            add(button);
        }
    }
}
