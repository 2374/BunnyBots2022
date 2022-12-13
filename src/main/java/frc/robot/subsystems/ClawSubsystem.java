package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {

    private ClawSubsystem instance;
    private WPI_TalonSRX clawMotor;

    public ClawSubsystem() {
        clawMotor = new WPI_TalonSRX(Constants.CLAW_MOTOR_PORT);
        clawMotor.setNeutralMode(NeutralMode.Brake);
    }

    public ClawSubsystem getClawInstance() {
        if (instance == null) {
            instance = new ClawSubsystem();
        }
        return instance;
    }

    public void openClaw() {
        clawMotor.set(.1);
    }

    public void closeClaw() {
        clawMotor.set(-.1);
    }

    public void stopClaw() {
        clawMotor.stopMotor();
    }
}