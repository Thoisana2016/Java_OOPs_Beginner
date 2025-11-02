package lamdaExpression;

interface Arithmetic{
    int sum(int a, int b);
}
public class LamdaExpressionWithPaarameter {
    public static void main(String[] args) {
        Arithmetic arithmetic = (x, y) -> x + y;
        System.out.println("Sum of two number : "+arithmetic.sum(10,11));
    }
}
