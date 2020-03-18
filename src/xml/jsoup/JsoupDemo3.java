package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document/Element对象功能
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //1. 获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //2. 获取Document对象
        Document doc = Jsoup.parse(new File(path), "utf-8");
        //3. 获取元素对象了

        /*//3.1 获取所有student对象
        Elements students = doc.getElementsByTag("student");
        System.out.println(students);*/

        //3.2 获取属性名为6j的元素对象们
        Elements elements = doc.getElementsByAttribute("id");
        System.out.println(elements);
        System.out.println("--------");

        //3.2 获取number属性值为0001的元素的对象
        Elements elements1 = doc.getElementsByAttributeValue("number", "0001");
        System.out.println(elements1);
        System.out.println("--------");

        Element byId = doc.getElementById("6j");
        System.out.println(byId);

    }
}
