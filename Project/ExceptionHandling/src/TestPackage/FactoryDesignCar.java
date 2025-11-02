package TestPackage;

interface Cars{
    void printName();
}

class BMW implements Cars{

    @Override
    public void printName() {
        System.out.println("This is BMW M6");
    }
}
class Audi implements Cars{

    @Override
    public void printName() {
        System.out.println("This is Audi R8");
    }
}
class Mercedes implements Cars{

    @Override
    public void printName() {
        System.out.println("This is Mercedes GLA 4d");
    }
}
class CarFactory{

    public Cars printCarDetails(String carType){
        if (carType == null){
            return null;
        } else if (carType.equalsIgnoreCase("bmw")) {
            return new BMW();
        } else if (carType.equalsIgnoreCase("audi")) {
            return new Audi();
        } else if (carType.equalsIgnoreCase("mercedes")) {
            return new Mercedes();
        }
        return null;
    }

}
public class FactoryDesignCar {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Cars car1 = carFactory.printCarDetails("bmW");
        car1.printName();
    }

}
