package Command;

import Document.DocumentElement;

public interface DocumentCommand {
    void setElement(DocumentElement element);
    void execute();
    void redo();
    void undo();
}
