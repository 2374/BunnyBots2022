package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class RaiseArmCommand extends CommandBase{
    private final ArmSubsystem m_armSubsystem;

    public RaiseArmCommand(ArmSubsystem armSubsystem) {
        this.m_armSubsystem = armSubsystem;
        addRequirements(m_armSubsystem);
    }

    public void initialize() {
        m_armSubsystem.raiseArm();
    }

    public void execute() {
        if (m_armSubsystem.getArmPosition() <= 0) {
            end();
        }
    }

    public void end() {
        m_armSubsystem.stopArm();
    }
}
