package reflect;

import domain.Person;

import java.lang.reflect.Constructor;

/**
 * 获取构造方法们
 * 				* Constructor<?>[] getConstructors()
 * 				* Constructor<T> getConstructor(类<?>... parameterTypes)
 *
 * 				* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 * 				* Constructor<?>[] getDeclaredConstructors()
 * 		* 创建对象：
 * 			* T newInstance(Object... initargs)
 *
 * 			* 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        System.out.println("---------");

        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor1 : constructors) {
            System.out.println(constructor1);
        }
        System.out.println("---------");

        //创建对象
        Object person1 = constructor.newInstance("james", 35);
        System.out.println(person1);

        Object person2 = personClass.newInstance();
        System.out.println(person2);

    }
}
