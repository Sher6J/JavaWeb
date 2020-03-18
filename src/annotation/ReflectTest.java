package annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类， 解析注解达到和配置文件相同的功能
 * 在程序使用(解析)注解：获取注解中定义的属性值
 * 		1. 获取注解定义的位置的对象  （Class，Method,Field）
 * 		2. 获取指定的注解
 * 			* getAnnotation(Class)
 * 			//其实就是在内存中生成了一个该注解接口的子类实现对象
 *
 * 		            public class ProImpl implements Pro{
 * 		                public String className(){
 * 		                    return "cn.itcast.annotation.Demo1";
 *                                                }
 * 		                public String methodName(){
 * 		                    return "show";
 *                                            }
 * 		            }
 * 		3. 调用注解中的抽象方法获取配置的属性值
 */
@Pro(className = "annotation.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取该类字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取上边的注解对象
        /*
            相当于
            public calss ProImpl implements Pro{
                public String className{
                    return "annotation.Demo1";
                }
                public String methodName{
                    return "show";
                }
            }
         */
        Pro an = reflectTestClass.getAnnotation(Pro.class); //其实就是在内存中生成一个该注解接口的子类实现对象
        //3.调用注解对象中定义的抽象方法, 获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //4.加载该类进内存
        Class<?> cls = Class.forName(className);
        //5.创建对象
        Object obj = cls.newInstance();
        //6.获取方法对象
        Method method = cls.getMethod(methodName);
        //7.执行方法
        method.invoke(obj);







        /*//1.加载配置文件
        //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件, 转换为一个集合
        //1.2.1获取配置文件文件路径
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class<?> cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);*/
    }

}
