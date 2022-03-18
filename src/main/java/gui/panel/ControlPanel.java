package gui.panel;

import boot.GUIComponentParameter;
import controller.Controller;
import controller.TextController;

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

        JButton addRequestToKeywords = new JButton("addRequestToKeywords");
        buttonList.add(addRequestToKeywords);
        addRequestToKeywords.addActionListener(l -> Controller.addRequestToKeywords());

        JButton addRequestToSearchRequests = new JButton("addRequestToSearchRequests");
        buttonList.add(addRequestToSearchRequests);
        addRequestToSearchRequests.addActionListener(l -> Controller.addRequestToSearchRequests());

        JButton removeLastKeyword = new JButton("removeLastKeyword");
        buttonList.add(removeLastKeyword);
        removeLastKeyword.addActionListener(l -> Controller.removeLastKeyword());

        JButton removeLastSearchRequest = new JButton("removeLastSearchRequest");
        buttonList.add(removeLastSearchRequest);
        removeLastSearchRequest.addActionListener(l -> Controller.removeLastSearchRequest());

        JButton removeAllKeyword = new JButton("removeAllKeyword");
        buttonList.add(removeAllKeyword);
        removeAllKeyword.addActionListener(l -> Controller.removeAllKeywords());

        JButton removeAllSearchRequest = new JButton("removeAllSearchRequest");
        buttonList.add(removeAllSearchRequest);
        removeAllSearchRequest.addActionListener(l -> Controller.removeAllSearchRequests());

        JButton cleanRequestField = new JButton("cleanRequestField");
        buttonList.add(cleanRequestField);
        cleanRequestField.addActionListener(l -> Controller.cleanRequestField());

        JButton saveFile = new JButton("save file");
        buttonList.add(saveFile);
        saveFile.addActionListener(l -> Controller.saveFile());

        JButton saveAs = new JButton("save as");
        buttonList.add(saveAs);
        saveAs.addActionListener(l -> Controller.saveAs());

        JButton printToCL = new JButton("print");
        buttonList.add(printToCL);
        printToCL.addActionListener(l -> Controller.printToCL());

        for (JButton button : buttonList) {
            button.setPreferredSize(new Dimension(GUIComponentParameter.controlPanelDimension().width / 2 - 7, GUIComponentParameter.controlPanelDimension().height / 5 - 7));
            add(button);
        }
    }
}
