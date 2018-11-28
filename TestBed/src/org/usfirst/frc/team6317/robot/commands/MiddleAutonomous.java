package org.usfirst.frc.team6317.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleAutonomous extends CommandGroup {
	public MiddleAutonomous() {
			//lowers piston
			addSequential(new SolenoidShift(4));
			//drives for 50 inches
			addSequential(new DriveFor(5, 0.5, 0.8));//last number is right speed modifier
			//drives for ___ inches at a lower speed to turn more left
//			addSequential(new DriveFor(15, 0.5, 0.57));
			//determines how to turn in auto depending on how the gamedata is
			addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)), 65));
			addSequential(new DriveFor(10, 0.5, 0.87));
			addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)).opposite(), 70));
			//drives forward until sensor returns
			addSequential(new DriveFor(20, 0.5, 0.87));
			//pops piston
			addSequential(new SolenoidShift(5));
			}
}
