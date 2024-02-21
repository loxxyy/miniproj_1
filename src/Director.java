import Document.Document;
import Document.DocumentElement;
import Document.DocumentFacade;

public class Director {

    private DocumentFacade facade;
    public Director(DocumentFacade facade) {
        this.facade = facade;
    }

    public DocumentElement buildDocument() {
        return facade.getDocument();
    }

    public DocumentElement buildLetter() {
        facade.createHeader("Company Name, 123 Main Street, City, Country");
        facade.createParagraph("Dear [Recipient],\n\n\n Sincerely,\n[Your Name]");
        return facade.getDocument();
    }

    public DocumentElement buildExam() {
        facade.createHeader("Title of Thesis \n Author: [Your Name] \n Supervisor: [Supervisor Name]");
        facade.createParagraph("Introduction: \n Metod: \n Results: \n Discussion: ");
        return facade.getDocument();
    }

    public DocumentElement buildCalendar() {
        facade.createHeader("[Year]");
        facade.createList(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        return facade.getDocument();
    }

    public void renderDocument() {
        facade.renderDocument();
    }
}