package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class LowerArmCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;

    public LowerArmCommand(ArmSubsystem armSubsystem) {
        this.m_armSubsystem = armSubsystem;
        addRequirements(m_armSubsystem);
    }

    public void initialize() {
        m_armSubsystem.lowerArm();
    }

    public void end(boolean interupted) {
        m_armSubsystem.stopArm();
    }
}
