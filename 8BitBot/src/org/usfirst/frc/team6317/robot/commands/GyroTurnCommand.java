package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;
import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroTurnCommand extends Command {
	private final double target, threshold;
	private final double speed;
	private boolean done = false;
	private final boolean left, right;
	
	{
		this.requires(Robot.DriveSubsystem);
		this.requires(Robot.SensorSubsystem);
	}
	
	public GyroTurnCommand(double degrees, double threshold, double speed, boolean useLeft, boolean useRight) {
		if (!useLeft && !useRight) throw new IllegalArgumentException("Must use at least one side");
		this.target = Robot.SensorSubsystem.gyro.getIntegratedZAxis() + degrees;
		this.threshold = threshold;
		this.speed = speed;
		this.left = useLeft;
		this.right = useRight;
	}
	
	public GyroTurnCommand(int targetHeading, int threshold, double speed) {
		this(targetHeading, threshold, speed, true, true);
	}

	@Override
	protected void execute() {
		try {
			double off = target - Robot.SensorSubsystem.gyro.getIntegratedZAxis();
			//these 2 lines are applicable when using getHeading() for an absolute turn, rather than relative
//			if (off > 180) off -= 360;       //you should never need to turn more than 180* - e.g. turn 160* ccw, not 200* cw
//			else if (off < -180) off += 360;
			if (Math.abs(off) > threshold) {
				double s = off > 0 ? speed : -speed;
				if (this.left) {
					Robot.DriveSubsystem.leftDriveOne.set(-s);
					Robot.DriveSubsystem.leftDriveTwo.set(-s);
				}
				if (this.right) {
					Robot.DriveSubsystem.rightDriveOne.set(s);
					Robot.DriveSubsystem.rightDriveTwo.set(s);
				}
			} else this.done = true;
			SmartDashboard.putNumber("Gyro Angle", Robot.SensorSubsystem.gyro.getIntegratedZAxis());
		} catch (Exception e) {
			SmartDashboard.putString("Exception", e.toString());
		}
	}
	
	@Override
	protected boolean isFinished() {
		return this.done;
	}

	@Override
	protected void end() {
		Robot.DriveSubsystem.drive(0);
	}

}
