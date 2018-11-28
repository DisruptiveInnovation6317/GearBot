package org.usfirst.frc.team6317.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem {
	//solenoid for clamp
	DoubleSolenoid arm = new DoubleSolenoid(0,1);
	//solenpid for piston
	DoubleSolenoid piston = new DoubleSolenoid(3,4);
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//nothing
	}
	
	//opens front clamp
	public void openArm(){ //Shifts forward
		arm.set(DoubleSolenoid.Value.kForward);
	}
	
	//closes front clamp
	public void closeArm(){//Shifts reverse
		arm.set(DoubleSolenoid.Value.kReverse);
	}
	
	//pops piston
	public void firePiston() {
		piston.set(DoubleSolenoid.Value.kForward);
	}
	
	//lowers piston
	public void lowerPiston() {
		piston.set(DoubleSolenoid.Value.kReverse);
	}
}
