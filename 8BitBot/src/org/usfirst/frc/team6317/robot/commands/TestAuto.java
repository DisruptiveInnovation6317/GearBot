package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuto extends CommandGroup {
	public TestAuto() {
		addSequential(new DriveUntil(50));
		addSequential(new TurnFor());
	}
}