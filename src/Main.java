import Command.AddElementCommand;
import Command.EditElementCommand;
import Command.RemoveElementCommand;
import Document.ConcreteDocumentBuilder;
import Document.ConcreteDocumentIterator;
import Document.DocumentBuilder;
import Document.DocumentElement;
import Document.DocumentFacade;
import Document.DocumentIterator;
import Document.HTMLBuilder;
import Document.MarkdownBuilder;
import Elements.MyList;

public class Main {
    public static void main(String[] args) {

        DocumentBuilder builder = ConcreteDocumentBuilder.getInstance();
        DocumentIterator iterator = ConcreteDocumentIterator.getInstance();
        HTMLBuilder htmlBuilder = HTMLBuilder.getInstance();
        MarkdownBuilder markdownBuilder = MarkdownBuilder.getInstance();
        AddElementCommand addElementCommand = new AddElementCommand(builder);
        EditElementCommand editElementCommand = new EditElementCommand();
        RemoveElementCommand removeElementCommand = new RemoveElementCommand(builder);
        DocumentFacade facade = new DocumentFacade(builder, removeElementCommand, addElementCommand, editElementCommand, htmlBuilder, markdownBuilder);
        Director director = new Director(facade);

        System.out.println("First print: ");
        director.buildLetter();
        director.renderDocument();

        System.out.println("\n Different parts: ");
        int i = 0;
        while (iterator.hasNext()) {
            DocumentElement element = iterator.next();
            System.out.println("Processing element: [" + i + "] " + element.getClass().getSimpleName());
            i++;
        }

        System.out.println("\n Adding a paragraph: ");
        facade.createParagraph("test text");
        facade.renderDocument();

        System.out.println("\n Editing two elements: ");
        facade.editElement(facade.getElements().get(0), "Gustav Inc,\n Kungsbäcksvägen 123, Gävle, Sverige");
        facade.editElement(facade.getElements().get(1), "Goddag kära läsare: \n Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut massa mauris, varius id mi sed, congue tempus ipsum. Suspendisse eu sodales elit. Pellentesque habitant morbi. \n Mvh\nGustav Holm");
        facade.renderDocument();

        System.out.println("\n Removing the added paragraph: ");
        facade.removeElement(facade.getElements().get(2));
        facade.renderDocument();

        System.out.println("\n Undo on the remove: ");
        facade.undoRemove();
        facade.renderDocument();

        System.out.println("\n Redo on the remove: ");
        facade.redoRemove();
        facade.renderDocument();

        System.out.println("\n Adding a list");
        facade.createList(new String[]{"Bifogad fil 1", "Bifogad fil 2", "Bifogad bild"});
        facade.renderDocument();

        System.out.println("\n Som HTML: ");
        System.out.println(facade.transformToHTML());

        System.out.println("\n Som Markdown:");
        System.out.println(facade.transformToMarkdown());
    }
}