package Static;

public class Colour {

    public static void main(String[] args) {
        Animal a = new Animal();
        int n = a.numSum(10);
        System.out.println("Sum  : "+n);
        a.name = "Grok";
        System.out.println("Name : "+a.name);
        a.printAll();
    }


}


class Animal{
    static  String name;
    static int num =90;
    static int numSum(int n){
        return n + num;
    }

    void printAll(){
        System.out.println("Number : "+num);
    }
}
