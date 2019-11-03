package bg.sofia.uni.fmi.mjt.smartcity.enums;

import org.jetbrains.annotations.Contract;

public enum DeviceType {
    TRAFFIC_LIGHT("TFL"),
    LAMP("LM"),
    CAMERA("CM");

    private final String shortName;

    @Contract(pure = true)
    private DeviceType(String shortName) {
        this.shortName = shortName;
    }

    @Contract(pure = true)
    public String getShortName() {
        return shortName;
    }
}
