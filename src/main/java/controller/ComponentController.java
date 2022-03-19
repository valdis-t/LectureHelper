package controller;

import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.entity.gui.CurrentRequest;
import interfaces.entity.gui.Keywords;
import interfaces.entity.gui.SearchRequests;

public class ComponentController {
    private Changeable<String> keys;
    private Changeable<String> searchRequests;
    private Changeable<String> requestLine;

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
