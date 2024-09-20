public class Main {
    public static void main(String[] args) {
        SmartHomeManager manager = SmartHomeManager.getInstance();

        // Add devices
        Device light = DeviceFactory.createDevice("light", 1);
        Device thermostat = DeviceFactory.createDevice("thermostat", 2);
        Device doorLock = DeviceFactory.createDevice("doorlock", 3);

        manager.addDevice(light);
        manager.addDevice(thermostat);
        manager.addDevice(doorLock);

        // List devices
        manager.listDevices();

        // Command to turn on the light
        CommandInvoker invoker = new CommandInvoker();
        invoker.setCommand(new TurnOnCommand(light));
        invoker.executeCommand();

        // Command to turn off the thermostat
        invoker.setCommand(new TurnOffCommand(thermostat));
        invoker.executeCommand();

        // Observer to turn off lights if temperature exceeds 30°C
        Thermostat thermostatDevice = (Thermostat) thermostat;
        TemperatureObserver tempObserver = new TemperatureObserver(thermostatDevice, (Light) light);
        thermostatDevice.setTemperature(32);  // Simulate temperature rise
        tempObserver.checkTemperature();

        // List updated device status
        manager.listDevices();
    }
}
