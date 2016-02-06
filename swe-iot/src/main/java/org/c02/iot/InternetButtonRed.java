package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonRed implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonRed(ParticleApiWrapper wrapperInstance) {
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
	
	public String pos ;
	STRING color;
	int count;
	String led;
	String ledres;
	public void ledRed(int postition) 
	{	
		
		count = (postition * 10) + 5;
		pos = "12" + postition + "000000";
		ledres = "12000000000";

		try
		{		
			wrapper.callMethod("led",pos);
			wrapper.callMethod("led",ledres);
		}
		catch(ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void resetButtonCounters() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLed(int postition, Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void allLedsOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound() {
		// TODO Auto-generated method stub
		
	}



}
