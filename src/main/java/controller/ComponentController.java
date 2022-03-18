package controller;

import exception.UnsupportedComponentException;
import gui.panel.BottomPanel;
import gui.panel.KeywordsPanel;
import gui.panel.SearchRequestPanel;
import interfaces.Changeable;

public class ComponentController {
    private static ComponentController controller;
    private Changeable<String> keys;
    private Changeable<String> searchRequests;
    private Changeable<String> requestLine;
    private ComponentController() {
    }

    public static ComponentController getController() {
        if (controller == null) controller = new ComponentController();
        return controller;
    }

    public void register(Changeable<String> changeable) throws UnsupportedComponentException {
        if (changeable instanceof KeywordsPanel) keys = changeable;
        else if (changeable instanceof SearchRequestPanel) searchRequests = changeable;
        else if (changeable instanceof BottomPanel) requestLine = changeable;
        else throw new UnsupportedComponentException();
    }

    public void addRequestToKeywords() {
        keys.setData(requestLine.getData());
    }

    public void addRequestToSearchRequests() {
        searchRequests.setData(requestLine.getData());
    }

    public void removeLastKeyword() {
        keys.removeLast();
    }

    public void removeLastSearchRequest() {
        searchRequests.removeLast();
    }

    public void removeAllKeywords() {
        keys.removeAll();
    }

    public void removeAllSearchRequest() {
        searchRequests.removeAll();
    }

    public void cleanRequestField() {
        requestLine.removeAll();
    }
}
