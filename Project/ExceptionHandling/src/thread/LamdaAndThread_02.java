package thread;

public class LamdaAndThread_02 {

    public static void main(String[] args) {
        Thread myThread =  new Thread(() -> {
           for (int i = 0; i < 10; i+=2){
               System.out.println("Running inside the thread "+i);
           }
        });
        myThread.start();
    }

}
