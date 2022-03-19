package controller;

import static boot.GUIComponentEvent.*;

import controller.component.ComponentController;
import controller.file.FileController;
import controller.text.DataController;
import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.Readable;
import interfaces.entity.gui.CurrentRequest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final static ComponentController componentController = new ComponentController();
    private final static DataController dataController = new DataController();
    private final static FileController fileController = new FileController();

    public void register(Readable<String> entry) throws UnsupportedComponentException {
        if(!(entry instanceof CurrentRequest)) dataController.register(entry);
        if (entry instanceof Changeable) componentController.register((Changeable<String>) entry);
    }

    private void addRequestToKeywords() {
        componentController.addRequestToKeywords();
    }

    private void addRequestToSearchRequests() {
        componentController.addRequestToSearchRequests();
    }

    private void removeLastKeyword() {
        componentController.removeLastKeyword();
    }

    private void removeLastSearchRequest() {
        componentController.removeLastSearchRequest();
    }

    private void removeAllKeywords() {
        componentController.removeAllKeywords();
    }

    private void removeAllSearchRequests() {
        componentController.removeAllSearchRequest();
    }

    private void cleanRequestField() {
        componentController.cleanRequestField();
    }

    private void printToCL(){ System.out.println(dataController.getWebPage()); }

    private void saveFile(){
        fileController.saveFileAsHtml(dataController.getWebPage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ADD_TO_SEARCH_REQUESTS: addRequestToSearchRequests();
            break;
            case ADD_TO_KEYWORDS: addRequestToKeywords();
            break;
            case REMOVE_LAST_SEARCH_REQUEST: removeLastSearchRequest();
            break;
            case REMOVE_LAST_KEYWORD: removeLastKeyword();
            break;
            case SAVE: saveFile();
            break;
            case REMOVE_ALL_KEYWORDS: removeAllKeywords();
            break;
            case REMOVE_ALL_SEARCH_REQUESTS: removeAllSearchRequests();
            break;
            case CLEAN_REQUEST_FIELD: cleanRequestField();
            break;
            case PRINT_TO_CL: printToCL();
            break;
        }
    }
}
