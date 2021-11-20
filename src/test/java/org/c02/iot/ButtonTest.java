package org.c02.iot;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.*;

public class ButtonTest {


    @Test
    public void testWrapper() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.allLedsOff();

        verify(api).callMethod("ledsOff", null);

    }

    @Test
    public void testWrapperLed() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(1, Color.white);

        verify(api).callMethod("led", "01255255255");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrapperLedInvalid() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(-1, Color.white);

        // With wrong parameters the method must throw an IllegalArgumentException
        verify(api, never()).callMethod(anyString(), anyString());
    }

}
