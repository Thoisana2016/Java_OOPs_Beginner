package lamdaExpression;
interface Greeting{
    void sayHello();
}
public class SimpleLamdaExpression {

    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello, Simple Lamda Expression!");
        greeting.sayHello();
    }
}
