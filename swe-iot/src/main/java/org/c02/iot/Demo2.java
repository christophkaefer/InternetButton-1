package org.c02.iot;

import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

public class Demo2 {
	
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	InternetButtonImpl button=new InternetButtonImpl(api);
//	button.playSound();	
//	button.setLed(0, null);	
//	System.out.println("Button North:" +button.getButtonCounter(ButtonDirection.North));
//	System.out.println("Button South:" +button.getButtonCounter(ButtonDirection.South));
//	System.out.println("Button East:" +button.getButtonCounter(ButtonDirection.East));
//	System.out.println("Button West:" +button.getButtonCounter(ButtonDirection.West));
//	
	int x = +button.getButtonCounter(ButtonDirection.North);
	while(x > 12 )
	{
		x=x-12;		
	}
	if(x == 0)
	{
		x=1;
	}
	
	button.setLed2(x, null);
	
	
	}

}
