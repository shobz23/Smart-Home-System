public class DeviceFactory {
    public static Device createDevice(String deviceType, int id) {
        switch (deviceType.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id);
            case "doorlock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
    }
}
