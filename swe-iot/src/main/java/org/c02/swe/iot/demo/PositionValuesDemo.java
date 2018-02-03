package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class PositionValuesDemo {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) {
        try {

            Button bt = new Button(api);

            System.out.println("Appplication started...");

            while(true) {

               System.out.println("================= START ====================");

               double xValue = bt.getXValue();
               double yValue = bt.getYValue();
               double zValue = bt.getZValue();

               //print results
               System.out.println("xValue: " + xValue);
               System.out.println("yValue: " + yValue);
               System.out.println("zValue: " + zValue);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
