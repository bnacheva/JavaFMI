package bg.sofia.uni.fmi.mjt.smartcity.device;

import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class SmartLamp implements SmartDevice {
    private String id;
    private String name;
    private Double powerConsumption;
    private LocalDateTime installationDateTime;
    private DeviceType deviceType;
    private int deviceCounter = 0;

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(@NotNull SmartDevice device) {
        this.id = device.getType().getShortName() + "-" + device.getName() + "-" + this.deviceCounter;
        this.deviceCounter++;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerConsumption() {
        return this.powerConsumption;
    }

    @Override
    public LocalDateTime getInstallationDateTime() {
        return this.installationDateTime;
    }

    @Override
    public DeviceType getType() {
        return this.deviceType;
    }

    @Contract(pure = true)
    public SmartLamp(String name, double powerConsumption, LocalDateTime installationDateTime) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.installationDateTime = installationDateTime;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SmartLamp)) {
            return false;
        }
        SmartLamp smartLamp = (SmartLamp) o;
        return smartLamp.getId() == ((SmartLamp) o).getId();
    }
}
