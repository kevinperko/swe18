package org.c02.iot.behaviour.test;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by kevin.perko on 03.02.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class LedAPITest {

    @Mock
    private IParticleApi api;

    @Test
    public void shouldTurnOffAllLeds() throws Exception {
        Button button = new Button(api);
        button.allLedsOff();
        verify(api).callMethod("ledsOff", null);
        verifyNoMoreInteractions(api);
    }

    @Test
    public void shouldTurnOnRedLed() throws Exception {
        Button button = new Button(api);
        button.setLed(01, Color.red);
        verify(api).callMethod("led", "01255000000");
        verifyNoMoreInteractions(api);
    }

    @Test
    public void shouldPlaySound() throws Exception {
        Button button = new Button(api);
        button.playSound();
        verify(api).callMethod("play", null);
        verifyNoMoreInteractions(api);
    }

    @Test
    public void shouldResetButtonClickCounters() throws Exception {
        Button button = new Button(api);
        button.resetButtonClickCounters();
        verify(api).callMethod("reset", null);
        verifyNoMoreInteractions(api);
    }

    @Test
    public void shouldGetButtonClickCounterForDirectionNorth() throws Exception {
        //Setup
        Button button = new Button(api);
        String button1String = "countButton1";

        //Execute
        button.getButtonClickCounter(IButton.ButtonDirection.North);

        //Verify
        verify(api).readVariable(button1String);
        verifyNoMoreInteractions(api);
    }
    
    @Test
    public void shouldPlaySoundOn10Clicks() throws Exception {
        //Setup
        Button button = new Button(api);
        int buttonClicks = 10;
        //Execute
        button.playSound();
        //Verify
        if(buttonClicks == 10) {
            verify(api).callMethod("play", null);
            verifyNoMoreInteractions(api);
        }
    }
}
