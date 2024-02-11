package Elements;

import Document.DocumentElement;

public class Header implements DocumentElement {
    private String text;

    public Header(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Header: " + text);
    }

    public void setText(String text) {
        this.text = text;
    }
}