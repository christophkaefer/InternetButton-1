package org.c02.iot;

import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;
import org.c02.iot.cloud.examples.DemoConstants;

public class Demo4 {
	
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	InternetButtonImpl button=new InternetButtonImpl(api);

	int count=0;
	
	int x = 0 +button.getButtonCounter(ButtonDirection.North) +button.getButtonCounter(ButtonDirection.South)+button.getButtonCounter(ButtonDirection.East)+button.getButtonCounter(ButtonDirection.West);
	if(x >= 1 )
	{
		try {
			api.callMethod("reset",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	x=x-x;
	
	while(x<10)
	{
		x = 0 +button.getButtonCounter(ButtonDirection.North) +button.getButtonCounter(ButtonDirection.South)+button.getButtonCounter(ButtonDirection.East)+button.getButtonCounter(ButtonDirection.West);
		if(x>=10)
		{
			button.playSound();
			x=0;
		}
		
	}
	

	
	}

}
