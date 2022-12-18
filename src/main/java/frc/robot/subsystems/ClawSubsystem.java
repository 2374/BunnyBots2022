package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {

    private ClawSubsystem instance;
    private WPI_TalonFX clawMotor;

    public ClawSubsystem() {
        clawMotor = new WPI_TalonFX(Constants.CLAW_MOTOR_PORT, Constants.CANIVORE_CAN_BUS_NAME);
        clawMotor.setNeutralMode(NeutralMode.Brake);
    }

    public ClawSubsystem getClawInstance() {
        if (instance == null) {
            instance = new ClawSubsystem();
        }
        return instance;
    }

    public void openClaw() {
        clawMotor.set(.5);
    }

    public void closeClaw() {
        clawMotor.set(-.5);
    }

    public void stopClaw() {
        clawMotor.stopMotor();
    }
}