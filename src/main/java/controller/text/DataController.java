package controller.text;

import exception.NullTextSourceException;
import exception.UnsupportedComponentException;
import exception.WrongTextSourceException;
import interfaces.Readable;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DataController {
    private List<Readable<String>> source = new LinkedList<>();

    public void register(Readable<String> entry) throws UnsupportedComponentException {
        source.add(entry);
    }

    public String getWebPage(){
        String result = Tag.EMPTY_DOCUMENT;
        try {
            result = new StringToHTMLGenerator(new RawLectureContainer("Lecture "+ LocalDate.now(),source)).getPage();
        } catch (NullTextSourceException exception){
            exception.printStackTrace();
        }
        catch (WrongTextSourceException exception){
            exception.printStackTrace();
        }
        return result;
    }
}
