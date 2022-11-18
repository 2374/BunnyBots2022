package frc.robot.util;

// import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriverReadout {

    public DriverReadout(RobotContainer container) {
        ShuffleboardTab tab = Shuffleboard.getTab(Constants.DRIVER_READOUT_TAB_NAME);

        // tab.addNumber("Pressure", () -> container.getSuperstructure().getCurrentPressure()).withSize(2, 2)
        //         .withPosition(0, 0).withWidget(BuiltInWidgets.kDial);
        tab.add("Autonomous Mode", container.getAutonomousChooser().getModeChooser()).withSize(2, 1).withPosition(2, 0);
        // tab.add("Climb Mode", container.getClimbChooser().getClimbChooser()).withSize(2, 1).withPosition(0, 2);
        tab.addCamera("Camera", "Camera", "http://limelight.local:5800", "http://10.23.74.11:5800").withSize(3, 3)
                .withPosition(4, 0);
    }
}
