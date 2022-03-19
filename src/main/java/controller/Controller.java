package controller;

import controller.component.ComponentController;
import controller.file.FileController;
import controller.text.DataController;
import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.Readable;
import interfaces.entity.gui.CurrentRequest;

public class Controller {
    private final static ComponentController componentController = new ComponentController();
    private final static DataController dataController = new DataController();
    private final static FileController fileController = new FileController();

    public void register(Readable<String> entry) throws UnsupportedComponentException {
        if(!(entry instanceof CurrentRequest)) dataController.register(entry);
        if (entry instanceof Changeable) componentController.register((Changeable<String>) entry);
    }

    public static void addRequestToKeywords() {
        componentController.addRequestToKeywords();
    }

    public static void addRequestToSearchRequests() {
        componentController.addRequestToSearchRequests();
    }

    public static void removeLastKeyword() {
        componentController.removeLastKeyword();
    }

    public static void removeLastSearchRequest() {
        componentController.removeLastSearchRequest();
    }

    public static void removeAllKeywords() {
        componentController.removeAllKeywords();
    }

    public static void removeAllSearchRequests() {
        componentController.removeAllSearchRequest();
    }

    public static void cleanRequestField() {
        componentController.cleanRequestField();
    }

    public static void printToCL(){ System.out.println(dataController.getWebPage()); }

    public static void saveFile(){
        fileController.saveFileAsHtml(dataController.getWebPage());
    }
}
