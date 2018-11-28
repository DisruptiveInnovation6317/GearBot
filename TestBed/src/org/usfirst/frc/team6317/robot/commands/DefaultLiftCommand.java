package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.OI;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultLiftCommand extends Command {
	
	public DefaultLiftCommand() {
		requires(Robot.LiftSubsystem);
	}
	
	@Override
	protected void execute() {
		//sets pivot, and life speeds
		Robot.LiftSubsystem.setLift(OI.controlStick.getThrottle());
		Robot.LiftSubsystem.setPivot(OI.controlStick.getY());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
