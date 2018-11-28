package org.usfirst.frc.team6317.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team6317.robot.commands.*;


public class OI {
	// toggle intake
	// winch drive
	
	public static Joystick leftStick = new Joystick(0);
	public static Joystick rightStick = new Joystick(1);
	public static Joystick controlStick = new Joystick(2);
	Button controlTrigger = new JoystickButton(controlStick, 1);
	Button botRight = new JoystickButton(controlStick, 4);
	Button botLeft = new JoystickButton(controlStick, 3);
	Button topLeft = new JoystickButton(controlStick, 5);
	Button topRight = new JoystickButton(controlStick, 6);
	
	public OI() {
		topRight.whenPressed(new SolenoidShift(0));
		botRight.whenPressed(new SolenoidShift(1));
		topLeft.whenPressed(new SolenoidShift(3));
		botLeft.whenPressed(new SolenoidShift(4));
		controlTrigger.whenPressed(new Grabber());
	}
}