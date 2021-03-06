package org.c02.swe.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.cloud.api.ParticleException;

public interface IButton {

	public enum ButtonDirection {
		// Button:
		//1     2      3     4
		North, South, East, West
	}

	int getButtonClickCounter(ButtonDirection button) throws IOException;
	
	void resetButtonClickCounters() throws ParticleException;
	
	void setLed(int postition, Color color) throws ParticleException;
	
	void allLedsOff() throws ParticleException;
	
	void playSound() throws ParticleException;

	double getXValue() throws IOException;

	double getYValue() throws IOException;

	double getZValue() throws IOException;
}
