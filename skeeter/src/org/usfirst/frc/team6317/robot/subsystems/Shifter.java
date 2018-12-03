package org.usfirst.frc.team6317.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem {
	//solenoid for clamp
	DoubleSolenoid rightShifter = new DoubleSolenoid(0,1);
	//solenpid for piston
	DoubleSolenoid leftShifter = new DoubleSolenoid(2,3);
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//nothing
	}
	
	// 0 and 2 are high
	// 1 and 3 are low
	public void shiftHigh() {
		rightShifter.set(DoubleSolenoid.Value.kForward);		
		leftShifter.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shiftLow() {
		rightShifter.set(DoubleSolenoid.Value.kReverse);		
		leftShifter.set(DoubleSolenoid.Value.kReverse);
	}
	
	//opens front clamp
//	public void openArm(){ //Shifts forward
//		arm.set(DoubleSolenoid.Value.kForward);
//	}
//	
//	//closes front clamp
//	public void closeArm(){//Shifts reverse
//		arm.set(DoubleSolenoid.Value.kReverse);
//	}
//	
//	//pops piston
//	public void firePiston() {
//		piston.set(DoubleSolenoid.Value.kForward);
//	}
//	
//	//lowers piston
//	public void lowerPiston() {
//		piston.set(DoubleSolenoid.Value.kReverse);
//	}
}
