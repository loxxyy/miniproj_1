package Document;
public interface DocumentElement {
    void render();
    String getContent();
    String toMarkdown();
}