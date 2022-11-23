package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeederSubsystem;

public class ManualFeedToShooterCommand extends CommandBase {
    private static final double FEEDER_SPEED = 0.5;

    private final FeederSubsystem feeder;

    public ManualFeedToShooterCommand(FeederSubsystem feeder) {
        this.feeder = feeder;

        addRequirements(feeder);
    }

    @Override
    public void execute() {
        feeder.setFeederSpeed(FEEDER_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        feeder.setFeederSpeed(0.0);
    }
}
