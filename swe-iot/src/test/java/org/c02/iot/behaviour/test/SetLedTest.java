package org.c02.iot.behaviour.test;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.c02.swe.iot.behaviour.SetLed;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Assert;
import org.junit.Test;

public class SetLedTest {
	@Test
	public void testSetLedBehaviour() {

		IButton buttonInstance = new IButton() {

			@Override
			public int getButtonClickCounter(ButtonDirection button) {
				return 0;
			}

			@Override
			public void resetButtonClickCounters() {
				Assert.fail();
			}

			@Override
			public void setLed(int postition, Color color) {
				String tmpPosition;
				if(postition<10)
				{
					tmpPosition = "0"+postition;
				}
				else
				{
					tmpPosition = postition+"";
				}
				Assert.assertEquals("01000000000",tmpPosition+String.format("%03d", color.getRed())+String.format("%03d", color.getGreen())+String.format("%03d", color.getBlue()));
			}

			@Override
			public void allLedsOff() {
				Assert.fail();
			}

			@Override
			public void playSound() {
				Assert.fail();
			}

			@Override
			public double getXValue() throws IOException {
				return 0;
			}

			@Override
			public double getYValue() throws IOException {
				return 0;
			}

			@Override
			public double getZValue() throws IOException {
				return 0;
			}
		};

		SetLed sLed = new SetLed(buttonInstance);
		sLed.run();
	}
}
