package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InternetButtonTest {

	private InternetButtonApi internetButtonApi;

	@Mock
	private ParticleApiWrapper particleWrapperApi;

	@Before
	public void setup() {
		internetButtonApi = new InternetButtonImpl(particleWrapperApi);
	}

	@Test
	public void testPlaySound() throws ParticleException {
		internetButtonApi.playSound();
		Mockito.verify(particleWrapperApi).callMethod("play", null);
	}

	@Test
	public void testSetLedIntface() throws ParticleException {
		ParticleApiWrapper mocApi = new ParticleApiWrapper() {

			@Override
			public int readVariable(String variable) throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int callMethod(String method, String parameter) throws ParticleException {

				Assert.assertEquals("led", method);
				Assert.assertEquals("10255255255", parameter);

				return 0;
			}
		};

		internetButtonApi = new InternetButtonImpl(mocApi);
		internetButtonApi.setLed(10, Color.WHITE);

	}

	@Test
	public void testSetLedRedIntface() throws ParticleException {
//setup
		ParticleApiWrapper mocApi = new ParticleApiWrapper() {
			@Override
			public int readVariable(String variable) throws IOException {
				return 0;
			}

			@Override
			public int callMethod(String method, String parameter) throws ParticleException {
//verify
				Assert.assertEquals("led", method);
				Assert.assertEquals("11255000000", parameter);

				return 0;
			}
		};

		internetButtonApi = new InternetButtonImpl(mocApi);
		//execute
		internetButtonApi.setLed(11, Color.RED);

	}
	
	@Test 
 	public void testButtonCoutner() throws ParticleException { 
		
		//setup
		ParticleApiWrapper wrapperInstance= new ParticleApiWrapper() {
			
			@Override
			public int readVariable(String variable) throws IOException {
				//verify
				Assert.assertEquals("countButton3", variable);
				return 0;
			}
			
			@Override
			public int callMethod(String method, String parameter) throws ParticleException {
			
				return 0;
			}
		};
		
		InternetButtonApi api = new InternetButtonImpl(wrapperInstance);
		
		//execute
		api.getButtonCounter(ButtonDirection.East);
		
 	}

}
