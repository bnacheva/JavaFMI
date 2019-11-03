package bg.sofia.uni.fmi.mjt.smartcity.hub;

import bg.sofia.uni.fmi.mjt.smartcity.device.SmartDevice;
import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;
import org.jetbrains.annotations.Contract;

import java.util.Collection;
import java.util.HashSet;

public class SmartCityHub {
    private HashSet<SmartDevice> smartDevices = new HashSet<>();

    @Contract(pure = true)
    public SmartCityHub() {

    }

    /**
     * Adds a @device to the SmartCityHub.
     *
     * @throws IllegalArgumentException in case @device is null.
     * @throws DeviceAlreadyRegisteredException in case the @device is already registered.
     */
    public void register(SmartDevice device) throws DeviceAlreadyRegisteredException {
        if (device == null) {
            throw new IllegalArgumentException();
        } else if (this.smartDevices.contains(device)) {
            throw new DeviceAlreadyRegisteredException("The device is already registered!");
        } else {
            smartDevices.add(device);
        }
    }

    /**
     * Removes the @device from the SmartCityHub.
     *
     * @throws IllegalArgumentException in case null is passed.
     * @throws DeviceNotFoundException in case the @device is not found.
     */
    public void unregister(SmartDevice device) throws DeviceNotFoundException {
        if (device == null) {
            throw new IllegalArgumentException();
        } else if (!this.smartDevices.contains(device)) {
            throw new DeviceNotFoundException("The device is not found!");
        } else {
            this.smartDevices.remove(device);
        }
    }

    /**
     * Returns a SmartDevice with an ID @id.
     *
     * @throws IllegalArgumentException in case @id is null.
     * @throws DeviceNotFoundException in case device with ID @id is not found.
     */
    public SmartDevice getDeviceById(String id) throws DeviceNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException();
        } else {
            for(SmartDevice smartDevice : this.smartDevices) {
                if (smartDevice.getId() == id) {
                    return smartDevice;
                }
            }
            throw new DeviceNotFoundException("The device with this ID is not found!");
        }
    }

    /**
     * Returns the total number of devices with type @type registered in SmartCityHub.
     *
     * @throws IllegalArgumentException in case @type is null.
     */
    public int getDeviceQuantityPerType(DeviceType type) {
        if (type == null) {
            throw new IllegalArgumentException();
        } else {
            int counter = 0;
            for(SmartDevice smartDevice : this.smartDevices) {
                if (smartDevice.getType() == type) {
                    counter++;
                }
            }
            return counter;
        }
    }

    /**
     * Returns a collection of IDs of the top @n devices which consumed
     * the most power from the time of their installation until now.
     *
     * The total power consumption of a device is calculated by the hours elapsed
     * between the two LocalDateTime-s: the installation time and the current time (now)
     * multiplied by the stated nominal hourly power consumption of the device.
     *
     * If @n exceeds the total number of devices, return all devices available sorted by the given criterion.
     * @throws IllegalArgumentException in case @n is a negative number.
     */
    public Collection<String> getTopNDevicesByPowerConsumption(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a collection of the first @n registered devices, i.e the first @n that were added
     * in the SmartCityHub (registration != installation).
     *
     * If @n exceeds the total number of devices, return all devices available sorted by the given criterion.
     *
     * @throws IllegalArgumentException in case @n is a negative number.
     */
    public Collection<SmartDevice> getFirstNDevicesByRegistration(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        throw new UnsupportedOperationException();
    }
}
