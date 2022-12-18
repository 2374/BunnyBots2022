package frc.robot;

import edu.wpi.first.math.util.Units;

public class Constants {
    public static final String CANIVORE_CAN_BUS_NAME = "FastFD";
    public static final String RIO_CAN_BUS_NAME = "rio";
    public static final String DRIVETRAIN_CAN_BUS_NAME = CANIVORE_CAN_BUS_NAME;

    public static final int CONTROLLER_PORT = 0;

    public static final int ARM_MOTOR_PORT = 8;

    public static final int FEEDER_SENSOR_FULL_PORT = 0; // 1;
    public static final int FEEDER_SENSOR_ENTRY_PORT = 0;

    public static final double DRIVETRAIN_TRACKWIDTH_METERS = Units.inchesToMeters(19.5);
    public static final double DRIVETRAIN_WHEELBASE_METERS = Units.inchesToMeters(19.75);
    public static final int DRIVETRAIN_PIGEON_ID = 29; // 1;

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 2; // 7;
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 12; // 8;
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 22; // 4;
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(127.64 + 180.0);
    // public static final double FRONT_LEFT_MODULE_STEER_OFFSET =
    // -Math.toRadians(90.87 + 180.0);

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 4; // 3;
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 14; // 4;
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 24; // 3;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(65.96 + 180.0);
    // public static final double FRONT_RIGHT_MODULE_STEER_OFFSET =
    // -Math.toRadians(35.59 + 180.0);

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 1; // 5;
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 11; // 6;
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 21; // 2;
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(93.24 + 180.0);
    // public static final double BACK_LEFT_MODULE_STEER_OFFSET =
    // -Math.toRadians(110.21 + 180.0);

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 3; // 1;
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 13; // 2;
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 23; // 1;
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(146.59 + 180.0);
    // public static final double BACK_RIGHT_MODULE_STEER_OFFSET =
    // -Math.toRadians(78.13 + 180.0);

    public static final int HOOD_MOTOR_PORT = 0; // 14;
    public static final int FLYWHEEL_PRIMARY_MOTOR_PORT = 0; // 15;
    public static final int FLYWHEEL_SECONDARY_MOTOR_PORT = 0; // 9;

    public static final double HOOD_MANUAL_ADJUST_INTERVAL = Math.toRadians(0.5);
    public static final double FLYWHEEL_MANUAL_ADJUST_INTERVAL = Units.rotationsPerMinuteToRadiansPerSecond(25.0);

    public static final double HOOD_MOTOR_TO_HOOD_GEAR_RATIO = 1;
    public static final double HOOD_SHOOTING_ALLOWABLE_ERROR = Math.toRadians(0.5);
    public static final double HOOD_CLIMBING_ALLOWABLE_ERROR = Math.toRadians(1.0);

    public static final double ARM_LIMIT = 0;

    public static final String SHOOTER_OFFSET_ENTRY_NAME = "Shooting Offset";
    public static final String HOOD_OFFSET_ENTRY_NAME = "Hood Offset";
    public static final String DRIVER_READOUT_TAB_NAME = "Driver Readout";
    public static final int CLAW_MOTOR_PORT = 17;
}
