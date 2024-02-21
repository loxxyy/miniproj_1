package Command;

import Document.DocumentBuilder;
import Document.DocumentElement;

public class RemoveElementCommand implements DocumentCommand {
    private DocumentBuilder builder;
    private DocumentElement element;

    public RemoveElementCommand(DocumentBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void setElement(DocumentElement element) {
        this.element = element;
    }

    @Override
    public void execute() {
        builder.removeElement(element);
    }

    @Override
    public void undo() {
        builder.addElement(element);
    }

    @Override
    public void redo() {
        execute();
    }
}