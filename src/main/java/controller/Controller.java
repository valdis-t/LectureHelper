package controller;

import component.panel.*;
import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.Readable;

import java.awt.*;

public class Controller {
    private static Controller controller;
    private Readable<String> currentKeys;
    private Readable<String> currentSearchRequests;
    private Readable<Image> currentImages;
    private Readable<String> currentRequest;
    private Readable<String> currentText;
    private Changeable<String> keys;
    private Changeable<String> searchRequests;
    private Changeable<Image> images;

    private Controller() {
    }

    public static Controller getController() {
        if (controller == null) controller = new Controller();
        return controller;
    }

    public void registerComponent(Object component) throws UnsupportedComponentException {
        if (component instanceof TextPanel) currentText = (Readable<String>) component;
        else if (component instanceof BottomPanel) currentRequest = (Readable<String>) component;
        else if (component instanceof KeywordsPanel) {
            currentKeys = (Readable<String>) component;
            keys = (Changeable<String>) component;
        } else if (component instanceof SearchRequestPanel) {
            currentSearchRequests = (Readable<String>) component;
            searchRequests = (Changeable<String>) component;
        } else if (component instanceof ImagePanel) {
            currentImages = (Readable<Image>) component;
            images = (Changeable<Image>) component;
        } else throw new UnsupportedComponentException();
    }

    public boolean isInitialised() {
        return
                currentKeys != null &
                        currentSearchRequests != null &
                        currentImages != null &
                        currentRequest != null &
                        currentText != null &
                        keys != null &
                        searchRequests != null &
                        images != null;
    }

}
