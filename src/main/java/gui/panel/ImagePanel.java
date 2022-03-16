package gui.panel;

import controller.Controller;
import exception.UnsupportedComponentException;
import interfaces.Changeable;
import interfaces.Readable;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel implements Readable<Image>, Changeable<Image> {
    public ImagePanel() {
        register();
    }

    private void register() {
        try {
            Controller.getController().registerComponent(this);
        } catch (UnsupportedComponentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getData() {
        return null;
    }

    @Override
    public void setData(Image data) {

    }
}
