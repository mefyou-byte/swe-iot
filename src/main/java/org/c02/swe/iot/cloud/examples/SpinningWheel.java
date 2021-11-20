package org.c02.swe.iot.cloud.examples;

import java.awt.*;
import java.io.IOException;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class SpinningWheel {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) throws IOException, ParticleException {

        IButton button = new Button(api);

        int pos = 1;

        api.callMethod("ledsOff", null); // Schaltet die LEDs aus
        while(pos <= 12) {
            button.setLed(pos, Color.red);
            pos++;
            button.setLed(pos, Color.blue);
            pos++;
        }


    }

}
