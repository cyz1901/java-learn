import java.lang.reflect.Field;

public class ReflectTest {


    public static void test(Object object) throws NoSuchFieldException, IllegalAccessException {
        Class c = object.getClass();


        Field field = c.getDeclaredField("b");
        System.out.println(field.getInt(object));

    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        person.a = 11;
        System.out.println(Person.b);
        test(person);

    }
}


class Person{
    int a;
    static final int b = 1;
    void sayhello(){
        System.out.println("hello world");
    }

}