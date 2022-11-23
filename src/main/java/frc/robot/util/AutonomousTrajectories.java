package frc.robot.util;

import edu.wpi.first.math.util.Units;
import frc.common.control.SimplePathBuilder;
import frc.common.control.Trajectory;
import frc.common.control.TrajectoryConstraint;
import frc.common.math.Rotation2;
import frc.common.math.Vector2;

public class AutonomousTrajectories {

    private static final double SAMPLE_DISTANCE = Units.inchesToMeters(0.1);

    private final Trajectory oneMeterF;
    private final Trajectory oneMeterB;

    public AutonomousTrajectories(TrajectoryConstraint[] trajectoryConstraints) {
        oneMeterF = new Trajectory(
                new SimplePathBuilder(new Vector2(0.0, 0.0), Rotation2.fromDegrees(0.0))
                        .lineTo(new Vector2(1.0, 0.0)).build(),
                trajectoryConstraints, SAMPLE_DISTANCE);
        oneMeterB = new Trajectory(
                new SimplePathBuilder(new Vector2(0.0, 0.0), Rotation2.fromDegrees(0.0))
                        .lineTo(new Vector2(-1.0, 0.0)).build(),
                trajectoryConstraints, SAMPLE_DISTANCE);

    }

    public Trajectory getOneMeterF() {
        return oneMeterF;
    }

    public Trajectory getOneMeterB() {
        return oneMeterB;
    }

}
