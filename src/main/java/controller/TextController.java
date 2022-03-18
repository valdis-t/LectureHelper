package controller;

import exception.UnsupportedComponentException;
import gui.panel.BottomPanel;
import gui.panel.KeywordsPanel;
import gui.panel.SearchRequestPanel;
import gui.panel.TextPanel;
import interfaces.Readable;
import util.FileManager;

public class TextController {
    public static final String NEW_LINE = "\n";
    private static TextController controller;
    private Readable<String> keywords;
    private Readable<String> searchRequests;
    private Readable<String> currentText;
    private TextController() {
    }

    public static TextController getController() {
        if (controller == null) controller = new TextController();
        return controller;
    }

    public void register(Readable<String> entry) throws UnsupportedComponentException {
        if (entry instanceof TextPanel) currentText = entry;
        else if (entry instanceof KeywordsPanel) keywords = entry;
        else if (entry instanceof SearchRequestPanel) searchRequests = entry;
        else if (entry instanceof BottomPanel) {
        } else throw new UnsupportedComponentException();
    }


    public boolean isInitialised() {
        return
                keywords != null &
                        searchRequests != null &
                        currentText != null &
                        searchRequests != null;
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
