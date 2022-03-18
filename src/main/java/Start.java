import controller.TextController;
import gui.MainFrame;

import javax.swing.*;

public class Start {
    public static void main(String[] args) {
        JFrame frame = new MainFrame();
        if (TextController.getController().isInitialised()) frame.setVisible(true);
        else throw new RuntimeException();
    }
}
