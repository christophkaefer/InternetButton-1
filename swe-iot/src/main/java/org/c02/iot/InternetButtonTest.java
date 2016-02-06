package org.c02.iot; 
 
 
import org.c02.iot.cloud.api.ParticleApiWrapper; 
import org.c02.iot.cloud.api.ParticleException; 
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
 	public void testSetLed() throws ParticleException { 
		internetButtonApi.setLed(0, null); 
		Mockito.verify(particleWrapperApi).callMethod("led", "03255255000"); 
 	} 
 } 
