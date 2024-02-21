package Elements;

import Document.DocumentElement;
public class Paragraph implements DocumentElement {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Paragraph: " + text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getContent() {
        return text;
    }

    @Override
    public String toMarkdown() {
        return "## " + text + "\n\n";
    }
}