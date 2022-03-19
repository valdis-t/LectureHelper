package controller.file;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileController {

    public void saveFileAsHtml(String text) {
        try(FileWriter writer = new FileWriter(LocalDate.now().toString()+".html",false)){
            writer.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
