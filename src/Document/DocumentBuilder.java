package Document;
import java.util.List;

public interface DocumentBuilder {
    void buildHeader(String text);

    void buildParagraph(String text);

    void buildList(String[] items);

    void addElement(DocumentElement element);

    void removeElement(DocumentElement element);

    void editElement(int element, String text);

    void editList(int element, String[] list);

    List<DocumentElement> getElements();

    Document getResult();

    void renderDocument();
}