package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAuto extends CommandGroup {
	// Autonomous for the right starting zone for the right switch
	public RightAuto() {
		// Drives to the baseline
		addSequential(new DriveFor(-120, -0.25));
	}
}
