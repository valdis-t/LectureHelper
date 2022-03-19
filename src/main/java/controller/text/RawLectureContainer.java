package controller.text;

import exception.NullTextSourceException;
import exception.WrongTextSourceException;
import interfaces.Readable;
import interfaces.entity.gui.Keywords;
import interfaces.entity.gui.MainText;
import interfaces.entity.gui.SearchRequests;
import interfaces.entity.textgenerator.Container;

import java.util.List;

public class RawLectureContainer implements Container{
    private String documentName;
    private Readable<String> mainText;
    private Readable<String> keywords;
    private Readable<String> searchRequests;

    public RawLectureContainer(String documentName, List<Readable<String>> source) throws WrongTextSourceException, NullTextSourceException {
        this.documentName = documentName;
        for(Readable<String> element : source){
            if(element instanceof MainText) mainText = element;
            else if(element instanceof Keywords) keywords = element;
            else if (element instanceof SearchRequests) searchRequests = element;
            else throw new WrongTextSourceException();
        }
        if(documentName == null || mainText == null || keywords == null || searchRequests == null) throw new NullTextSourceException();
    }

    @Override
    public String getPageName() {
        return documentName;
    }

    @Override
    public Readable<String> getTopText() {
        return keywords;
    }

    @Override
    public Readable<String> getCentralText() {
        return mainText;
    }

    @Override
    public Readable<String> getBottomText() {
        return searchRequests;
    }
}
