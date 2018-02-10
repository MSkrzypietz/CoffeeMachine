package base;

import containers.*;
import observers.ICoffeeFlourLevelListener;
import observers.IWaterTempListener;

public class CoffeeMachine {

    private Container coffeeBeanContainer = new CoffeeBeanContainer();
    private Container coffeeFlourContainer = new CoffeeFlourContainer();
    private Container waterContainer = new WaterContainer();
    private Container brewContainer = new BrewContainer(this);
    private Container wasteContainer = new WasteContainer();

    public CoffeeMachine() {
        coffeeBeanContainer.fillUp();
        waterContainer.fillUp();
        ((CoffeeFlourContainer) coffeeFlourContainer).getCoffeeFlourLevelObserver().addListener((ICoffeeFlourLevelListener) waterContainer);
        ((WaterContainer) waterContainer).getWaterTempObserver().addListener((IWaterTempListener) brewContainer);
    }

    public void brewCoffee() {
        grindCoffeeBeans(10);
    }

    private void grindCoffeeBeans(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println("Grinding coffee beans...");
            coffeeBeanContainer.remove(1);
            sleepThread(200);
            coffeeFlourContainer.add(5);
            ((CoffeeFlourContainer) coffeeFlourContainer).checkIfFullToHeatWater();
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

    public Container getCoffeeFlourContainer() {
        return coffeeFlourContainer;
    }

    public Container getWaterContainer() {
        return waterContainer;
    }

}
