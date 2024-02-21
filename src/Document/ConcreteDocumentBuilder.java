package Document;
import java.util.List;

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
    public void addElement(DocumentElement element) {
        document.addElement(element);
    }

    @Override
    public void removeElement(DocumentElement element) {
        document.removeElement(element);
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