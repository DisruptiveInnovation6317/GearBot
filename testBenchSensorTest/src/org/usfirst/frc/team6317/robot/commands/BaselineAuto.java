package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BaselineAuto extends CommandGroup {

    public BaselineAuto() {
    	this.requires(Robot.DriveTrain);
    	
    	addSequential(new DriftCompensatingDriveCommand(3.0, 0.24));
    	//addSequential(new DriveForwardEncoderCommand(195));
    	addSequential(new DriveCommand("stop", 0));
    }
}
