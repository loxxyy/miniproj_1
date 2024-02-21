package Document;

import org.jsoup.nodes.Element;

import Elements.Header;
import Elements.MyList;
import Elements.Paragraph;

public class HTMLBuilder {
    private static HTMLBuilder instance;

    public static HTMLBuilder getInstance() {
        if (instance == null) {
            instance = new HTMLBuilder();
        }
        return instance;
    }

    public String convertToHTML(Document document) {
        Element htmlElement = new Element("html");

        for (DocumentElement element : document.getElements()) {
            Element elementTag = new Element("div");
            if (element instanceof Header) {
                elementTag = new Element("h1");
                elementTag.text(((Header) element).getText());
            } else if (element instanceof Paragraph) {
                elementTag = new Element("p");
                elementTag.text(((Paragraph) element).getText());
            } else if (element instanceof MyList) {
                Element ulElement = new Element("ul");
                String[] items = ((MyList) element).getList();

                for (String item : items) {
                    Element liElement = new Element("li");
                    liElement.text(item);
                    ulElement.appendChild(liElement);
                }
                htmlElement.appendChild(ulElement);
            }
            htmlElement.appendChild(elementTag);
        }

        return htmlElement.outerHtml();
    }
}