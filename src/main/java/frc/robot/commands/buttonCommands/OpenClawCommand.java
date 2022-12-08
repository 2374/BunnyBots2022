package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class OpenClawCommand extends CommandBase {
    private final ClawSubsystem m_clawSubsystem;

    public OpenClawCommand(ClawSubsystem clawSubsystem) {
        m_clawSubsystem = clawSubsystem;
        addRequirements(m_clawSubsystem);
    }

    public void initialize() {
        m_clawSubsystem.openClaw();
    }

    public void end(boolean interupted) {
        m_clawSubsystem.stopClaw();
    }
}
