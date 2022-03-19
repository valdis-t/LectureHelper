package interfaces.entity.textgenerator;

import interfaces.Readable;

public interface Container {
    String getPageName();
    Readable<String> getTopText();
    Readable<String> getCentralText();
    Readable<String> getBottomText();
}
