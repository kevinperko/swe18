package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

import javax.swing.text.StyledEditorKit;
import java.awt.*;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class LedColorsBasedOnCoordindatesDemo {

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
                    double yValue = bt.getYValue();
                    double zValue = bt.getZValue();
                    bt.setLed(i, getColorBasedOnCoordindates(xValue, yValue, zValue));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Color getColorBasedOnCoordindates(double xValue, double yValue, double zValue) {

        int xPosValue = (int)Math.abs(xValue)%255;
        int yPosValue = (int)Math.abs(yValue)%255;
        int zPosValue = (int)Math.abs(zValue)%255;

        System.out.println("xPosValue: " + xPosValue);
        System.out.println("yPosValue: " + yPosValue);
        System.out.println("zPosValue: " + zPosValue);

        return new Color(xPosValue, yPosValue, zPosValue);
    }
}
