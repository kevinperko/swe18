package org.c02.swe.iot.behaviour;

import java.awt.Color;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

public class SetLed extends AbstractBehaviour {

	public SetLed(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		try {
			button.setLed(1, Color.BLACK);
		} catch (ParticleException e) {
			System.out.println(e.toString());
		}
		
	}

}
