package experiment;

import util.TextFormatterForGUIComponent;

public class TextFormatterTest {
    public static void main(String[] args) {
        String text = "welcome world";
        System.out.println(TextFormatterForGUIComponent.getDoubleColumnedVerticalText(text));
    }
}
