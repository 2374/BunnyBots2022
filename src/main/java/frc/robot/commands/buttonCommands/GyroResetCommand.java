package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * Reset a gyro for a given subsystem, this will zero all gyro axis on the current
 * direction of the drivetrain.
 */
public class GyroResetCommand extends CommandBase {
    private final DrivetrainSubsystem m_drivetrainSubsystem;
    
    
    /** 
     * Reset the gyro for a give subsystem
     * @param drivetrainSubsystem the drivetrain to reset the gryo for
     */
    public GyroResetCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.m_drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    /**
     * Zero the gyro for the give drive train
     */
    @Override
    public void execute() {
        m_drivetrainSubsystem.zeroRotation();
        cancel();
    }

    
    /** 
     * End reseting the gyro, effectively a no-op
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {
    }
}
