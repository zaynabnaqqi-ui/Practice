abstract class EmergencyUnit {
    private String deviceName;
    private boolean isPowerOn;

    public EmergencyUnit() {
        deviceName =  "Device not known.";
        isPowerOn = false;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getIsPowerOn() {
        return isPowerOn;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setIsPowerOn(boolean isPowerOn) {
        this.isPowerOn = isPowerOn;
    }

    public abstract void respond();
}
class FireTruck extends EmergencyUnit {
    public FireTruck() {
        setDeviceName("Fire Truck");
        setIsPowerOn(true);
    }

    @Override
    public void respond() {
        System.out.println("Driving to fire");
    }

    public void deployHose() {
        System.out.println("Deploying hose to extinguish fire.");
    }
}   
class Ambulance extends EmergencyUnit {
    public Ambulance() {
        setDeviceName("Ambulance");
        setIsPowerOn(true);
    }

    @Override
    public void respond() {
        System.out.println("Driving to medical site");
    }
    public void resuscitate() {
        System.out.println("Resuscitating patient.");
    }
}
public class CityDispatcherMain {
    public static void main(String[] args) {
        EmergencyUnit fireTruck = new FireTruck();
        EmergencyUnit ambulance = new Ambulance();

        fireTruck.respond();
        ((FireTruck) fireTruck).deployHose();

        ambulance.respond();
        ((Ambulance) ambulance).resuscitate();
    }
}
