package org.c02.swe.iot.demo;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.io.IOException;

/**
 * Created by kevin.perko on 03.02.2018.
 */
public class PlayDemoApp {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) throws IOException, ParticleException {

        Button bt = new Button(api);
        bt.playSound();

    }


}
