
package semester1.practice10;

abstract class UiWidget {
    protected String id;
    protected int width;
    protected int height;

    public UiWidget(String id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public abstract String renderHtml();
}

class ButtonWidget extends UiWidget {
    private final String label;

    public ButtonWidget(String id, int width, int height, String label) {
        super(id, width, height);
        this.label = label;
    }

    @Override
    public String renderHtml() {
        return "<button id=\"" + id + "\" style=\"width:"
                + width + "px;height:" + height + "px;\">"
                + label + "</button>";
    }
}

class TextInputWidget extends UiWidget {
    private final String placeholder;

    public TextInputWidget(String id, int width, int height,
                           String placeholder) {
        super(id, width, height);
        this.placeholder = placeholder;
    }

    @Override
    public String renderHtml() {
        return "<input id=\"" + id + "\" placeholder=\""
                + placeholder + "\" style=\"width:" + width
                + "px;height:" + height + "px;\">";
    }
}

class ProgressBarWidget extends UiWidget {
    private final int progressPercent;

    public ProgressBarWidget(String id, int width, int height,
                             int progressPercent) {
        super(id, width, height);

        if (progressPercent < 0 || progressPercent > 100) {
            throw new IllegalArgumentException(
                    "Прогрес має бути від 0 до 100"
            );
        }

        this.progressPercent = progressPercent;
    }

    @Override
    public String renderHtml() {
        return "<div id=\"" + id + "\" style=\"width:"
                + width + "px;height:" + height
                + "px;background:lightgray;\">"
                + "<div style=\"width:" + progressPercent
                + "%;height:100%;background:green;\"></div>"
                + "</div>";
    }
}

public class Task_07 {

    public static String buildPage(UiWidget[] pageElements) {
        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>");
        html.append("<html><body>");

        for (UiWidget widget : pageElements) {
            html.append(widget.renderHtml());
            html.append("\n");
        }

        html.append("</body></html>");

        return html.toString();
    }

    public static void main(String[] args) {

        UiWidget[] pageElements = {
                new ButtonWidget("btn1", 120, 40, "Натисни мене"),
                new TextInputWidget("input1", 200, 30, "Введіть ім'я"),
                new ProgressBarWidget("progress1", 300, 20, 75)
        };

        String page = buildPage(pageElements);

        System.out.println(page);
    }
}
