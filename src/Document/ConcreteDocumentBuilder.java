package Document;
import java.util.List;

import Elements.Header;
import Elements.MyList;
import Elements.Paragraph;

public class ConcreteDocumentBuilder implements DocumentBuilder {
    private Document document;
    private static ConcreteDocumentBuilder instance;

    private ConcreteDocumentBuilder() {
        this.document = new Document();
    }

    public static ConcreteDocumentBuilder getInstance() {
        if (instance == null) {
            instance = new ConcreteDocumentBuilder();
        }
        return instance;
    }

    @Override
    public void buildHeader(String text) {
        document.addElement(new Header(text));
    }

    @Override
    public void buildParagraph(String text) {
        document.addElement(new Paragraph(text));
    }

    @Override
    public void buildList(String[] items) {
        document.addElement(new MyList(items));
    }

    @Override
    public void addElement(DocumentElement element) {
        document.addElement(element);
    }

    @Override
    public void removeElement(DocumentElement element) {
        document.removeElement(element);
    }

    @Override
    public void editElement(int elementIndex, String text) {
        document.editElement(elementIndex, text);
    }

    @Override
    public void editList(int elementIndex, String[] list) {
        document.editList(elementIndex, list);
    }

    @Override
    public List<DocumentElement> getElements() {
        return document.getElements();
    }

    @Override
    public Document getResult() {
        return document;
    }

    @Override
    public void renderDocument() {
        document.render();
    }
}