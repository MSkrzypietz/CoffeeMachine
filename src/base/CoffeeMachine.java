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

    }

    public void clean() {

    }

}
