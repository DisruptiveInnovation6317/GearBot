package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidShift extends Command {

	public int state;
	
	public SolenoidShift(int stateIn) {
		this.requires(Robot.Shifter);
		state = stateIn;
	}
	
	@Override
	protected void initialize() {
		//depending on input, pops or lowers piston and closes / opens clamps
		if(state == 0)
			Robot.Shifter.openArm();		
		if(state == 1)
			Robot.Shifter.closeArm();
		if (state == 3)
			Robot.Shifter.firePiston();
		if (state == 4)
			Robot.Shifter.lowerPiston();
		if (state == 5)
			Robot.Shifter.firePiston();
	}

	@Override
	protected void execute() {
		

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
