package me.lukiiy.lowrain;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowVolumeRain implements ClientModInitializer {
    public static final String ID = "lowrain";

    public static final Logger LOGGER = LoggerFactory.getLogger(ID);
    public static final Config config = new Config(ID + ".properties", "LowVolumeRain");

    public static float volume;

    @Override
    public void onInitializeClient() {
        config.setIfAbsent("volume", "0.025");

        reloadVolume();
    }

    public static void reloadVolume() {
        volume = getFloat(config.get("volume"));

        LOGGER.info("The volume has been set to {}!", volume);
    }

    private static float getFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException ignored) {
            return 0.025f;
        }
    }
}
