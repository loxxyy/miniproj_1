package Command;

import Document.DocumentElement;
import Elements.Header;
import Elements.MyList;
import Elements.Paragraph;

public class EditElementCommand implements DocumentCommand {
    private DocumentElement editableElement;
    private String newText = "";
    private String[] newItems = {};
    private String oldText = "";
    private String[] oldItems = {};

    @Override
    public void setElement(DocumentElement element) {
        this.editableElement = element;
    }

    public void setInput(String text) {
        newText = text;
    }

    public void setInput(String[] items) {
        newItems = items;
    }

    @Override
    public void execute() {
        if (editableElement instanceof Header) {
            oldText = ((Header) editableElement).getText();
            ((Header) editableElement).setText(newText);
        } else if (editableElement instanceof MyList) {
            oldItems = ((MyList) editableElement).getList();
            ((MyList) editableElement).setList(newItems);
        } else if (editableElement instanceof Paragraph) {
            oldText = ((Paragraph) editableElement).getText();
            ((Paragraph) editableElement).setText(newText);
        }
    }

    @Override
    public void undo() {
        if (editableElement instanceof Header) {
            ((Header) editableElement).setText(oldText);
        } else if (editableElement instanceof MyList) {
            ((MyList) editableElement).setList(oldItems);
        } else if (editableElement instanceof Paragraph) {
            ((Paragraph) editableElement).setText(oldText);
        }
    }

    @Override
    public void redo() {
        if (editableElement instanceof Header) {
            ((Header) editableElement).setText(newText);
        } else if (editableElement instanceof MyList) {
            ((MyList) editableElement).setList(newItems);
        } else if (editableElement instanceof Paragraph) {
            ((Paragraph) editableElement).setText(newText);
        }
    }
}
