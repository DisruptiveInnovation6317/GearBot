package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.commands.DefaultLiftCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
	//speed controllers for lift and pivot motor
	public SpeedController liftMotor = new Victor(RobotMap.Motors.LIFT_MOTOR);
	public SpeedController pivotArm = new Victor(RobotMap.Motors.PIVOT_ARM_MOTOR);
	{
		//inverts lift motor
		liftMotor.setInverted(true);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DefaultLiftCommand());
	}
	
	//sets speed dependent on the throttle
	public void setLift(double speed) {
		liftMotor.set(speed);
	}
	
	//same
	public void setPivot(double speed) {
		pivotArm.set(speed);
	}
}
