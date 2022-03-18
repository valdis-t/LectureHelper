package controller;

import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.Readable;

public class Controller {
    private final static ComponentController componentController = ComponentController.getController();
    private final static TextController textController = TextController.getController();

    private Controller() {
    }

    public static void register(Readable<String> entry) throws UnsupportedComponentException {
        textController.register(entry);
        if (entry instanceof Changeable) componentController.register((Changeable<String>) entry);
    }

    public static void saveFile() {
        textController.saveFile();
    }

    public static void saveAs() {
        textController.saveAs();
    }

    public static void printToCL() {
        textController.printToCL();
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
}
