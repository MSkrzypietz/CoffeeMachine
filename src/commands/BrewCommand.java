package commands;

import base.CoffeeMachine;

public class BrewCommand implements ICommand {

    private CoffeeMachine coffeeMachine;

    public BrewCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void execute() {
        coffeeMachine.brewCoffee();
    }

}
