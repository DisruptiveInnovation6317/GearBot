package org.usfirst.frc.team6317.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
//robot map is where motor controllers connect to the RoboRio
public class RobotMap 
{
	public static SpeedController rightDrive1 = new Victor(0);		//motor controller is set to pin 0
	public static SpeedController rightDrive2 = new Victor(1);		//motor controller is set to pin 1
	public static SpeedController leftDrive1 = new Victor(2);		//motor controller is set to pin 2
	public static SpeedController leftDrive2 = new Victor(3);		//motor controller is set to pin 3
	public static SpeedController intakeMotorBottom = new Victor(4);//lower intake motor using pin 4
	public static SpeedController intakeMotorTop = new Victor(5);	//upper intake motor using pin 5
	public static SpeedController shooterMotor = new Victor(9);		//motor that runs shooter on pin 9
	public static SpeedController kickerMotor1 = new Victor(7);		//one of the feed motors for the shooting module on pin 7
	public static SpeedController kickerMotor2 = new Victor(8);		//one of the feed motors for the shooting module on pin 8
	public static SpeedController winchMotor = new Victor(6);		//controls the motor that will lift the whole robot on pin 6
}
