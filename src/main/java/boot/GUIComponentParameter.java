package boot;

import java.awt.*;

public interface GUIComponentParameter {

    double percentageOfWidthFromScreenWidth = 0.625;
    double percentageOfHeightFromWidth = 0.625;
    double percentageOfRightPanelWidthFromRootPanelWidth = 0.25;
    double percentageOfBottomPanelHeightFromRootPanelHeight = 0.1;
    double percentageOfControlPanelHeightFromRightPanel = 0.3;

    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    int indentX = 5;
    int indentY = 5;

    Color textPanelColor = new Color(240, 30, 40);
    Color rightPanelColor = new Color(120, 120, 190);
    Color bottomPanelColor = new Color(0, 247, 110);
    Color controlPanelColor = new Color(200, 200, 0);

    static Dimension rootPanelDimension() {
        return new Dimension((int) (screenDimension.width * percentageOfWidthFromScreenWidth), (int) (screenDimension.width * percentageOfWidthFromScreenWidth * percentageOfHeightFromWidth));
    }

    static Dimension textPanelDimension() {
        return new Dimension(rootPanelDimension().width - rightPanelDimension().width, rootPanelDimension().height - bottomPanelDimension().height);
    }

    static Dimension rightPanelDimension() {
        return new Dimension((int) (rootPanelDimension().width * percentageOfRightPanelWidthFromRootPanelWidth), (int) (rootPanelDimension().height * (1 - percentageOfControlPanelHeightFromRightPanel)));
    }

    static Dimension controlPanelDimension() {
        return new Dimension((int) (rootPanelDimension().width * percentageOfRightPanelWidthFromRootPanelWidth), (int) (rootPanelDimension().height * percentageOfControlPanelHeightFromRightPanel));
    }

    static Dimension bottomPanelDimension() {
        return new Dimension(rootPanelDimension().width - rightPanelDimension().width, (int) (rootPanelDimension().height * percentageOfBottomPanelHeightFromRootPanelHeight));
    }

    static Dimension searchRequestAreaDimension() {
        return null;
    }

    static Dimension keywordAreaDimension() {
        return null;
    }

    static Dimension additionPanelRequestAreaDimension() {
        return null;
    }

    static Dimension textAreaDimension() {
        return null;
    }

    static Dimension tabbedPanelAreaDimension() {
        return null;
    }
}
