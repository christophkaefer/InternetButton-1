package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonCounter(ButtonDirection button) 
	{
		

			if (button==ButtonDirection.North)
				try {
					return wrapper.readVariable("countButton1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (button==ButtonDirection.South)
				try {
					return wrapper.readVariable("countButton2");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (button==ButtonDirection.East)
				try {
					return wrapper.readVariable("countButton3");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			if (button==ButtonDirection.West)
				try {
					return wrapper.readVariable("countButton4");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return 0;
	}

	public void setLed(int postition, Color color) 
	{
		try
		{
			wrapper.callMethod("led","03255255000");
			wrapper.callMethod("led","06255000000");
			wrapper.callMethod("led","09000255000");
			wrapper.callMethod("led","12000000255");
			wrapper.callMethod("led","03000000000");
			wrapper.callMethod("led","06000000000");
			wrapper.callMethod("led","09000000000");
			wrapper.callMethod("led","12000000000");
		}
		catch(ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void allLedsOff() {
		// TODO Auto-generated method stub

	}

	public void playSound() {
	 try {
		wrapper.callMethod("play", null);
	} catch (ParticleException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void resetButtonCounters() {
		// TODO Auto-generated method stub
		
	}

}
