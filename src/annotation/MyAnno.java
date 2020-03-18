package annotation;

public @interface MyAnno {
    int age();
    String name() default "lebron";
    Person per();
    MyAnno2 anno2();
    String[] strs();

}
