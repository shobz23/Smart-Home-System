public interface IObserver {
    void Update();
}

public class TemperatureObserver : IObserver {
    private Thermostat _thermostat;
    private Light _light;

    public TemperatureObserver(Thermostat thermostat, Light light) {
        _thermostat = thermostat;
        _light = light;
    }

    public void Update() {
        if (_thermostat.Temperature > 30) {
            _light.TurnOff();
            Console.WriteLine("Light turned off due to high temperature.");
        }
    }
}
