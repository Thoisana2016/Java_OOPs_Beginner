package try_catch_finally;

public class TryCatchFinally {

    public void calculate(){
        int a = 10, b = 0;
        try {
            int res = a / b;
            System.out.println("Result is "+ res);
        } catch (ArithmeticException e){
            System.out.println("Exception Caught : "+e.getMessage());
        }finally {
            System.out.println("The Code block is executed! Clean Up Done.");
        }
    }
}
