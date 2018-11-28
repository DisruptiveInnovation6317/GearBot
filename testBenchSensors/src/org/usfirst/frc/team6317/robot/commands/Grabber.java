package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Grabber extends Command {

	public Grabber() {
		this.requires(Robot.Shifter);
	}
	
	@Override
	protected void initialize() {
		if (Robot.isOpen)
			Robot.Shifter.closeArm();
		if (!Robot.isOpen)
			Robot.Shifter.openArm();
	}
	
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		Robot.isOpen = !Robot.isOpen;
	}
}
