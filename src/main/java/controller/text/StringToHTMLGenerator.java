package controller.text;

import static controller.text.Tag.*;

import interfaces.Readable;
import interfaces.entity.textgenerator.WebPageGenerator;

public class StringToHTMLGenerator implements WebPageGenerator {
    private final RawLectureContainer container;

    public StringToHTMLGenerator(RawLectureContainer container){this.container = container;}

    private String getHead(){
        return HEAD_START +
                NEW_LINE +
                TITLE_START +
                container.getPageName() +
                TITLE_END +
                NEW_LINE +
                HEAD_END;
    }

    private String getTextAsList(Readable<String> source){
        StringBuilder builder = new StringBuilder();
        String[] list = source.getData().split(String.valueOf(NEW_LINE));
        builder
                .append(ARTICLE_START)
                .append(NEW_LINE)
                .append(PARAGRAPH_START)
                .append(source.getSourceName())
                .append(PARAGRAPH_END)
                .append(NEW_LINE)
                .append(LIST_START)
                .append(NEW_LINE);
        for(String element : list){
            builder
                    .append(LIST_ITEM_START)
                    .append(element)
                    .append(LIST_ITEM_END)
                    .append(NEW_LINE);
        }
        builder
                .append(LIST_END)
                .append(NEW_LINE)
                .append(ARTICLE_END);
        return builder.toString();
    }

    private String getTextAsArticles(Readable<String> source){
        StringBuilder builder = new StringBuilder();
        String[] articles = source.getData().split(String.valueOf(NEW_LINE));
        builder
                .append(ARTICLE_START)
                .append(NEW_LINE)
                .append(PARAGRAPH_START)
                .append(container.getCentralText().getSourceName())
                .append(PARAGRAPH_END)
                .append(NEW_LINE);
        for(String article : articles){
            builder
                    .append(PARAGRAPH_START)
                    .append(article)
                    .append(PARAGRAPH_END)
                    .append(NEW_LINE);
        }
        builder
                .append(ARTICLE_END);
        return builder.toString();
    }

    @Override
    public String getPage() {
        return DOCTYPE +
                NEW_LINE +
                DOCUMENT_START +
                NEW_LINE +
                getHead() +
                NEW_LINE +
                BODY_START +
                NEW_LINE +
                HEAD_1_START +
                container.getPageName() +
                HEAD_1_END +
                NEW_LINE +
                getTextAsList(container.getTopText()) +
                NEW_LINE +
                getTextAsArticles(container.getCentralText()) +
                NEW_LINE +
                getTextAsList(container.getBottomText()) +
                NEW_LINE +
                BODY_END +
                NEW_LINE +
                DOCUMENT_END;
    }
}
