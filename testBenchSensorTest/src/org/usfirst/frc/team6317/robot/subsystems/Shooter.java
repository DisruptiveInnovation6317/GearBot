package org.usfirst.frc.team6317.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6317.robot.*;

public class Shooter extends Subsystem {
	public boolean shooting = false;	
	
	@Override
	public void initDefaultCommand(){
		
	}
	
	public void runShooter(double speed){
		RobotMap.shooterMotor.set(speed);
		shooting = true;
	}
	
	public void runShooter() {
		runShooter(-1);
	}
	
	public void stopShooter(){
		RobotMap.shooterMotor.set(0);
		shooting = false;
	}
	public void reverseShooter(){
		runShooter(1);
	}
}
