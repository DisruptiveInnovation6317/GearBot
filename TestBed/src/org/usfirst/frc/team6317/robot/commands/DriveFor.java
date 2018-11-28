package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveFor extends Command{
	
	private final double speed, inches, rightModifier, leftModifier;
	
	//stand drive command without speed modifiers
	public DriveFor(double inches) {
		this(inches, 0.5, 1, 1);
	}
	
	//changeable speed command
	public DriveFor(double inches, double speed) {
		this(inches, speed, 1, 1);
	}
	
	//command with right motor speed modifier
	public DriveFor(double inches, double speed, double rightModifier) {
		this(inches, speed, 1, rightModifier);
	}
	
	//command with left motor speed modifier
	public DriveFor(double inches, double speed, double leftModifier, double rightModifier) {
		//0.87 modifier is almsot straight
		this.requires(Robot.DriveSubsystem);
		this.requires(Robot.SensorSubsystem);
		this.speed = speed;
		this.inches = inches;
		this.rightModifier = rightModifier;
		this.leftModifier = leftModifier;
	}
	
	@Override
	protected void execute() {
		SmartDashboard.putNumber("Left Encoder", Robot.SensorSubsystem.leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Encoder", Robot.SensorSubsystem.rightEncoder.getDistance());
	}
	
	@Override
	protected void initialize() {
		//sets encoders to 0 when starts
		Robot.SensorSubsystem.resetEncoders();
		if (!isFinished()) //runs until its finished
			Robot.DriveSubsystem.backDrive(this.speed * this.leftModifier, this.speed * this.rightModifier);
	}
	

	@Override
	protected boolean isFinished() {
		Encoder leftEnc = Robot.SensorSubsystem.leftEncoder;
		Encoder rightEnc = Robot.SensorSubsystem.rightEncoder;
		//returns whether the encoders are above the inches specified
		return Robot.SensorSubsystem.encoderDistanceDone(leftEnc, this.inches) ||
				Robot.SensorSubsystem.encoderDistanceDone(rightEnc, this.inches);
	}
	
	@Override
	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}
