package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleAutonomous extends CommandGroup {
	public MiddleAutonomous() {
			addSequential(new SolenoidShift(1));
			addSequential(new DriveFor(50, 0.4, 0.6));//last number is right speed modifier
			addSequential(new DriveFor(12, 0.4, 0.55));
//			addSequential(new TurnFor("L", 24));
//			addSequential(new DriveFor(36, 0.2, 0.87));
			addSequential(new TurnFor(Robot.gameData.charAt(0)));
			addSequential(new DriveFor(35, 0.2, 0.87));
			addSequential(new SolenoidShift(0));
			
			//addSequential(new DriveUntil(30, 0.2));
	}
}
