import java.util.ArrayList;
import java.util.List;

public class SmartHomeManager {
    private static SmartHomeManager instance;
    private List<Device> devices;

    private SmartHomeManager() {
        devices = new ArrayList<>();
    }

    public static SmartHomeManager getInstance() {
        if (instance == null) {
            instance = new SmartHomeManager();
        }
        return instance;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(int id) {
        Device device = devices.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
        if (device != null) {
            devices.remove(device);
            System.out.println("Device with ID " + id + " removed.");
        } else {
            System.out.println("Device with ID " + id + " not found.");
        }
    }

    public void listDevices() {
        for (Device device : devices) {
            device.getStatus();
        }
    }
}
