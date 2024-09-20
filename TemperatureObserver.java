public class TemperatureObserver {
    private Thermostat thermostat;
    private Light light;

    public TemperatureObserver(Thermostat thermostat, Light light) {
        this.thermostat = thermostat;
        this.light = light;
    }

    public void checkTemperature() {
        if (thermostat.getTemperature() > 30) {
            light.turnOff();
            System.out.println("Light turned off due to high temperature.");
        }
    }
}
