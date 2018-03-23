package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleAutonomous extends CommandGroup {
	// Autonomous for the middle starting position for the switch
	public MiddleAutonomous() {
		this.requires(Robot.LiftSubsystem);
		
		// Lowers the piston at the start of the autonomous period
		addSequential(new SolenoidShift(4));
		// Drives the robot forward 5 inches to miss the vault zone
		addSequential(new DriveFor(5, 0.5, 0.8));//last number is right speed modifier
		// Turns the robot either left or right depending on what the game data is
		// First value is for left
		// Second value is for right
		addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)), (dir) -> dir == Direction.LEFT ? 45 : 55));
		// Drives the robot forward to avoid the power cubes
		addSequential(new DriveFor(() -> Direction.fromChar(Robot.gameData.charAt(0)), (dir) -> dir == Direction.LEFT ? 24 : 9, 0.5));
//		addSequential(new DriveFor(9, 0.5, 0.87));
		// Turns the robot either left or right depending on what the game data is to align it with the switch
		// First value is for right
		// Second value is for left
		addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)).opposite(), (dir) -> dir == Direction.LEFT ? 61 : 58));
		// Drives the robot forward until flush with the platform
		addSequential(new DriveUntil(30, 0.25));
		// Wait timer
		addSequential(new WaitTimer(0.5));
		// Fires the piston launching the power cube
		addSequential(new SolenoidShift(3));
	}
}
