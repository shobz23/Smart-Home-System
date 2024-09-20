# Smart Home System

## Overview

The **Smart Home System** is a console-based application written in Java that allows users to control various smart devices, such as lights, thermostats, and door locks. It also automates device actions based on environmental triggers, such as turning off lights when the temperature exceeds a threshold.

## Features

- Add and remove smart devices (light, thermostat, door lock).
- Turn devices on and off via commands.
- Automate device behavior based on temperature triggers.
- List all devices and their statuses.
- Follows best practices in software design, using Singleton, Factory, Command, and Observer design patterns.

## Design Patterns Used

1. **Singleton Pattern**: Ensures that only one instance of the `SmartHomeManager` exists for managing the devices.
2. **Factory Method Pattern**: Provides a way to create different devices (lights, thermostats, door locks).
3. **Command Pattern**: Encapsulates actions like turning devices on and off into command objects.
4. **Observer Pattern**: Automatically updates devices based on changes in other devices (e.g., turning off lights when the temperature is too high).

### Requirements

- Java Development Kit (JDK) 8 or higher.
- A Java IDE or command line with `javac` and `java`.

Usage
Add Devices: The system adds smart devices like lights, thermostats, and door locks.
Turn On/Off Devices: Using command invokers, you can turn devices on or off.
Automation with Observer: Devices like the thermostat trigger actions in other devices (e.g., turn off lights if the temperature exceeds 30°C).

Future Enhancements
Scheduling: Implement scheduling for devices to turn on or off at specific times.
Authentication: Add user authentication to restrict device access.
