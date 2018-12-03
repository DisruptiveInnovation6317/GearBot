package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.commands.DefaultDriveCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	//initalze speed controllers for motors
	public SpeedController leftDriveOne = new Victor(RobotMap.Motors.LEFT_DRIVE_ONE);
	public SpeedController leftDriveTwo = new Victor(RobotMap.Motors.LEFT_DRIVE_TWO);
	public SpeedController rightDriveOne = new Victor(RobotMap.Motors.RIGHT_DRIVE_ONE);
	public SpeedController rightDriveTwo = new Victor(RobotMap.Motors.RIGHT_DRIVE_TWO);
	
	{
		//inverts left side
		leftDriveOne.setInverted(true);
		leftDriveTwo.setInverted(true);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DefaultDriveCommand());
	}
	//forward auto command with modifier
	public void drive(double leftSpeed, double rightSpeed) {
		leftDriveOne.set(leftSpeed * 0.84);
		leftDriveTwo.set(leftSpeed * 0.84);
		rightDriveOne.set(rightSpeed);
		rightDriveTwo.set(rightSpeed);
	}
	
//	public void backDrive(double leftSpeed, double rightSpeed, double rightModifier) {
//		leftDriveOne.set(leftSpeed);
//		leftDriveTwo.set(leftSpeed);
//		rightDriveOne.set(rightSpeed * rightModifier);
//		rightDriveTwo.set(rightSpeed * rightModifier);
//	}
	
	//base command
	public void backDrive(double leftSpeed, double rightSpeed) {
		leftDriveOne.set(leftSpeed);
		leftDriveTwo.set(leftSpeed);
		rightDriveOne.set(rightSpeed);
		rightDriveTwo.set(rightSpeed);
	}
	
	//drive command
	public void drive(double speed) {
		drive(speed, speed);
	}
	
	public void stop() {
		drive(0);
	}
}
