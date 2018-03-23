package org.usfirst.frc.team6317.robot.pid;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDMultiOutput implements PIDOutput {
	private final PIDOutput[] outputs;
	
	public PIDMultiOutput(PIDOutput... outputs) {
		this.outputs = outputs;
	}
	
	@Override
	public void pidWrite(double output) {
		for (PIDOutput o : this.outputs)
			o.pidWrite(output);
	}
}
