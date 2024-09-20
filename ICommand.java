public interface ICommand {
    void Execute();
}

public class TurnOnCommand : ICommand {
    private IDevice _device;

    public TurnOnCommand(IDevice device) {
        _device = device;
    }

    public void Execute() {
        _device.TurnOn();
    }
}

public class TurnOffCommand : ICommand {
    private IDevice _device;

    public TurnOffCommand(IDevice device) {
        _device = device;
    }

    public void Execute() {
        _device.TurnOff();
    }
}

public class CommandInvoker {
    private ICommand _command;

    public void SetCommand(ICommand command) {
        _command = command;
    }

    public void ExecuteCommand() {
        _command.Execute();
    }
}
