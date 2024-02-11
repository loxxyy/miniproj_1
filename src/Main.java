import Document.ConcreteDocumentBuilder;
import Document.ConcreteDocumentIterator;
import Document.DocumentBuilder;
import Document.DocumentElement;
import Document.DocumentFacade;
import Document.DocumentIterator;
import Elements.Paragraph;

public class Main {
    public static void main(String[] args) {

        DocumentBuilder builder = ConcreteDocumentBuilder.getInstance();
        DocumentIterator iterator = ConcreteDocumentIterator.getInstance();
        DocumentFacade facade = new DocumentFacade(builder);
        Director director = new Director(facade);

        director.buildExam();
        director.renderDocument();

        int i = 0;
        while (iterator.hasNext()) {
            DocumentElement element = iterator.next();
            System.out.println("Processing element: [" + i + "] " + element.getClass().getSimpleName());
            i++;
        }

        facade.addElement(new Paragraph("test text"));
        facade.renderDocument();


        facade.editElement(0, "Examensarbete \n Author: Gustav Holm \n Supervisor: Goran");
        facade.editElement(1, "Just beginning work");
        facade.renderDocument();

        facade.removeElement(builder.getElements().get(2));
        facade.renderDocument();
    }
}