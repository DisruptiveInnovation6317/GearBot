package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command{

	public int state;
	
	public IntakeCommand(int stateIn) {
		this.requires(Robot.IntakeSystem);
		state = stateIn;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if(state == 0)
			Robot.IntakeSystem.stopIntake();		
		if(state == 1)
			Robot.IntakeSystem.takingIn();
		if(state == 2)
			Robot.IntakeSystem.pushingOut();

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
