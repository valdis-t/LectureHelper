package util;

import java.util.ArrayList;

public class TextFormatterForGUIComponent {
    private static final String start = "<html>";
    private static final String end = "</html>";
    private static final String newLine = "<br>";
    private static final String empty = start + "EMPTY" + end;
    private static final StringBuilder builder = new StringBuilder();

    private TextFormatterForGUIComponent() {
    }

    public static String getButtonText(String text) {
        if (checkToNull(text)) return empty;
        String[] words = text.split(" ");
        if(words.length <= 1) return text;
        StringBuilder builder = new StringBuilder();
        builder.append(start);
        for (int i = 0; i < words.length - 1; ++i) {
            builder
                    .append(words[i])
                    .append(newLine);
        }
        builder
                .append(words[words.length - 1])
                .append(end);
        return builder.toString();
    }

    public static String getVerticalText(String text) {
        if (checkToNull(text)) return empty;

        char[] symbolicText = text.trim().toCharArray();
        builder.append(start);
        for (int i = 0; i < symbolicText.length - 1; ++i) {
            builder
                    .append(symbolicText[i])
                    .append(newLine);
        }
        builder
                .append(symbolicText[symbolicText.length - 1])
                .append(end);
        try {
            return builder.toString();
        } finally {
            builder.setLength(0);
        }
    }

    public static String getDoubleColumnedVerticalText(String text){
        if (checkToNull(text)) return empty;
        String[] words = text.split(" ");
        ArrayList<Character> word1 = new ArrayList<>();
        ArrayList<Character> word2 = new ArrayList<>();
        int maximum = Math.max(words[0].length(), words[1].length());
        for(int i = 0; i < maximum; ++i){
            word1.add(null);
            word2.add(null);
        }
        char[] chars1 = words[0].toCharArray();
        for(int i = 0; i < chars1.length; ++i){
            word1.set(i, chars1[i]);
        }
        char[] chars2 = words[1].toCharArray();
        for(int i = 0; i < chars2.length; ++i){
            word2.set(i, chars2[i]);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(start);
        for (int i = 0; i < maximum-1; ++i){
            builder
                    .append(word1.get(i) == null ? "  " : word1.get(i)+" ")
                    .append(word2.get(i) == null ? " "+newLine : word2.get(i)+newLine);
        }
        builder
                .append(word1.get(maximum-1) == null ? "  " : word1.get(maximum-1)+" ")
                .append(word2.get(maximum-1) == null ? " " : word2.get(maximum-1))
                .append(end);
        return builder.toString();
    }

    private static boolean checkToNull(String text) {
        return text == null || text.trim().equals("");
    }
}
