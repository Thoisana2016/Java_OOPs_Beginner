package SingletonDesign;

public class Main {
    public static void main(String[] args) {
        //Both call remains the same instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();


        System.out.println("Singleton design pattern");
        logger1.log("Sigleton Design Patern");
        logger2.log("Logged reused!");

        //check if all the objective are same
        System.out.println("Are both status sane ?("+(logger1 == logger2));

    }
}
