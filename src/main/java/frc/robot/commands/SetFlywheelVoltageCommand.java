package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class SetFlywheelVoltageCommand extends CommandBase {
    private final ShooterSubsystem shooter;
    private final double voltage;

    public SetFlywheelVoltageCommand(ShooterSubsystem shooter, double voltage) {
        this.shooter = shooter;
        this.voltage = voltage;

        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setFlywheelVoltage(voltage);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.setFlywheelVoltage(0.0);
    }
}
