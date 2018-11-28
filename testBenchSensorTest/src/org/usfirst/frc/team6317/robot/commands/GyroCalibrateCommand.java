package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroCalibrateCommand extends Command {
	private long endTime;
	private double time;
	private boolean done = false;
	
	public GyroCalibrateCommand(double time) {
		this.time = time;
	}

	@Override
	protected void execute() {
		if (!Robot.gyro.isCalibrating()) {
			Robot.gyro.calibrate();
			this.endTime = System.currentTimeMillis() + (long)(this.time*1000);
		} else if (System.currentTimeMillis() >= this.endTime) {
			Robot.gyro.endCalibrate();
			this.done = true;
		}
	}
	
	@Override
	protected boolean isFinished() {
		return this.done;
	}

}
