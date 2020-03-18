package reflect;

import domain.Person;

import java.lang.reflect.Method;

/**
 * 获取成员方法们：
 * 				* Method[] getMethods()
 * 				* Method getMethod(String name, 类<?>... parameterTypes)
 *
 * 				* Method[] getDeclaredMethods()
 * 				* Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 * 		* 执行方法：
 * 			* Object invoke(Object obj, Object... args)
 *
 * 		* 获取方法名称：
 * 			* String getName:获取方法名
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        //获取指定名称方法
        Method eat_method = personClass.getMethod("eat");
        System.out.println(eat_method);
        //执行方法
        Person p = new Person();
        eat_method.invoke(p);
        System.out.println("----------");

        Method eat_method2 = personClass.getMethod("eat", String.class);
        System.out.println(eat_method2);
        eat_method2.invoke(p, "猪猪");
        System.out.println("----------");

        //获取所有方法
        Method[] methods = personClass.getMethods(); //还有Object中的方法
        for (Method method : methods) {
            //method.setAccessible(true);
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }
        System.out.println("-----------");

        String className = personClass.getName();
        System.out.println(className); //全类名

    }
}
