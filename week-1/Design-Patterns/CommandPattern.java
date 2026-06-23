package designpatterns;

// Command Pattern
// Real-life example: Home automation - remote control for lights
// The remote control does not know HOW the light works, it just sends commands

// Step 1: Command interface - every command must have execute()
interface Command {
    void execute();
}

// Step 2: Receiver - the actual device that does the work
class Light {

    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Step 3: Concrete commands
class LightOnCommand implements Command {

    Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {

    Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Step 4: Invoker - the remote control that holds and fires commands
class RemoteControl {

    Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

// Step 5: Test class
public class CommandPattern {

    public static void main(String[] args) {

        Light light = new Light();

        Command lightOn  = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
