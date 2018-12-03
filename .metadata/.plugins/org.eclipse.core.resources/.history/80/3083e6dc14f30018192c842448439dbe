package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TestingAuto extends Command {
	public boolean isLeft = false;
	public TestingAuto(boolean shouldBeLeft) {
		requires(Robot.DriveSubsystem);
		isLeft = shouldBeLeft;
	}

	@Override
	protected void initialize() {
		if (isLeft) {
			Robot.DriveSubsystem.drive(0.5, 0);
		} else {
			Robot.DriveSubsystem.drive(0, 0.5);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}
