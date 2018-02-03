package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class TenClicksMelodyDemo {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) {
        try {

            Button button = new Button(api);

            while (true) {

                button.resetButtonClickCounters();
                int clickcounter = 0;

                System.out.println("Wait 5 seconds for button click...");

                Thread.sleep(5000);

                clickcounter = button.getButtonClickCounter(ButtonDirection.North)
                        + button.getButtonClickCounter(ButtonDirection.East)
                        + button.getButtonClickCounter(ButtonDirection.South)
                        + button.getButtonClickCounter(ButtonDirection.West);
                System.out.println("Clicks: " + clickcounter);

                if (clickcounter == 10) {
                    try {
                        button.playSound();
                        System.out.println("sound played and Clicks:" + clickcounter);
                        button.resetButtonClickCounters();
                    } catch (ParticleException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("Finished... clicks= " + clickcounter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
