package org.usfirst.frc.team6317.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidShift extends Command {

	public int state;
	public Supplier<Direction> directionSupplier;
	public Direction direction;
	
	/**
	 * Initializes the command for pneumatic movement
	 * @param stateIn Holds data for what pneumatic movement we want
	 */
	public SolenoidShift(int stateIn) {
		this.requires(Robot.Shifter);
		state = stateIn;
	}
	
	/**
	 * Initializes program to be able to decide whether to throw the cube or not
	 * @param direction The game data value of which side our switch is on
	 * @param stateIn Holds data for what pneumatic movement we want
	 */
	public SolenoidShift(Supplier<Direction> direction , int stateIn) {
		this.requires(Robot.Shifter);
		this.directionSupplier = direction;
		this.state = stateIn;
	}

	@Override
	protected void initialize() {
		if (this.directionSupplier != null)
			this.direction = this.directionSupplier.get();
		
		if(state == 0)
			Robot.Shifter.closeArm();		
		if(state == 1)
			Robot.Shifter.openArm();
		if (state == 3)
			Robot.Shifter.firePiston();
		if (state == 4)
			Robot.Shifter.lowerPiston();
		if (state == 5 && this.direction == Direction.LEFT)
			Robot.Shifter.firePiston();
		if (state == 6 && this.direction == Direction.RIGHT)
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
