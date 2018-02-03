package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class ButtonCounterDemo {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) {
        try {
            while(true) {

               Button bt = new Button(api);

               int buttonClickCtnNorth = bt.getButtonClickCounter(IButton.ButtonDirection.North);
               int buttonClickCtnEast = bt.getButtonClickCounter(IButton.ButtonDirection.East);
               int buttonClickCtnSouth = bt.getButtonClickCounter(IButton.ButtonDirection.South);
               int buttonClickCtnWest = bt.getButtonClickCounter(IButton.ButtonDirection.West);

               //print results
               System.out.println("Clicks North: " + buttonClickCtnNorth);
               System.out.println("Clicks East: " + buttonClickCtnEast);
               System.out.println("Clicks South: " + buttonClickCtnSouth);
               System.out.println("Clicks West: " + buttonClickCtnWest);

               int buttonClickTotal = sumButtonClicks(buttonClickCtnNorth, buttonClickCtnEast, buttonClickCtnSouth, buttonClickCtnWest);

               //print total clicks
               System.out.println("Total clicks: " + buttonClickTotal);

               Thread.sleep(5000);

               bt.resetButtonClickCounters();

               System.out.println("ButtonClickCounter resettet");

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int sumButtonClicks(int clicksNorth, int clicksEast, int clicksSouth, int clicksWest) {
        return clicksNorth + clicksEast + clicksSouth + clicksWest;
    }

}
