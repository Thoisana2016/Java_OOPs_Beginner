package lamdaExpression;

interface Printable{
    void print(String msg);
}
public class LamdaAndInterface {

    public static void main(String[] args) {
        //WITHOUT LAMDA EXPRESSION
        Printable printable = new Printable() {
            @Override
            public void print(String msg) {
                System.out.println(msg);
            }
        };

        printable.print("Print message to console . . . ");

        //WITH LAMDA EXPRESSION
        Printable withLamda = (msg -> System.out.println(msg));
        withLamda.print("Print to console ...");
    }

}
