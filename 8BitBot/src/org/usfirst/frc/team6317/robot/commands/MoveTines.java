package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MoveTines extends Command {
	private double timeToMove = 3, startTime;
	private final boolean down;
	private Timer frcTimer;
	
	public MoveTines(boolean down) {
		this.down = down;
		this.frcTimer = new Timer();
	}
	
	@Override
	protected void initialize() {
		frcTimer.start();
		startTime = Timer.getFPGATimestamp();
		if (down)
			Robot.LiftSubsystem.setPivot(0.75);
		else if (!down)
			Robot.LiftSubsystem.setPivot(-0.75);
	}
	
	@Override
	protected boolean isFinished() {
		return (Timer.getFPGATimestamp() - startTime) > timeToMove;
	}
	
	@Override
	protected void end() {
		Robot.LiftSubsystem.setPivot(0);
	}
}
