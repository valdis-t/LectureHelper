package util;

public class TextFormatterForGUIComponent {
    private static final String start = "<html>";
    private static final String end = "</html>";
    private static final String newLine = "<br>";
    private static final String empty = start + "EMPTY" + end;
    private static final StringBuilder builder = new StringBuilder();

    private TextFormatterForGUIComponent() {
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

    private static boolean checkToNull(String text) {
        return text == null || text.trim().equals("");
    }
}
