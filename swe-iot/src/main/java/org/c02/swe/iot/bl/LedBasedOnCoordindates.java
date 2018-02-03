package org.c02.swe.iot.bl;

import java.awt.*;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class LedBasedOnCoordindates {

    public LedBasedOnCoordindates() {
    }

    public Color getColorBasedOnXValue(double xValue) {

        int xPosValue = (int)Math.abs(xValue)%255;

        System.out.println("xPosValue: " + xPosValue);

        return new Color(xPosValue, xPosValue, xPosValue);
    }

    public Color getColorBasedOnCoordindates(double xValue, double yValue, double zValue) {

        int xPosValue = (xValue <0)?0:(int)xValue%255;
        int yPosValue = (yValue <0)?0:(int)yValue%255;
        int zPosValue = (zValue <0)?0:(int)zValue%255;

        System.out.println("xPosValue: " + xPosValue);
        System.out.println("yPosValue: " + yPosValue);
        System.out.println("zPosValue: " + zPosValue);

        return new Color(xPosValue, yPosValue, zPosValue);
    }
}
