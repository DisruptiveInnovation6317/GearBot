package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6317.robot.Robot;

/**
 *
 */
public class BreakIn extends Command {
	double centimetersToTravel;
	
	public BreakIn(double centimeters) {
		requires(Robot.DriveSubsystem);
		requires(Robot.SensorSubsystem);
		centimetersToTravel = centimeters;
	}

	protected void initialize() {
		if (!isFinished())
			Robot.DriveSubsystem.drive(0.5);
	}

	protected boolean isFinished() {
		return Robot.SensorSubsystem.getDistanceCenti() <= centimetersToTravel;
	}

	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}
