package org.c02.iot.behaviour.test;

import org.c02.swe.iot.bl.LedBasedOnCoordindates;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.mockito.Mockito.verify;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class LedBasedOnCoordindatesTest {

    LedBasedOnCoordindates bl = new LedBasedOnCoordindates();

    @Test
    public void changeColorIntensityBasedOnXCoordindateTest() {
       //Setup
        double xCor = 0;
        Color aprColor = new Color((int)Math.abs(xCor)%255);

        //Execute
        Color vfyColor = bl.getColorBasedOnXValue(xCor);

        //Verify

        Assert.assertEquals(aprColor, vfyColor);
    }

    @Test
    public void changeColorBasedOnCoordindatesTest() {
        //Setup
        double xCor = 1;
        double yCor = -20;
        double zCor = 255;

        int xPosValue = (xCor <0)?0:(int)xCor%255;
        int yPosValue = (yCor <0)?0:(int)yCor%255;
        int zPosValue = (zCor <0)?0:(int)zCor%255;
        Color aprColor = new Color(xPosValue, yPosValue, zPosValue);

        //Execute
        Color vfyColor = bl.getColorBasedOnCoordindates(xCor, yCor, zCor);

        //Verify

        Assert.assertEquals(aprColor, vfyColor);
    }
}
