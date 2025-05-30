package me.lukiiy.lowrain;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private final Properties properties = new Properties();
    private final File file;
    private final String modName;

    public Config(String fileName, String modName) {
        File configDir = new File(Minecraft.getRunDirectory(), "config");
        if (!configDir.exists()) configDir.mkdirs();

        this.file = new File(configDir, fileName);
        this.modName = modName;

        load();
    }

    public void load() {
        if (!file.exists()) save();

        try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(file)) {
            properties.store(writer, modName + " Config");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public boolean has(String key) {
        return properties.getProperty(key) != null;
    }

    public void set(String key, String value) {
        properties.setProperty(key, value);
        save();
    }

    public void setIfAbsent(String key, String value) {
        if (has(key)) return;
        set(key, value);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public String getOrDefault(String key, String defaultKey) {
        return properties.getProperty(key, defaultKey);
    }
}
