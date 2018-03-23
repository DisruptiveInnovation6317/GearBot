package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.sensors.SpatialPhidgetGyro;

import com.phidgets.PhidgetException;
import com.phidgets.SpatialPhidget;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SensorsSubsystem extends Subsystem {
	// Distance Sensors
	public AnalogInput frontDistanceSensor = new AnalogInput(RobotMap.AnalogInputs.FRONT_DISTANCE_SENSOR);
	public AnalogInput rightDistanceSensor = new AnalogInput(RobotMap.AnalogInputs.RIGHT_DISTANCE_SENSOR);
	public AnalogInput leftDistanceSensor = new AnalogInput(RobotMap.AnalogInputs.LEFT_DISTANCE_SENSOR);
	
	// Encoders
	public Encoder leftEncoder = new Encoder(3, 4, false, EncodingType.k4X);
	public Encoder rightEncoder = new Encoder(0, 1, true, EncodingType.k4X);
	
	public SpatialPhidget phidget;
	public SpatialPhidgetGyro gyro;
	
	// Encoder Values
	private static final int WHEEL_DIAMETER = 6;
	private static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
	private static final double DISTANCE_PER_REVOLUTION = WHEEL_CIRCUMFERENCE;
	private static final double PULSES_PER_REVOLUTION = 360;
	private static final double DISTANCE_PER_PULSE = DISTANCE_PER_REVOLUTION / PULSES_PER_REVOLUTION;
	
	{
		try {
			phidget = new SpatialPhidget();
			phidget.addAttachListener((e) -> gyro.zero()); 
			gyro = new SpatialPhidgetGyro(phidget);
			phidget.openAny();
		} catch (PhidgetException e) {
			throw new RuntimeException(e);
		}
		leftEncoder.setPIDSourceType(PIDSourceType.kRate);
		rightEncoder.setPIDSourceType(PIDSourceType.kRate);
	}
	
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
				SmartDashboard.putNumber("Gyro Heading", getHeading());
			}

			@Override
			protected boolean isFinished() {
				return false;
			}
		});
	}
	
	/**
	 * Grabs the value in centimeters for the front distance sensor
	 * @return The centimeter value of the front distance sensor
	 */
	public double getDistanceCenti() {
		double volts = frontDistanceSensor.getVoltage();
		double millivolts = volts * 1000;
		double centimeters = millivolts / 4.9;
		SmartDashboard.putNumber("Distance", centimeters);
		return centimeters;
	}
	
	/**
	 * Grabs the value in millimeters for the left distance sensor
	 * @return The millimeter value of the left distance sensor
	 */
	public double getLeftDistanceMilli() {
		double volts = leftDistanceSensor.getVoltage();
		double millivolts = volts * 1000;
		double millimeters = millivolts / .997;
		SmartDashboard.putNumber("Left MilliMeters", millimeters);
		return millimeters;
	}
	
	/**
	 * Grabs the value in millimeters for the right distance sensor
	 * @return The millimeter value of the right distance sensor
	 */
	public double getRightDistanceMilli() {
		double volts = rightDistanceSensor.getVoltage();
		double millivolts = volts * 1000;
		double millimeters = millivolts / .997;
		SmartDashboard.putNumber("Right MilliMeters", millimeters);
		return millimeters;
	}

	/**
	 * Initializes the left and right encoders
	 */
	public void initEncoders() {
		leftEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	}
	
	/**
	 * Checks the encoder distance traveled
	 * @param encoderToCheck Which encoder we are monitoring
	 * @param inches The distance needing to travel
	 * @return The value of whether the distance has been traveled or not
	 */
	public boolean encoderDistanceDone(Encoder encoderToCheck, double inches) {
		if (inches < 0) {
			return encoderToCheck.getDistance() < inches;
		} else {
			return encoderToCheck.getDistance() > inches;
		}
	}
	
	/**
	 * Resets both encoder values to zero
	 */
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public double getHeading() {
		return this.gyro.getYHeading();
	}
}
