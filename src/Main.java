import base.CoffeeMachine;
import base.RemoteControl;
import commands.BrewCommand;
import commands.ICommand;
import containers.*;

public class Main {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        ICommand command = new BrewCommand(coffeeMachine);
        RemoteControl remoteControl = new RemoteControl(command);
        remoteControl.pressButton();

    }

}
