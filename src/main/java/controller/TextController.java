package controller;

import exception.UnsupportedComponentException;
import interfaces.Readable;
import interfaces.entity.CurrentRequest;
import interfaces.entity.Keywords;
import interfaces.entity.MainText;
import interfaces.entity.SearchRequests;
import util.FileManager;

public class TextController {
    private Readable<String> keywords;
    private Readable<String> searchRequests;
    private Readable<String> currentText;

    private final String NEW_LINE = "\n";

    public void register(Readable<String> entry) throws UnsupportedComponentException {
        if (entry instanceof MainText) currentText = entry;
        else if (entry instanceof Keywords) keywords = entry;
        else if (entry instanceof SearchRequests) searchRequests = entry;
        else if (entry instanceof CurrentRequest) {}
        else throw new UnsupportedComponentException();
    }

    public void saveFile() {
        FileManager.getManager().saveFile();
    }

    public void saveAs() {
        FileManager.getManager().saveAs();
    }

    public void printToCL() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(this.getClass().getSimpleName())
                .append(" | PRINT")
                .append(NEW_LINE)
                .append("MAIN TEXT:")
                .append(NEW_LINE)
                .append(currentText.getData())
                .append(NEW_LINE)
                .append("SEARCH REQUESTS:")
                .append(NEW_LINE)
                .append(searchRequests.getData())
                .append(NEW_LINE)
                .append("KEYWORDS:")
                .append(NEW_LINE)
                .append(keywords.getData())
                .append(NEW_LINE);
        System.out.println(builder);
    }
}
