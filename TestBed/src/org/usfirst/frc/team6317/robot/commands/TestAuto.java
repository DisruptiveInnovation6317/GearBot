package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuto extends CommandGroup{
	
	public TestAuto(){
		// Initializes all the required subsystems
		this.requires(Robot.DriveSubsystem);
		this.requires(Robot.Shifter);
		this.requires(Robot.SensorSubsystem);
		
		// Sets the piston to the down position
		addSequential(new SolenoidShift(4));
		// Drives the robot close enough to get within proximity of the zone
		addSequential(new DriveUntil(30, 0.6));
		// Fires the piston to launch the cubes into the zone
		addSequential(new SolenoidShift(5));
	}
}
