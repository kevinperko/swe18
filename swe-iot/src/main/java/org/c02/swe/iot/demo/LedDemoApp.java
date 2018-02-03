package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class LedDemoApp {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) {
        try {
            Button bt = new Button(api);

            //first, turn all LEDs off
            bt.allLedsOff();

            bt.setLed(1, Color.red);
            bt.setLed(2, Color.black);
            bt.setLed(3, Color.red);
            bt.setLed(4, Color.black);
            bt.setLed(5, Color.red);
            bt.setLed(6, Color.black);
            bt.setLed(7, Color.red);
            bt.setLed(8, Color.black);
            bt.setLed(9, Color.red);
            bt.setLed(10, Color.black);
            bt.setLed(11, Color.red);
            bt.setLed(12, Color.black);

            //turn LEDs off
            bt.allLedsOff();
        }
        catch (ParticleException pex) {
            pex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
