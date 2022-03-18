package controller;

import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.entity.CurrentRequest;
import interfaces.entity.Keywords;
import interfaces.entity.SearchRequests;

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
        if (changeable instanceof Keywords) keys = changeable;
        else if (changeable instanceof SearchRequests) searchRequests = changeable;
        else if (changeable instanceof CurrentRequest) requestLine = changeable;
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
