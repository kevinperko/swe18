package org.c02.swe.iot;

import java.awt.Color;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

	IParticleApi wrapper;

	public Button(IParticleApi wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonClickCounter(ButtonDirection button) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLed(int postition, Color color) throws ParticleException {
		// nn = Position 01-12
		// rrr = rot
		// ggg = grün
		// bbb = blau
				// nnrrrgggbbb
		String tmpPosition;
		if(postition<10)
		{
			tmpPosition = "0"+postition;
		}
		else
		{
			tmpPosition = postition+"";
		}
		wrapper.callMethod("led", tmpPosition+color.getRGB()); 
	}

	public void allLedsOff() throws ParticleException {
		wrapper.callMethod("ledsOff", null);
	}

	public void playSound() throws ParticleException {
		wrapper.callMethod("play", null);
	}

	public void resetButtonClickCounters() {
		// TODO Auto-generated method stub
		
	}

}
