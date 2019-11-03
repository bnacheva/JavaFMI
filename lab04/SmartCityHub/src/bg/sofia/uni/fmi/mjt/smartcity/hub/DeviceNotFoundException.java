package bg.sofia.uni.fmi.mjt.smartcity.hub;

public class DeviceNotFoundException extends Exception {
    public DeviceNotFoundException() {}

    public DeviceNotFoundException(String message) {
        super(message);
    }
}
