package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

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
	
	public String pos ;
	String led;
	String ledres;
	public void setLed2(int postition, Color color) 
	{	
		
	  //  posi.tostring( pos ); 
		
		if(postition < 10 )
		{
			pos = "0" + postition;
		}
		else
		{
			pos = "" + postition;
		}
		
		led = pos + "000255000";
		ledres = pos + "000000000";
		try
		{
			wrapper.callMethod("led",led);
			wrapper.callMethod("led",ledres);
		}
		catch(ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setLed(int postition, Color color) 
	{	
		

		try
		{
			wrapper.callMethod("led","03255000255");
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
		try {
			wrapper.callMethod("ledsOff",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

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
		try {
			wrapper.callMethod("reset",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
