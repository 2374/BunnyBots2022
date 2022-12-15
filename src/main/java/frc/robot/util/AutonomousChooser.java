package frc.robot.util;

// import java.util.function.BooleanSupplier;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.RobotContainer;
import frc.robot.commands.*;
import frc.common.control.Path;
import frc.common.control.Trajectory;

public class AutonomousChooser {
    private final AutonomousTrajectories trajectories;

    private final SendableChooser<AutonomousMode> autonomousModeChooser = new SendableChooser<>();

    public AutonomousChooser(AutonomousTrajectories trajectories) {
        this.trajectories = trajectories;

        autonomousModeChooser.setDefaultOption("1 meter F", AutonomousMode.ONE_METER_F);
        autonomousModeChooser.addOption("1 meter B", AutonomousMode.ONE_METER_B);
        autonomousModeChooser.addOption("Figure Eight", AutonomousMode.FIGURE_EIGHT);
    }

    public SendableChooser<AutonomousMode> getModeChooser() {
        return autonomousModeChooser;
    }

    public Command getOneMeterFAuto(RobotContainer container) {
        SequentialCommandGroup command = new SequentialCommandGroup();

        resetRobotPose(command, container, trajectories.getOneMeterF());

        command.addCommands(follow(container, trajectories.getOneMeterF()));

        return command;
    }

    public Command getOneMeterBAuto(RobotContainer container) {
        SequentialCommandGroup command = new SequentialCommandGroup();

        resetRobotPose(command, container, trajectories.getOneMeterB());

        command.addCommands(follow(container, trajectories.getOneMeterB()));

        return command;
    }

    public Command getFigureEightAuto(RobotContainer container) {
        SequentialCommandGroup command = new SequentialCommandGroup();

        resetRobotPose(command, container, trajectories.getFigureEight());

        command.addCommands(follow(container, trajectories.getFigureEight()));
        command.addCommands(follow(container, null));

        return command;
    }

    // private void shootAtTarget(SequentialCommandGroup command, RobotContainer
    // container, double timeToWait) {
    // command.addCommands(new TargetWithShooterCommand(container.getShooter(),
    // container.getVision())
    // .alongWith(new AlignRobotToShootCommand(container.getDrivetrain(),
    // container.getVision()))
    // .alongWith(new WaitCommand(0.1).andThen(new
    // ShootWhenReadyCommand(container.getFeeder(),
    // container.getShooter(), container.getVision())))
    // .withTimeout(timeToWait));
    // }

    private Command follow(RobotContainer container, Trajectory trajectory) {
        return new FollowTrajectoryCommand(container.getDrivetrain(), trajectory);
    }

    // private Command followAndIntake(RobotContainer container, Trajectory
    // trajectory) {
    // return followAndIntake(container, trajectory, () -> true, 0.0);
    // }

    // private Command followAndIntake(RobotContainer container, Trajectory
    // trajectory, BooleanSupplier condition,
    // double conditionTimeout) {
    // return new FollowTrajectoryCommand(container.getDrivetrain(), trajectory)
    // .andThen(new WaitUntilCommand(condition).withTimeout(conditionTimeout))
    // .deadlineWith(new SimpleIntakeCommand(container.getIntake(),
    // container.getFeeder(),
    // container.getController()), new DefaultFeederCommand(container.getFeeder()));
    // }

    public void resetRobotPose(SequentialCommandGroup command, RobotContainer container, Trajectory trajectory) {
        Path.State start = trajectory.getPath().calculate(0.0);
        command.addCommands(new InstantCommand(() -> container.getDrivetrain().setPose(new Pose2d(start.getPosition().x,
                start.getPosition().y, new Rotation2d(start.getRotation().toRadians())))));
    }

    public Command getCommand(RobotContainer container) {
        switch (autonomousModeChooser.getSelected()) {
            case ONE_METER_F:
                return getOneMeterFAuto(container);
            case ONE_METER_B:
                return getOneMeterBAuto(container);
            case FIGURE_EIGHT:
                return getFigureEightAuto(container);
        }
        return new InstantCommand();
    }

    private enum AutonomousMode {
        ONE_METER_F, ONE_METER_B, FIGURE_EIGHT
    }
}