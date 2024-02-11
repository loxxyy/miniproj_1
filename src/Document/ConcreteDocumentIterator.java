package Document;
import java.util.List;

public class ConcreteDocumentIterator implements DocumentIterator {
    private List<DocumentElement> elements;
    private int currentIndex = 0;
    private static ConcreteDocumentIterator instance;
    private ConcreteDocumentBuilder builder;

    public ConcreteDocumentIterator() {
        builder = ConcreteDocumentBuilder.getInstance();
    }

    public static ConcreteDocumentIterator getInstance() {
        if (instance == null) {
            instance = new ConcreteDocumentIterator();
        }
        return instance;
    }

    @Override
    public boolean hasNext() {
        elements = builder.getElements();
        return currentIndex < elements.size();
    }

    @Override
    public DocumentElement next() {
        elements = builder.getElements();
        if (hasNext()) {
            DocumentElement nextElement = elements.get(currentIndex);
            currentIndex++;
            return nextElement;
        }
        return null;
    }
}