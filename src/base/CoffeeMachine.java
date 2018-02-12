package base;

import containers.*;
import filters.CoffeeFilter;
import filters.FlourFilter;
import filters.IFilter;
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
        System.out.println("Starting to brew a coffee...");
        sleepThread(1000);
        grindCoffeeBeans();

        IFilter coffeeFilter = new CoffeeFilter();
        Container coffeeCup = coffeeFilter.filterContainer(brewContainer);
        sleepThread(1000);
        System.out.println("Enjoy your coffee...");
        coffeeCup.printContainer();

        IFilter wasteFilter = new FlourFilter();
        wasteContainer = wasteFilter.filterContainer(brewContainer);
        sleepThread(1000);
        wasteContainer.printContainer();

        brewContainer.removeAll();
    }

    private void grindCoffeeBeans() {
        for (int i = 0; i < 10; i++) {
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
        ((WasteContainer) wasteContainer).clean();
    }

    public Container getCoffeeFlourContainer() {
        return coffeeFlourContainer;
    }

    public Container getWaterContainer() {
        return waterContainer;
    }

}
