package Elements;
import Document.DocumentElement;

public class MyList implements DocumentElement {
    private String[] items;

    public MyList(String[] items) {
        this.items = items;
    }

    @Override
    public void render() {
        System.out.println("List:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

    public void setList(String[] list) {
        this.items = list;
    }
}