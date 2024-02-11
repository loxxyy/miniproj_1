package Document;
import java.util.List;

public class DocumentFacade {
    private DocumentBuilder builder;

    public DocumentFacade(DocumentBuilder builder) {
        this.builder = builder;
    }

    public void createHeader(String text) {
        builder.buildHeader(text);
    }

    public void createParagraph(String text) {
        builder.buildParagraph(text);
    }

    public void createList(String[] items) {
        builder.buildList(items);
    }

    public void addElement(DocumentElement element) {
        builder.addElement(element);
    }

    public void removeElement(DocumentElement element) {
        builder.removeElement(element);
    }

    public void editElement(int elementIndex, String text) {
        builder.editElement(elementIndex, text);
    }

    public void editList(int elementIndex, String[] list) {
        builder.editList(elementIndex, list);
    }

    public List<DocumentElement> getElements() {
        return builder.getElements();
    }

    public Document getDocument() {
        return builder.getResult();
    }

    public void renderDocument() {
        builder.renderDocument();
    }
}