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
		Robot.LiftSubsystem.setLift(OI.controlStick.getY());
		if (Math.abs(OI.controlStick.getThrottle()) > 0.1)
			Robot.LiftSubsystem.setPivot(OI.controlStick.getThrottle());
		else 
			Robot.LiftSubsystem.setPivot(0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
