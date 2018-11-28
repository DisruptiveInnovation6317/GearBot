package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6317.robot.Robot;

/**
 *
 */
public class DriveUntil extends Command {
	private final double centimetersToTravelTo, speed;
	
	public DriveUntil(double centimeters) {
		requires(Robot.DriveSubsystem);
		requires(Robot.SensorSubsystem);
		centimetersToTravelTo = centimeters;
		this.speed = 0.5;
	}
	
	public DriveUntil(double centimeters, double speed) {
		requires(Robot.DriveSubsystem);
		requires(Robot.SensorSubsystem);
		centimetersToTravelTo = centimeters;
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		//drives until is finished() returns true
		if (!isFinished()) Robot.DriveSubsystem.backDrive(this.speed, 0.87);
	}

	@Override
	protected boolean isFinished() {
		//drives untl the sensor distance is less than specified
		return Robot.SensorSubsystem.getDistanceCenti() <= centimetersToTravelTo;
	}

	@Override
	protected void end() {
		//at the end it stops the robot
		Robot.DriveSubsystem.stop();
	}
}
