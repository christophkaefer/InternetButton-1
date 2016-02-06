package org.c02.iot;

import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;
import org.c02.iot.cloud.examples.DemoConstants;

public class Demo3 {
	
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	InternetButtonRed button=new InternetButtonRed(api);
//	button.playSound();	
//	button.setLed(0, null);	
//	System.out.println("Button North:" +button.getButtonCounter(ButtonDirection.North));
//	System.out.println("Button South:" +button.getButtonCounter(ButtonDirection.South));
//	System.out.println("Button East:" +button.getButtonCounter(ButtonDirection.East));
//	System.out.println("Button West:" +button.getButtonCounter(ButtonDirection.West));
//	
	int x = 0 +button.getButtonCounter(ButtonDirection.North) +button.getButtonCounter(ButtonDirection.South)+button.getButtonCounter(ButtonDirection.East)+button.getButtonCounter(ButtonDirection.West);
	if(x > 25 )
	{
		x=0;
		try {
			api.callMethod("reset",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	button.ledRed(x);
	
	
	}

}
