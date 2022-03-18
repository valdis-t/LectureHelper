package util;

public class FileManager {
    private static FileManager manager;

    private FileManager() {
    }

    public static FileManager getManager() {
        if (manager == null) manager = new FileManager();
        return manager;
    }

    public void saveFile() {
        MockGenerator.doSomething("FileManager.saveFile");
    }

    public void saveAs() {
        MockGenerator.doSomething("FileManager.saveAs");
    }
}
