package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuto extends CommandGroup {
	public TestAuto() {
		addSequential(new SolenoidShift(4));
		addSequential(new DriveFor(24, 0.5));
		addSequential(new TurnFor("R", 12));
		addSequential(new DriveFor(25, 0.5));
		addSequential(new TurnFor("L", 12));
		addSequential(new DriveUntil(30, 0.5));
		addSequential(new SolenoidShift(5));
	}
}
