class Program {
    static void Main(string[] args) {
        var homeManager = SmartHomeManager.Instance;

        // Add devices
        var light = DeviceFactory.CreateDevice("light", 1);
        var thermostat = DeviceFactory.CreateDevice("thermostat", 2);
        var doorLock = DeviceFactory.CreateDevice("doorlock", 3);

        homeManager.AddDevice(light);
        homeManager.AddDevice(thermostat);
        homeManager.AddDevice(doorLock);

        // List devices
        homeManager.ListDevices();

        // Command to turn on the light
        var invoker = new CommandInvoker();
        invoker.SetCommand(new TurnOnCommand(light));
        invoker.ExecuteCommand();

        // Command to turn off the thermostat
        invoker.SetCommand(new TurnOffCommand(thermostat));
        invoker.ExecuteCommand();

        // Observer to turn off lights if temperature exceeds 30°C
        var temperatureObserver = new TemperatureObserver((Thermostat)thermostat, (Light)light);
        thermostat.Temperature = 32;  // Simulate temperature rise
        temperatureObserver.Update();

        // List updated device status
        homeManager.ListDevices();
    }
}
