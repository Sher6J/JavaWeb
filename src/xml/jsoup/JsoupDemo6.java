package xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath查询
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1. 获取student.xml的path
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        //2. 获取Document对象
        Document doc = Jsoup.parse(new File(path), "utf-8");

        //3. 根据Document对象创建JXDocument对象
        JXDocument jxDocument = new JXDocument(doc);

        //4. 结合xpath语法查询
        //4.1 查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("-------");

        //4.2 查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("--------");

        //4.3 查询student标签下带有id属性的标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("--------");

        //4.4 查询student标签下带有id属性的标签 并且id属性值为6j
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='6j']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }
}
