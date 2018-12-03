package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.OI;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultDriveCommand extends Command {
	
	public DefaultDriveCommand() {
		requires(Robot.DriveSubsystem);
	}
	
	@Override
	protected void execute() {
		Robot.DriveSubsystem.oneStickDrive(OI.leftStick.getY(), OI.leftStick.getX());
//		Robot.DriveSubsystem.drive(OI.leftStick.getY(), OI.rightStick.getY());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
