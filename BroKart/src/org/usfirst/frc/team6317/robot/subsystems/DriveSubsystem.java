package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.commands.DefaultDriveCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	//initalze speed controllers for motors
	public SpeedController leftFront = new Victor(RobotMap.Motors.LEFT_FRONT);
	public SpeedController leftBack = new Victor(RobotMap.Motors.LEFT_BACK);
	public SpeedController rightFront = new Victor(RobotMap.Motors.RIGHT_FRONT);
	public SpeedController rightBack = new Victor(RobotMap.Motors.RIGHT_BACK);
	public static double speedMultiplier = 0;
	
	{
		//inverts left side
		leftFront.setInverted(true);
		leftBack.setInverted(true);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DefaultDriveCommand());
	}
	
	public void drive(double y, double x, double z, double throttle) {
		this.speedMultiplier = throttle;
		
		speedMultiplier += 1;
		speedMultiplier = Math.abs((speedMultiplier / 2) - 1);
		z *= 0.75;
		
//		if (Math.abs(z) < 0.3) {
//			z = 0;
//		} 
		//2 down, 4 up
		
//		double multiplier = ((Math.abs(x)) > Math.abs(y) ? Math.abs(x) : Math.abs(y));
		
//		double multiplier = 1;
//		multiplier = multiplier * throttle;
		
		leftFront.set(clip(-z + y - x) * speedMultiplier);
		leftBack.set(clip(-z + y + x)* speedMultiplier);
		rightBack.set(clip(z + y - x)* speedMultiplier);
		rightFront.set(clip(z + y + x)* speedMultiplier);
	}
	
	private double clip (double speed) {
		return (speed > 1 ? 1 : speed < -1 ? -1 : speed);
	}
	
	public void stop() {
		drive(0, 0, 0, 0);
	}
}
