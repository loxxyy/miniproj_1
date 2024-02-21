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

    public String[] getList() {
        return items;
    }

    @Override
    public String getContent() {
        String itemsAsString = "";
        for (String item : items) {
            itemsAsString += item;
        }
        return itemsAsString;
    }

    @Override
    public String toMarkdown() {
        StringBuilder markdownList = new StringBuilder();

        for (String item : items) {
            markdownList.append("- ").append(item).append("\n");
        }

        return markdownList.toString() + "\n";
    }
}