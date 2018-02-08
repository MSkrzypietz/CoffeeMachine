package commands;

import base.CoffeeMachine;

public class CleanCommand implements ICommand {

    private CoffeeMachine coffeeMachine;

    public CleanCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void execute() {
        coffeeMachine.clean();
    }

}
