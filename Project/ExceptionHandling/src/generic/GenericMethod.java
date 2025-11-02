package generic;

public class GenericMethod {

    public static <T> void printArray(T[] arr){
        for (T ele : arr ){
            System.out.print(ele+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArr = {1,2,3};
        String[] stringArr = {"A","B","C"};

        System.out.println("Printing Integer Array ");
        printArray(intArr);
        System.out.println("Printing String Array ");
        printArray(stringArr);
    }
}
