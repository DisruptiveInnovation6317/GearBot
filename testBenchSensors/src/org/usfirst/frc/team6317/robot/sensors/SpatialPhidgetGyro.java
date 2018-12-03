package org.usfirst.frc.team6317.robot.sensors;

import com.phidgets.PhidgetException;
import com.phidgets.SpatialEventData;
import com.phidgets.SpatialPhidget;
import com.phidgets.event.SpatialDataEvent;
import com.phidgets.event.SpatialDataListener;

public class SpatialPhidgetGyro implements SpatialDataListener {
	private final SpatialPhidget phidget;
	private int gyroAxisCount;
	private double[] integratedAxes;
	private double lastTime;
	
	public SpatialPhidgetGyro(SpatialPhidget phidget) throws PhidgetException {
		this.phidget = phidget;
		if (this.phidget.isAttached())
			this.init();
		this.phidget.addAttachListener(e -> {
			try {
				this.init();
			} catch (PhidgetException e1) {
				throw new RuntimeException(e1);
			}
		});
		this.phidget.addSpatialDataListener(this);
	}
	
	public double getIntegratedAxis(int axis) {
		return this.integratedAxes[axis];
	}
	
	public double getIntegratedXAxis() {
		return this.getIntegratedAxis(0);
	}
	
	public double getIntegratedYAxis() {
		return this.getIntegratedAxis(1);
	}
	
	public double getIntegratedZAxis() {
		return this.getIntegratedAxis(2);
	}
	
	public double getHeading(int axis) {
		double heading = this.integratedAxes[axis] % 360;
		if (heading < 0) heading += 360;
		return heading;
	}
	
	public double getXHeading() {
		return this.getHeading(0);
	}
	
	public double getYHeading() {
		return this.getHeading(1);
	}
	
	public double getZHeading() {
		return this.getHeading(2);
	}

	@Override
	public void data(SpatialDataEvent event) {
		SpatialEventData[] eventData = event.getData();
		//System.out.println("Event data: "  + eventData.length);
		for (SpatialEventData data : eventData) {
			double time = data.getTime();
			if (lastTime == 0) {
				lastTime = time;
				continue;
			}
			double deltaTime = time - lastTime;
			assert deltaTime > 0;
			for (int i = 0; i < gyroAxisCount; ++i)
				integratedAxes[i] += data.getAngularRate()[i] * deltaTime;
			lastTime = time;
		}
	}

	private void init() throws PhidgetException {
		gyroAxisCount = phidget.getGyroAxisCount();
		integratedAxes = new double[gyroAxisCount];
		lastTime = 0;
	}
}
