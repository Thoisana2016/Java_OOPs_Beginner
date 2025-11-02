package generic;

class Box<T>{
    private T value;

    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
}

public class GenericSimple {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setValue(12);
        System.out.println("Integer value : "+box.getValue());

        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, From Generic Func.!");
        System.out.println("The String is : "+stringBox.getValue());
    }
}
