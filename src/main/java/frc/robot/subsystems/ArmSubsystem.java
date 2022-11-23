package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    private WPI_TalonFX armMotor;
    private boolean brakeMode = true;

    private ArmSubsystem instance;

    public ArmSubsystem() {
        armMotor = new WPI_TalonFX(Constants.ARM_MOTOR_PORT, Constants.CANIVORE_CAN_BUS_NAME);
        armMotor.setNeutralMode(NeutralMode.Brake);
        armMotor.setSelectedSensorPosition(0);
    }

    public ArmSubsystem getArmInstance() {
        if (instance == null) {
            instance = new ArmSubsystem();
        }
        return instance;
    }

    public double getArmPosition() {
        return armMotor.getSelectedSensorPosition();
    }

    public void raiseArm() {
        armMotor.set(-1);
    }

    public void lowerArm() {
        armMotor.set(1);
    }

    public void stopArm() {
        armMotor.stopMotor();
    }

    public void toggleBrakeMode() {
        if (brakeMode)
            armMotor.setNeutralMode(NeutralMode.Coast);
        else
            armMotor.setNeutralMode(NeutralMode.Brake);
    }

}
