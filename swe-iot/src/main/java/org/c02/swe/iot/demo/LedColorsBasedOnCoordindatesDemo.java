package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.bl.LedBasedOnCoordindates;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

import javax.swing.text.StyledEditorKit;
import java.awt.*;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class LedColorsBasedOnCoordindatesDemo {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    static LedBasedOnCoordindates bl = new LedBasedOnCoordindates();

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
                    bt.setLed(i, bl.getColorBasedOnCoordindates(xValue, yValue, zValue));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
