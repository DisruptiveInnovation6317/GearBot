package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.OI;
import org.usfirst.frc.team6317.robot.Robot;
import org.usfirst.frc.team6317.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class WinchCommand extends Command {

	public WinchCommand(){
		this.requires(Robot.WinchSystem);
	}
	
	protected void initialize(){
	}
	
	protected void execute(){
		RobotMap.winchMotor.set(-OI.controlStick.getY());
		
		if(OI.controlStick.getPOV() != -1)
			Robot.WinchSystem.goingUp();
		/*else if(OI.controlStick.getPOV() == 180)
			Robot.WinchSystem.goingDown();*/
		else
			Robot.WinchSystem.stopWinch();
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
