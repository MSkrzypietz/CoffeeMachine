import containers.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("CoffeBeanContainer");
        Container container = new CoffeeBeanContainer();
        container.add(23);
        //container.add(1);
        //container.add(4);
        container.printContainer();
    }

}
