package Command;

import Document.DocumentBuilder;
import Document.DocumentElement;

public class AddElementCommand implements DocumentCommand {
    private DocumentElement element;
    private DocumentBuilder builder;

    public AddElementCommand(DocumentBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void setElement(DocumentElement element) {
        this.element = element;
    }

    @Override
    public void execute() {
        builder.addElement(element);
    }

    @Override
    public void undo() {
        builder.removeElement(element);
    }

    @Override
    public void redo() {
        execute();
    }
}