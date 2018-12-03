package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MovingTines extends Command {
	private final int state;
	
	public MovingTines(int state) {
		this.state = state;
	}
	
	@Override
	protected void initialize() {
		if (this.state == 0 )
			Robot.LiftSubsystem.pivotArm.set(1.0);
		if (this.state == 1)
			Robot.LiftSubsystem.pivotArm.set(-1.0);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		Robot.LiftSubsystem.pivotArm.set(0);
	}

}
