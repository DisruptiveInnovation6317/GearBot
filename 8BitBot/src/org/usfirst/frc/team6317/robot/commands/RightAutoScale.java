package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAutoScale extends CommandGroup {
	public RightAutoScale() {
		// Keeps from being able to move the lift during auto
		this.requires(Robot.LiftSubsystem);
		// Drives the robot forward either 130 inches or 90 inches
		// If the scale direction is left then it drives 130 inches
		// If the scale direction is not left then it drives 90 to get to the switch
		addSequential(new DriveFor(() -> Direction.fromChar(Robot.gameData.charAt(1)), (dir) -> dir == Direction.RIGHT ? -220 : -50, -0.75));
		
		// Lifts the lift up to the highest position and drops tines
		addParallel(new MoveTines(false));
		addSequential(new LiftTime(2.5, 1));
		// Holds the lift at that position
		addParallel(new LiftTime(5, 0.25));
		
		// Turns the robot ~160 degrees
		addSequential(new GyroTurnCommand(-47, 1, 0.5, true, true));
		
		// Moving toward the switch or the scale
		// Moves the robot forward above the scale if the scale is our color
		addSequential(new DriveFor(() -> Direction.fromChar(Robot.gameData.charAt(1)), (dir) -> dir == Direction.RIGHT ? -26 : 0, -0.5));
		// Moves the robot forward above the switch if the switch is our color
		addSequential(new DriveFor(() -> Direction.fromChar(Robot.gameData.charAt(0)), (dir) -> dir == Direction.RIGHT ? -26 : 0, -0.5));
//		addSequential(new DriveFor(-26, -0.5));
		
		// Drops the cube
		addSequential(new SolenoidShift(1));
		
		// Waits 1/2 a second to back up
		addSequential(new WaitTimer(0.5));
		
		// Backing up from the switch/scale
		// Moves the robot backward if the scale is our color
		addSequential(new DriveFor(() -> Direction.fromChar(Robot.gameData.charAt(1)), (dir) -> dir == Direction.RIGHT ? 24 : 0, 0.35));
	}
}
