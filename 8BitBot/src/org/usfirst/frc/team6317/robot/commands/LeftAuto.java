package org.usfirst.frc.team6317.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAuto extends CommandGroup {
	// Autonomous for the left starting zone for the left switch
	public LeftAuto() {
		// Drives to the baseline
		addSequential(new DriveFor(-120, -0.25));
	}
}
