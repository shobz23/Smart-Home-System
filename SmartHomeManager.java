public class SmartHomeManager {
    private static SmartHomeManager instance;
    private List<IDevice> devices;

    private SmartHomeManager() {
        devices = new List<IDevice>();
    }

    public static SmartHomeManager Instance {
        get {
            if (instance == null) {
                instance = new SmartHomeManager();
            }
            return instance;
        }
    }

    public void AddDevice(IDevice device) {
        devices.Add(device);
    }

    public void RemoveDevice(int id) {
        var device = devices.FirstOrDefault(d => d.ID == id);
        if (device != null) {
            devices.Remove(device);
            Console.WriteLine($"Device with ID {id} removed.");
        } else {
            Console.WriteLine($"Device with ID {id} not found.");
        }
    }

    public void ListDevices() {
        foreach (var device in devices) {
            device.GetStatus();
        }
    }
}
