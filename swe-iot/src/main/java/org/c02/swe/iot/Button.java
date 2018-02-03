package org.c02.swe.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

	IParticleApi wrapper;

	public Button(IParticleApi wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonClickCounter(ButtonDirection button) throws IOException {
		String curButton = "";
		switch(button)
		{
			case North: curButton = "countButton1";break;
			case South: curButton = "countButton2";break;
			case East: curButton = "countButton3";break;
			case West: curButton = "countButton4";break;
		}
		return wrapper.readVariable(curButton);
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
		wrapper.callMethod("led", tmpPosition+String.format("%03d", color.getRed())+String.format("%03d", color.getGreen())+String.format("%03d", color.getBlue()));
	}

	public void allLedsOff() throws ParticleException {
		wrapper.callMethod("ledsOff", null);
	}

	public void playSound() throws ParticleException {
		wrapper.callMethod("play", null);
	}

	public void resetButtonClickCounters() throws ParticleException {
		wrapper.callMethod("reset",null);
	}
}
