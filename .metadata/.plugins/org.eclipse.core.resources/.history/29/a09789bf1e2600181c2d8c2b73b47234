package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SensorsSubsystem extends Subsystem {
	//initializes everything
	public AnalogInput frontDistanceSensor = new AnalogInput(RobotMap.AnalogInputs.FRONT_DISTANCE_SENSOR);
	public AnalogInput rightDistanceSensor = new AnalogInput(RobotMap.AnalogInputs.RIGHT_DISTANCE_SENSOR);
	public AnalogInput leftDistanceSensor = new AnalogInput(RobotMap.AnalogInputs.LEFT_DISTANCE_SENSOR);
	public Encoder leftEncoder = new Encoder(8, 9, false, EncodingType.k4X);
	public Encoder rightEncoder = new Encoder(0, 1, true, EncodingType.k4X);
	
	// Encoder Values
	private static final int WHEEL_DIAMETER = 6;
	private static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
	private static final double DISTANCE_PER_REVOLUTION = WHEEL_CIRCUMFERENCE;
	private static final double PULSES_PER_REVOLUTION = 360;
	private static final double DISTANCE_PER_PULSE = DISTANCE_PER_REVOLUTION / PULSES_PER_REVOLUTION;
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Command() {
			{
				requires(SensorsSubsystem.this);
			}
			
			@Override
			protected void initialize() {
				initEncoders();
				resetEncoders();
			}

			@Override
			protected void execute() {
				SmartDashboard.putNumber("Left Encoder", leftEncoder.getDistance());
				SmartDashboard.putNumber("Right Encoder", rightEncoder.getDistance());
			}

			@Override
			protected boolean isFinished() {
				return false;
			}
		});
	}
	
	//sensor for the front
	public double getDistanceCenti() {
		double volts = frontDistanceSensor.getVoltage();
		double millivolts = volts * 1000;
		double centimeters = millivolts / 4.9;
		SmartDashboard.putNumber("Distance", centimeters);
		return centimeters;
	}
	
	//left sensor
	public double getLeftDistanceMilli() {
		double volts = leftDistanceSensor.getVoltage();
		double millivolts = volts * 1000;
		double millimeters = millivolts / .997;
		SmartDashboard.putNumber("Left MilliMeters", millimeters);
		return millimeters;
	}
	
	//right happiness
	public double getRightDistanceMilli() {
		double volts = rightDistanceSensor.getVoltage();
		double millivolts = volts * 1000;
		double millimeters = millivolts / .997;
		SmartDashboard.putNumber("Right MilliMeters", millimeters);
		return millimeters;
	}
	
	//initializes encoders
	public void initEncoders() {
		leftEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	}
	
	//checks encoders for distance
	public boolean encoderDistanceDone(Encoder encoderToCheck, double inches) {
		return encoderToCheck.getDistance() > inches;
	}
	
	//resets encoder values to 0
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
}
