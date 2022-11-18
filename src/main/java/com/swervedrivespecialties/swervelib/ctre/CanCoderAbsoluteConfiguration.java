package com.swervedrivespecialties.swervelib.ctre;

public class CanCoderAbsoluteConfiguration {
    private final int id;
    private final double offset;
    private final String canBusName;

    public CanCoderAbsoluteConfiguration(int id, double offset, String canBusName) {
        this.id = id;
        this.offset = offset;
        this.canBusName = canBusName;
    }

    public int getId() {
        return id;
    }

    public double getOffset() {
        return offset;
    }

    public String getCanBusName() {
        return canBusName;
    }
}
