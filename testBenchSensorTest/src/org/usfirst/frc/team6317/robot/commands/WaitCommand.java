package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class WaitCommand extends Command {
	private long endTime, waitTime;
	
	public WaitCommand(double seconds) {
		this.waitTime = (long) (seconds * 1000); 
	}
	
	@Override
	protected void initialize() {
		this.endTime = System.currentTimeMillis() + waitTime;
	}

	@Override
	protected boolean isFinished() {
		return System.currentTimeMillis() >= this.endTime;
	}

}
