package Document;
import java.util.List;

public interface DocumentBuilder {
    void addElement(DocumentElement element);

    void removeElement(DocumentElement element);

    List<DocumentElement> getElements();

    Document getResult();

    void renderDocument();
}