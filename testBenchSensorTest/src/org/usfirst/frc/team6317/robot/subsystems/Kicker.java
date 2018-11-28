package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Kicker extends Subsystem {
	public boolean kicking = false;

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void runkick(){
		RobotMap.kickerMotor1.set(1);
		RobotMap.kickerMotor2.set(1);
		kicking = true;
		
	}
	public void stopkick(){
		RobotMap.kickerMotor1.set(0);
		RobotMap.kickerMotor2.set(0);
		kicking = false;
	}

}
