package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LiftTesting extends CommandGroup {
	public LiftTesting() {
		addParallel(new MoveTines(true));
		addSequential(new LiftTime(2.75, 1));
		addParallel(new LiftTime(5, 0.25));
		addSequential(new SolenoidShift(1));
	}
}
