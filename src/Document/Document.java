package Document;
import java.util.ArrayList;
import java.util.List;

import Elements.Header;
import Elements.MyList;
import Elements.Paragraph;

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

    public void editElement(int elementIndex, String text) {
        DocumentElement element = elements.get(elementIndex);
    
        if (element instanceof Paragraph) {
             ((Paragraph) element).setText(text);
        } else if (element instanceof Header) {
            ((Header) element).setText(text);
        }
    }

    public void editList(int elementIndex, String[] text) {
        DocumentElement element = elements.get(elementIndex);
        if (element instanceof MyList) {
            ((MyList) element).setList(text);
        }
    }

    public List<DocumentElement> getElements() {
        return new ArrayList<>(elements);
    }

}