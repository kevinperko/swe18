package org.c02.swe.iot;

import java.awt.Color;

import org.c02.swe.iot.cloud.api.ParticleException;

public interface IButton {

	public enum ButtonDirection {
		// Button:
		//1     2      3     4
		North, South, East, West
	}

	int getButtonClickCounter(ButtonDirection button);
	
	void resetButtonClickCounters();
	
	void setLed(int postition, Color color);
	
	void allLedsOff() throws ParticleException;
	
	void playSound() throws ParticleException;
}
