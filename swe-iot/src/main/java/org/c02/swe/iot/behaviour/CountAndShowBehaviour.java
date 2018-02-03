package org.c02.swe.iot.behaviour;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.ParticleException;

public class CountAndShowBehaviour extends AbstractBehaviour {

	public CountAndShowBehaviour(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		try {
			int position = button.getButtonClickCounter(ButtonDirection.North);
			button.setLed(position, Color.WHITE);
		} catch (IOException | ParticleException e) {
			System.out.println(e.toString());
		}
		
	}

}
