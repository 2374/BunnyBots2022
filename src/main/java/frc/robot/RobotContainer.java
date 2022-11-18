// Jacob was here (Hello there, General Kenobi!)
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.buttonCommands.*;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
import frc.robot.util.AutonomousChooser;
import frc.robot.util.AutonomousTrajectories;

public class RobotContainer {
    // The robot's subsystems are defined here...
    private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
    private final ArmSubsystem m_armSubsystem = new ArmSubsystem();

    private static XboxController m_controller = new XboxController(Constants.XBOX_CONTROLLER_PORT);
    // private static XboxController m_ord = new
    // XboxController(Constants.XBOX_2_CONTROLLER_PORT); //at the speed of gene

    private AutonomousTrajectories autonomousTrajectories;
    private final AutonomousChooser autonomousChooser;

    private final SlewRateLimiter xLimiter = new SlewRateLimiter(.5);
    private final SlewRateLimiter yLimiter = new SlewRateLimiter(.5);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {

        autonomousTrajectories = new AutonomousTrajectories(DrivetrainSubsystem.TRAJECTORY_CONSTRAINTS);
        autonomousChooser = new AutonomousChooser(autonomousTrajectories);

        // Set up the default command for the drivetrain.
        // The controls are for field-oriented driving:
        // Left stick Y axis -> forward and backwards movement
        // Left stick X axis -> left and right movement
        // Right stick X axis -> rotation
        m_drivetrainSubsystem.setDefaultCommand(new DefaultDriveCommand(
                m_drivetrainSubsystem,
                () -> -yLimiter.calculate(modifyAxis(m_controller.getLeftY()))
                        * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
                () -> -xLimiter.calculate(modifyAxis(m_controller.getLeftX()))
                        * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
                () -> -m_controller.getRightX() * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND / 4.0));

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        // Drive
        new JoystickButton(m_controller, Constants.CONTROLLER_BACK_BUTTON_ID)
                .whenPressed(new GyroResetCommand(m_drivetrainSubsystem));
        new JoystickButton(m_controller, Constants.CONTROLLER_LEFT_BUMPER_ID)
                .whenPressed(new TurboModeToggleCommand(m_drivetrainSubsystem));

        // Arm
        new JoystickButton(m_controller, Constants.CONTROLLER_A_BUTTON_ID)
                .whenHeld(new RaiseArmCommand(m_armSubsystem));
        new JoystickButton(m_controller, Constants.CONTROLLER_Y_BUTTON_ID)
                .whenHeld(new LowerArmCommand(m_armSubsystem));

    }

    public void executeAutoCommands() {

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return autonomousChooser.getCommand(this);
    }

    private static double deadband(double value, double deadband) {
        if (Math.abs(value) > deadband) {
            if (value > 0.0) {
                return (value - deadband) / (1.0 - deadband);
            } else {
                return (value + deadband) / (1.0 - deadband);
            }
        } else {
            return 0.0;
        }
    }

    private double modifyAxis(double value) {
        // Deadband
        value = deadband(value, 0.1);

        // Square the axis
        value = Math.copySign(value * value, value);

        // TURBO MODE!
        if (m_drivetrainSubsystem.getTurboMode() && m_drivetrainSubsystem != null) {
            return value * 0.2;
        } else {
            return 0.1 * value;
        }
    }

    public DrivetrainSubsystem getDrivetrainSubsystem() {
        return m_drivetrainSubsystem;
    }

    public AutonomousChooser getAutonomousChooser() {
        return autonomousChooser;
    }

}