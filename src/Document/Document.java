package Document;
import java.util.ArrayList;
import java.util.List;

public class Document implements DocumentElement {
    private List<DocumentElement> elements = new ArrayList<>();

    @Override
    public void render() {
        for (DocumentElement element : elements) {
            element.render();
        }
    }

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void removeElement(DocumentElement element) {
        elements.remove(element);
    }

    public List<DocumentElement> getElements() {
        return new ArrayList<>(elements);
    }

    @Override
    public String getContent() {
        return "";
    }

    @Override
    public String toMarkdown() {
        return "";
    }

}