public abstract class IDevice {
    public int ID { get; set; }
    public string Type { get; set; }

    public abstract void TurnOn();
    public abstract void TurnOff();
    public abstract void GetStatus();
}

public class Light : IDevice {
    public override void TurnOn() {
        Console.WriteLine("Light is turned ON.");
    }

    public override void TurnOff() {
        Console.WriteLine("Light is turned OFF.");
    }

    public override void GetStatus() {
        Console.WriteLine($"Light with ID {ID}: Status - {(IsOn ? "On" : "Off")}");
    }

    public bool IsOn { get; private set; }
}

public class Thermostat : IDevice {
    public double Temperature { get; set; }

    public override void TurnOn() {
        Console.WriteLine("Thermostat is ON.");
    }

    public override void TurnOff() {
        Console.WriteLine("Thermostat is OFF.");
    }

    public override void GetStatus() {
        Console.WriteLine($"Thermostat with ID {ID}: Temperature - {Temperature}°C");
    }
}

public class DoorLock : IDevice {
    public bool IsLocked { get; private set; }

    public override void TurnOn() {
        IsLocked = true;
        Console.WriteLine("Door is Locked.");
    }

    public override void TurnOff() {
        IsLocked = false;
        Console.WriteLine("Door is Unlocked.");
    }

    public override void GetStatus() {
        Console.WriteLine($"Door Lock with ID {ID}: {(IsLocked ? "Locked" : "Unlocked")}");
    }
}

public class DeviceFactory {
    public static IDevice CreateDevice(string deviceType, int id) {
        switch (deviceType.ToLower()) {
            case "light":
                return new Light { ID = id };
            case "thermostat":
                return new Thermostat { ID = id };
            case "doorlock":
                return new DoorLock { ID = id };
            default:
                throw new ArgumentException("Invalid device type");
        }
    }
}
