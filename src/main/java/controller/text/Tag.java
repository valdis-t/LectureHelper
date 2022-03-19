package controller.text;

public interface Tag {
    String DOCTYPE = "<!DOCTYPE html>";
    String DOCUMENT_START = "<html>";
    String DOCUMENT_END = "</html>";
    String HEAD_START = "<head>";
    String HEAD_END = "</head>";
    String TITLE_START = "<title>";
    String TITLE_END = "</title>";
    String BODY_START = "<body>";
    String BODY_END = "</body>";
    String LIST_START = "<ul>";
    String LIST_END = "</ul>";
    String LIST_ITEM_START = "<li>";
    String LIST_ITEM_END = "</li>";
    String LINK_START = "<a";
    String LINK_END = "</a>";
    String PARAGRAPH_START = "<p>";
    String PARAGRAPH_END = "</p>";
    String ARTICLE_START = "<div>";
    String ARTICLE_END = "</div>";
    String HEAD_1_START = "<h1>";
    String HEAD_1_END = "</h1>";
    String HEAD_2_START = "<h2>";
    String HEAD_2_END = "</h2>";
    String HREF_ATTRIBUTE = "href";
    String NAME_ATTRIBUTE = "name";

    String EMPTY_DOCUMENT = DOCUMENT_START+"NULL"+DOCUMENT_END;

    char OPEN_QUOTATION_MARK = '<';
    char CLOSE_QUOTATION_MARK = '>';
    char DOUBLE_QUOTATION_MARK = '"';
    char SPACE = ' ';
    char NEW_LINE = '\n';
}
