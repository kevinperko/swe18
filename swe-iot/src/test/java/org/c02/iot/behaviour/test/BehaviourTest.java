package org.c02.iot.behaviour.test;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Assert;
import org.junit.Test;

public class BehaviourTest {

	@Test
	public void testBehaviour() {

		IButton buttonInstance = new IButton() {

			@Override
			public int getButtonClickCounter(ButtonDirection button) {
				if (button == ButtonDirection.North)
					return 5;
				return 0;
			}

			@Override
			public void resetButtonClickCounters() {
				Assert.fail();
			}

			@Override
			public void setLed(int postition, Color color) {
				Assert.assertEquals(5, postition);
				Assert.assertEquals(Color.GREEN, color);
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

		CountAndShowLed beh = new CountAndShowLed(buttonInstance);

		beh.run();
	}
}
