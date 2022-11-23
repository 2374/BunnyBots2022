package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeederSubsystem;

public class DefaultFeederCommand extends CommandBase {
    private static final double MAX_FEEDER_SPEED = 0.75;

    private final FeederSubsystem feeder;

    public DefaultFeederCommand(FeederSubsystem feeder) {
        this.feeder = feeder;
        addRequirements(feeder);
    }

    @Override
    public void execute() {
        if (!feeder.isFull() && feeder.isBallAtEntry()) {
            feeder.setFeederSpeed(MAX_FEEDER_SPEED);
        } else {
            feeder.setFeederSpeed(0.0);
        }
    }
}
