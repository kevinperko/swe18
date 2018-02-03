package org.c02.swe.iot.behaviour;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.ParticleException;

public class CountAndShowLed extends AbstractBehaviour {

	public CountAndShowLed(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		int buttonCounter;
		try {
			buttonCounter = button.getButtonClickCounter(ButtonDirection.North);
			button.setLed(buttonCounter, Color.GREEN);
		} catch (IOException | ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
