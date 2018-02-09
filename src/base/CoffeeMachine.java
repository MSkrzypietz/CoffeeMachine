package base;

import containers.*;

public class CoffeeMachine {

    private Container coffeeBeanContainer = new CoffeeBeanContainer();
    private Container coffeeFlourContainer = new CoffeeFlourContainer();
    private Container waterContainer = new WaterContainer();
    private Container brewContainer = new BrewContainer();
    private Container wasteContainer = new WasteContainer();

    public CoffeeMachine() {}

    public void brewCoffee() {
        grindCoffeeBeans(10);
    }

    private void grindCoffeeBeans(int amount) {
        for (int i = 0; i < amount; i++) {
            coffeeBeanContainer.printContainer();
            coffeeFlourContainer.printContainer();
            System.out.println("Grinding coffee beans...");
            coffeeBeanContainer.remove(1);
            sleepThread(200);
            coffeeFlourContainer.add(5);
        }
    }

    private void sleepThread(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clean() {

    }

}
