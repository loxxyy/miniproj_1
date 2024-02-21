package Document;
import java.util.List;

import Command.AddElementCommand;
import Command.EditElementCommand;
import Command.RemoveElementCommand;
import Elements.Header;
import Elements.MyList;
import Elements.Paragraph;

public class DocumentFacade {
    private DocumentBuilder builder;
    private AddElementCommand addCommand;
    private EditElementCommand editCommand;
    private RemoveElementCommand removeCommand;
    private HTMLBuilder htmlBuilder;
    private MarkdownBuilder markdownBuilder;

    public DocumentFacade(DocumentBuilder builder, RemoveElementCommand removeElementCommand, AddElementCommand addElementCommand, 
    EditElementCommand editElementCommand, HTMLBuilder htmlBuilder, MarkdownBuilder markdownBuilder) {
        this.builder = builder;
        this.addCommand = addElementCommand;
        this.editCommand = editElementCommand;
        this.removeCommand = removeElementCommand;
        this.htmlBuilder = htmlBuilder;
        this.markdownBuilder = markdownBuilder;
    }

    public void createHeader(String text) {
        addCommand.setElement(new Header(text));
        addCommand.execute();
    }

    public void createParagraph(String text) {
        addCommand.setElement(new Paragraph(text));
        addCommand.execute();
    }

    public void createList(String[] items) {
        addCommand.setElement(new MyList(items));
        addCommand.execute();
    }

    public void undoAdd() {
        addCommand.undo();
    }

    public void redoAdd() {
        addCommand.redo();
    }

    public void removeElement(DocumentElement element) {
        removeCommand.setElement(element);
        removeCommand.execute();
    }

    public void undoRemove() {
        removeCommand.undo();
    }

    public void redoRemove() {
        removeCommand.redo();
    }

    public void editElement(DocumentElement element, String text) {
        editCommand.setElement(element);
        editCommand.setInput(text);
        editCommand.execute();
    }

    public void editElement(DocumentElement element, String[] items) {
        editCommand.setElement(element);
        editCommand.setInput(items);
        editCommand.execute();
    }

    public void redoEdit() {
        editCommand.redo();
    }

    public void undoEdit() {
        editCommand.undo();
    }

    public List<DocumentElement> getElements() {
        return builder.getElements();
    }

    public Document getDocument() {
        return builder.getResult();
    }

    public void renderDocument() {
        builder.renderDocument();
    }

    public String transformToHTML() {
        return htmlBuilder.convertToHTML(getDocument());
    }

    public String transformToMarkdown() {
        return markdownBuilder.convertToMarkdown(getDocument());
    }
}