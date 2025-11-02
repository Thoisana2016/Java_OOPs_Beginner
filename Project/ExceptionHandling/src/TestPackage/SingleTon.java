package TestPackage;

import javax.sound.midi.Soundbank;

class Logging{
    private static Logging instance;
    private Logging(){
        System.out.println("Logging instance started .... ");
    }
    public static Logging getInstance(){
        if (instance == null){
            instance = new Logging();
        }
        return instance;
    }

    public void log(String msg){
        System.out.println("[LOG] : debugging ... "+msg);
    }
}

public class SingleTon {

    public static void main(String[] args) {
        Logging l1 = Logging.getInstance();
        Logging l2 = Logging.getInstance();

        l1.log("Singleton Design Pattern ...");
        l2.log("Logger reuse !");

        //Checking the connection is same
        System.out.println("Is the connection or Instance same? "+(l1 == l2));
    }
}
