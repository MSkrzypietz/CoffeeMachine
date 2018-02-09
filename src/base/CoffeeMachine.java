package base;

import containers.*;
import observers.ICoffeeFlourLevelListener;

public class CoffeeMachine {

    private Container coffeeBeanContainer = new CoffeeBeanContainer();
    private Container coffeeFlourContainer = new CoffeeFlourContainer();
    private Container waterContainer = new WaterContainer();
    private Container brewContainer = new BrewContainer();
    private Container wasteContainer = new WasteContainer();

    public CoffeeMachine() {
        coffeeBeanContainer.fillUp();
        waterContainer.fillUp();
        ((CoffeeFlourContainer) coffeeFlourContainer).getCoffeeFlourLevelObserver().addListener((ICoffeeFlourLevelListener) waterContainer);
    }

    public void brewCoffee() {
        grindCoffeeBeans(10);
    }

    private void grindCoffeeBeans(int amount) {
        coffeeBeanContainer.printContainer();
        coffeeFlourContainer.printContainer();
        for (int i = 0; i < amount; i++) {
            System.out.println("Grinding coffee beans...");
            coffeeBeanContainer.remove(1);
            sleepThread(200);
            coffeeFlourContainer.add(5);
            ((CoffeeFlourContainer) coffeeFlourContainer).checkIfFullToHeatWater();
        }
        coffeeBeanContainer.printContainer();
        coffeeFlourContainer.printContainer();
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
