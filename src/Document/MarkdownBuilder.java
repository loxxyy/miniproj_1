package Document;

public class MarkdownBuilder {
    private static MarkdownBuilder instance;

    public static MarkdownBuilder getInstance() {
        if (instance == null) {
            instance = new MarkdownBuilder();
        }
        return instance;
    }
    
    public String convertToMarkdown(Document document) {
        StringBuilder markdownContent = new StringBuilder();

        for (DocumentElement element : document.getElements()) {
            markdownContent.append(element.toMarkdown());
        }

        return markdownContent.toString();
    }
}
