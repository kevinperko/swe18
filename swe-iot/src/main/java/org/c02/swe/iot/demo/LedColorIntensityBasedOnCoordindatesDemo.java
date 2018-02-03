package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

import java.awt.*;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class LedColorIntensityBasedOnCoordindatesDemo {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) {
        try {

            Button bt = new Button(api);

            System.out.println("Appplication started...");

            while(true) {

                bt.allLedsOff();

               System.out.println("================= START ====================");

                for (int i = 0; i <= 12; i++) {
                    double xValue = bt.getXValue();
                    bt.setLed(i, getColorBasedOnXValue(xValue));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Color getColorBasedOnXValue(double xValue) {

        int xPosValue = (int)Math.abs(xValue)%255;

        System.out.println("xPosValue: " + xPosValue);

        return new Color(xPosValue, xPosValue, xPosValue);
    }
}
