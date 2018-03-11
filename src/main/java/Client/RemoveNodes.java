package Client;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by YATRAONLINE\shubhangi.singh on 20/12/17.
 */
public class RemoveNodes {

    public  static void main(String args[]){

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("1612752156338.xml");
            doc.getDocumentElement().normalize();
            Node categories = doc.getElementsByTagName("PaymentDetails").item(0);
            NodeList categorieslist = categories.getChildNodes();

            while (categorieslist.getLength() > 0) {
                Node node = categorieslist.item(0);
                node.getParentNode().removeChild(node);
            }

//            for (int i = 1; i < 20; i++) {
//                org.w3c.dom.Element category = doc.createElement("category");
//                category.setAttribute("label", 3 * i + " seconds");
//                categories.appendChild(category);
//            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
