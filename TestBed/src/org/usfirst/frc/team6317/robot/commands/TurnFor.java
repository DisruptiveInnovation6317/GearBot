package org.usfirst.frc.team6317.robot.commands;

import java.util.Objects;
import java.util.function.Supplier;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnFor extends Command {
	private Direction direction;
	private int inches;
	private Supplier<Direction> directionSupplier;

	public TurnFor(char closestData) {
		this.direction = Direction.fromChar(closestData);
		Objects.requireNonNull(this.direction);
		this.inches = 24;
		if (closestData == 'L') {
			SmartDashboard.putString("Game Data is", "L");
		} else if (closestData == 'R') {
			SmartDashboard.putString("Game Data is", "R");
		}
	}
	
//	public TurnFor(char closestData, int inches) {
//		this.direction = "R";
//		this.inches = 0;
//		if (closestData == 'L') {
//			this.direction = "R";
//			this.inches = 24;
//		} else if (closestData == 'R') {
//			this.direction = "L";
//			this.inches = 24;
//		} 
//	}
	
	public TurnFor(Direction turnDirection , int turning) {
		this.direction = turnDirection;
		this.inches = turning;
	}
	
	public TurnFor(Supplier<Direction> turnDirection , int turning) {
		this.directionSupplier = turnDirection;
		this.inches = turning;
	}
		
	@Override
	protected void initialize() {
		if (this.directionSupplier != null)
			this.direction = this.directionSupplier.get();
		Robot.SensorSubsystem.resetEncoders();
		if (!this.isFinished()) {
			if (this.direction == Direction.RIGHT) {
				Robot.DriveSubsystem.drive(0, 0.4);
			} else if (this.direction == Direction.LEFT) {
				Robot.DriveSubsystem.drive(0.4, 0);
			}
		}
	}
	
	@Override
	protected boolean isFinished() {
		Encoder leftEnc = Robot.SensorSubsystem.leftEncoder;
		Encoder rightEnc = Robot.SensorSubsystem.rightEncoder;
		if (this.direction == Direction.LEFT) {
			return Robot.SensorSubsystem.encoderDistanceDone(leftEnc, this.inches);
		} else if (this.direction == Direction.RIGHT) {
			return Robot.SensorSubsystem.encoderDistanceDone(rightEnc, this.inches);
		} else {
			return false;
		}
	}

	@Override
	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}