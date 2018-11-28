package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAuto extends CommandGroup {
	public RightAuto() {
		// Initializes the needed Subsystems
		this.requires(Robot.DriveSubsystem);
		this.requires(Robot.SensorSubsystem);
		this.requires(Robot.Shifter);
		
		// Lowers the Piston
		addSequential(new SolenoidShift(1));
		// Drives the Robot to the auto line
//		addSequential(new DriveUntil(30, 0.65));
		// Fires the piston if the scale is correct
		if (Robot.gameData.length() > 0) {
			if (Robot.gameData.charAt(0) == 'R')
				addSequential(new SolenoidShift(0));
		}
	}
}
