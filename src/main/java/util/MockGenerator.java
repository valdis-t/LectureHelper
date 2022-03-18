package util;

import java.awt.*;

public class MockGenerator {
    private MockGenerator() {
    }

    public static Color getRandomColor() {
        return new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
    }

    public static void doSomething(String place){
        System.out.println("DOING SOMETHING IN " + place +  " HAS BEEN COMPLETE!");
    }
}
