package org.usfirst.frc.team6317.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6317.robot.*;
import org.usfirst.frc.team6317.robot.commands.WinchCommand;

public class WinchSystem extends Subsystem{
	public void initDefaultCommand(){
		this.setDefaultCommand(new WinchCommand());
	}
	
	public void goingUp(){ //makes the winch motor reel in
		RobotMap.winchMotor.set(1);
	}
	
	public void goingDown(){ //makes the winch motor unreel
		RobotMap.winchMotor.set(-1);
	}
	
	public void stopWinch(){ //makes the winch motor stop
		RobotMap.winchMotor.set(0);
	}
}
