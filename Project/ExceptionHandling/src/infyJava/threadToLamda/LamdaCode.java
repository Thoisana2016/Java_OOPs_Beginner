package infyJava.threadToLamda;

public class LamdaCode {
    public static void main(String[] args) {
        new Thread  (() -> System.out.println("Lamda Instance")).start();
    }
}
