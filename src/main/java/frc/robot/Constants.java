// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {

    public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.491; // NAV Measure and set trackwidth
    // public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.55; //SWERVEE; //
    // NAV Measure and set trackwidth

    /**
     * The front-to-back distance between the drivetrain wheels.
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_WHEELBASE_METERS = 0.491; // NAV Measure and set wheelbase
    // public static final double DRIVETRAIN_WHEELBASE_METERS = 0.47; //SWERVEE; //
    // NAV Measure and set wheelbase

    public static final double DRIVESPEED_MODIFIER = 0.5;
    public static final double PXCONTROLLER = 1.0;
    public static final double PYCONTROLLER = 1.0;
    public static final double PTHETACONTROLLER = 1.0;
    public static final TrapezoidProfile.Constraints PTHETACONTROLLERCONSTRAINTS = new TrapezoidProfile.Constraints(
            DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND);

    public static final int DRIVETRAIN_PIGEON_ID = 29; // NAV Set Pigeon ID

    public static final String CANIVORE_CAN_BUS_NAME = "FastFD"; // TEMP
    public static final String RIO_CAN_BUS_NAME = "rio";
    public static final String DRIVETRAIN_CAN_BUS_NAME = CANIVORE_CAN_BUS_NAME;

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 1; // NAV Set front left module drive motor ID
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 11; // NAV Set front left module steer motor ID
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 21; // NAV Set front left steer encoder ID
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(2.279663); // NAV Measure and set front
                                                                                           // left steer offset
    // public static final double FRONT_LEFT_MODULE_STEER_OFFSET =
    // -Math.toRadians(-170.155906); // SWERVEE; // NAV Measure and set front left
    // steer offset

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 2; // NAV Set front right drive motor ID
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 12; // NAV Set front right steer motor ID
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 22; // NAV Set front right steer encoder ID
    // public static final double FRONT_RIGHT_MODULE_STEER_OFFSET =
    // -Math.toRadians(261.914062); // NAV Measure and set front right steer offset
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(35.156179); // SWERVEE // NAV Measure
                                                                                             // and set front right
                                                                                             // steer offset

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 3; // NAV Set back left drive motor ID
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 13; // NAV Set back left steer motor ID
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 23; // NAV Set back left steer encoder ID
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(59.501940); // NAV Measure and set back
                                                                                           // left steer offset
    // public static final double BACK_LEFT_MODULE_STEER_OFFSET =
    // -Math.toRadians(125.859121); // SWERVEE; // NAV Measure and set back left
    // steer offset

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 4; // NAV Set back right drive motor ID
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 14; // NAV Set back right steer motor ID
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 24; // NAV Set back right steer encoder ID
    // public static final double BACK_RIGHT_MODULE_STEER_OFFSET =
    // -Math.toRadians(259.359741); // NAV Measure and set back right steer offset
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(-25.751901); // SWERVEE; // NAV Measure
                                                                                             // and set back right steer
                                                                                             // offset

    public static final int LEFT_SHOOTER = 5;
    public static final int RIGHT_SHOOTER = 6;
    public static final int INTAKE_MOTOR = 7;
    public static final int ARM_MOTOR = 8;
    public static final int XBOX_CONTROLLER_PORT = 0;
    public static final int XBOX_2_CONTROLLER_PORT = 1;

    public static final int LEFT_FIXED_MOTOR = 17;
    public static final int RIGHT_FIXED_MOTOR = 16;
    public static final int LEFT_ARTICULATING_MOTOR = 18;
    public static final int RIGHT_ARTICULATING_MOTOR = 15;

    public static final int TOP_INDEX_MOTOR = 19;
    public static final int BOTTOM_INDEX_MOTOR = 26;

    public static final PneumaticsModuleType PCM1 = null;
    public static final PneumaticsModuleType PCM2 = null;
    public static final PneumaticsModuleType PCM = null;

    public static final int FIXED_ARM_UPPER_LIMIT = 24576;
    public static final int FIXED_ARM_LOWER_LIMIT = 0;
    public static final int ARTICULATING_ARM_UPPER_LIMIT = 24576;
    public static final int ARTICULATING_ARM_LOWER_LIMIT = 0;

    public static final double LIMELIGHT_TOLERANCE = 0.1;
    public static final int PCM_INTAKE = 30;
    public static final int TURRET_MOTOR = 8;
    public static final double TURRET_POWER = 0.2; // 50% power

    public static final int REVERSE_CHANNEL_LEFT_ARM = 0;
    public static final int REVERSE_CHANNEL_RIGHT_ARM = 2;
    public static final int FORWARD_CHANNEL_LEFT_ARM = 1;
    public static final int FORWARD_CHANNEL_RIGHT_ARM = 3;
    public static final int FORWARD_CHANNEL_LEFT = 4;
    public static final int REVERSE_CHANNEL_LEFT = 5;
    public static final int FORWARD_CHANNEL_RIGHT = 6;
    public static final int REVERSE_CHANNEL_RIGHT = 7;

    public static final int CONTROLLER_A_BUTTON_ID = 1;
    public static final int CONTROLLER_B_BUTTON_ID = 2;
    public static final int CONTROLLER_X_BUTTON_ID = 3;
    public static final int CONTROLLER_Y_BUTTON_ID = 4;
    public static final int CONTROLLER_LEFT_BUMPER_ID = 5;
    public static final int CONTROLLER_RIGHT_BUMPER_ID = 6;
    public static final int CONTROLLER_BACK_BUTTON_ID = 7;
    public static final int CONTROLLER_START_BUTTON_ID = 8;
    public static final int CONTROLLER_LEFT_JOYSTICK_BUTTON_ID = 9;
    public static final int CONTROLLER_RIGHT_JOYSTICK_BUTTON_ID = 10;

    public static final String DRIVER_READOUT_TAB_NAME = "Driver Readout";

}
