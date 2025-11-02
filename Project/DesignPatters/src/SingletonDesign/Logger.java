package SingletonDesign;
//singleton class
public class Logger {

    //PRIVATE STATIC INSTANCE OF THE SAME CLASS
    private static Logger instance;

    //private constructor to prevent instantiation from other class
    private Logger(){
        System.out.println("Logger Initialized!");
    }

    //public static method to get the single instance
    public static Logger getInstance(){
        if (instance == null){ //lazy initialization
            instance = new Logger();
        }
        return instance;
    }

    //example method
    public void log(String msg){
        System.out.println("[LOG-Kumar]"+msg);
    }
}

