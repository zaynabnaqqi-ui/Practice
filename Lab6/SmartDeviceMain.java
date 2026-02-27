import java.util.ArrayList;
abstract class SmartDevice{
    private String deviceName;
    private boolean isPowerOn;
    public String getDeviceName(){
        return deviceName;
    }
    public boolean getIsPowerOn(){
        return isPowerOn;
    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public void setIsPowerOn(boolean isPowerOn){
        this.isPowerOn = isPowerOn;
    }
    public SmartDevice(){
        deviceName = "Device not known.";
        isPowerOn = false;

    }
    public abstract void performAction();
}
    class SmartLight extends SmartDevice{
        public SmartLight(){
            this.setDeviceName("Smart Light");
        }
        @Override
        public void performAction(){
            System.out.println("Adjusting brightness to 70%");
        }
    }
    class SmartThermostat extends SmartDevice{
        public SmartThermostat(){
            this.setDeviceName("Smart Thermostat");
        }
        @Override
        public void performAction(){
            System.out.println("Setting temperature to 22°C.");
        }
    }
    class SmartCamera extends SmartDevice{
        public SmartCamera(){
            this.setDeviceName("Smart Camera");
        }
        @Override
        public void performAction(){
            System.out.println("Recording motion-activated video.");
        }
    }
public class SmartDeviceMain {
    public static void main(String[] args) {
        ArrayList<SmartDevice> devices = new ArrayList<>();
        devices.add(new SmartLight());
        devices.add(new SmartThermostat());
        devices.add(new SmartCamera());
        for(SmartDevice device : devices){
            System.out.println("Device: " + device.getDeviceName());
            device.performAction();
        }

    }
}
/*
 SmartThermostat: performAction() should print "Setting temperature to 22°C."
 SmartCamera: performAction() should print "Recording motion-activated video."
c) The test class, give it a meaningful name, maybe SmartHomeController:
 In your Main class, create a List<SmartDevice>.
 Add at least one instance of each device to the list.
 Write a single loop that iterates through the list and calls performAction() on every
device regardless of its specific type */