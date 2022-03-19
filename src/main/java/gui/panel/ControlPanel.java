package gui.panel;

import static boot.GUIComponentEvent.*;

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

        JButton addRequestToKeywords = new JButton("addRequestToKeywords");
        addRequestToKeywords.setActionCommand(ADD_TO_KEYWORDS);
        buttonList.add(addRequestToKeywords);

        JButton addRequestToSearchRequests = new JButton("addRequestToSearchRequests");
        addRequestToSearchRequests.setActionCommand(ADD_TO_SEARCH_REQUESTS);
        buttonList.add(addRequestToSearchRequests);

        JButton removeLastKeyword = new JButton("removeLastKeyword");
        removeLastKeyword.setActionCommand(REMOVE_LAST_KEYWORD);
        buttonList.add(removeLastKeyword);

        JButton removeLastSearchRequest = new JButton("removeLastSearchRequest");
        removeLastSearchRequest.setActionCommand(REMOVE_LAST_SEARCH_REQUEST);
        buttonList.add(removeLastSearchRequest);

        JButton removeAllKeyword = new JButton("removeAllKeyword");
        removeAllKeyword.setActionCommand(REMOVE_ALL_KEYWORDS);
        buttonList.add(removeAllKeyword);

        JButton removeAllSearchRequest = new JButton("removeAllSearchRequest");
        removeAllSearchRequest.setActionCommand(REMOVE_ALL_SEARCH_REQUESTS);
        buttonList.add(removeAllSearchRequest);

        JButton cleanRequestField = new JButton("cleanRequestField");
        cleanRequestField.setActionCommand(CLEAN_REQUEST_FIELD);
        buttonList.add(cleanRequestField);

        JButton saveFile = new JButton("save file");
        saveFile.setActionCommand(SAVE);
        buttonList.add(saveFile);
//
//        JButton saveAs = new JButton("save as");
//        buttonList.add(saveAs);
//        saveAs.addActionListener(l -> Controller.saveAs());

        JButton printToCL = new JButton("print");
        printToCL.setActionCommand(PRINT_TO_CL);
        buttonList.add(printToCL);

        for (JButton button : buttonList) {
            button.setPreferredSize(new Dimension(GUIComponentParameter.controlPanelDimension().width / 2 - 7, GUIComponentParameter.controlPanelDimension().height / 5 - 7));
            button.addActionListener(new Controller());
            add(button);
        }
    }
}
