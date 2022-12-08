package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class CloseClawCommand extends CommandBase {
    private final ClawSubsystem m_clawSubsystem;

    public CloseClawCommand(ClawSubsystem clawSubsystem) {
        m_clawSubsystem = clawSubsystem;
        addRequirements(m_clawSubsystem);
    }

    public void initialize() {
        m_clawSubsystem.closeClaw();
    }

    public void end(boolean interupted) {
        m_clawSubsystem.stopClaw();
    }
}
