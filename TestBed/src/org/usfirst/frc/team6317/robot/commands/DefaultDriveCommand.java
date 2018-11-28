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
		//sets robot to drive depending on how far forward the joy sticks are pushed
		Robot.DriveSubsystem.drive(OI.leftStick.getY(), OI.rightStick.getY());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
