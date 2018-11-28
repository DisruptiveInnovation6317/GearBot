package org.usfirst.frc.team6317.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem {
	DoubleSolenoid arm = new DoubleSolenoid(1,2);
	DoubleSolenoid piston = new DoubleSolenoid(3,4);
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//nothing
	}
	
	public void openArm(){ //Shifts forward
		arm.set(DoubleSolenoid.Value.kForward);
	}
	
	public void closeArm(){//Shifts reverse
		arm.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void firePiston() {
		piston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void lowerPiston() {
		piston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopShift(){ //Turns off airflow
		arm.set(DoubleSolenoid.Value.kOff);
		piston.set(DoubleSolenoid.Value.kOff);
	}
}
