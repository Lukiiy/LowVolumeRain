package me.lukiiy.lowrain;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowVolumeRain implements ModInitializer {
    public static final String ID = "lowrain";
    public static final Logger LOGGER = LoggerFactory.getLogger(ID);

    public static float Volume = 0.025f;

    @Override public void onInitialize() {}
}
