package org.c02.swe.iot.demo;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class CountAndShowLed {
	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) {
		Button bttn = new Button(api);

		Thread mythread = new Thread(new CountAndShowImplemenation(bttn));
		mythread.start();

	}

}

class CountAndShowImplemenation implements Runnable {
	private Button button;
	private int curCount = 0;

	public CountAndShowImplemenation(Button button) {
		this.button = button;
		try {
			button.allLedsOff();
			button.resetButtonClickCounters();
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				// button.setLed(7, Color.GREEN);
				int tmpCount = button.getButtonClickCounter(ButtonDirection.North);
				System.out.println("count:" + tmpCount);
				if (tmpCount > curCount) {
					curCount = tmpCount;
					button.allLedsOff();
				}
				button.setLed((tmpCount % 12 == 0) ? 1:tmpCount%12, Color.green);
				//Thread.sleep(200);
			}
		} catch (IOException | ParticleException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}