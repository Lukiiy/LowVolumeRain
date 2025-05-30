package me.lukiiy.lowrain;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowVolumeRain implements ClientModInitializer {
    public static final String ID = "lowrain";
    public static final Logger LOGGER = LoggerFactory.getLogger(ID);

    public static float volume;

    @Override
    public void onInitializeClient() {
        Config config = new Config(ID + ".properties", "LowVolumeRain");

        config.setIfAbsent("volume", "0.025");

        volume = getFloat(config.get("volume"));
        LOGGER.info("The volume has been set to {}!", volume);
    }

    private float getFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException ignored) {
            return 0.025f;
        }
    }

}
