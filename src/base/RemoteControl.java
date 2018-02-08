package base;

import commands.ICommand;

public class RemoteControl {

    private ICommand command;

    public RemoteControl(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}
