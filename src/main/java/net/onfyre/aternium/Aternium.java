package net.onfyre.aternium;

import net.fabricmc.api.ModInitializer;
import net.minecraft.MinecraftVersion;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aternium implements ModInitializer {

    public static final String modId = "AterniumClient";
    public static final String modVersion = "1.0.0";
    public static final String logPrefix = "[Aternium Client]";
    public static final Logger logger = LoggerFactory.getLogger(modId);
    public static final MinecraftClient client = MinecraftClient.getInstance();
    public static final String minecraftVersion = MinecraftVersion.CURRENT.getName();
    public static boolean zoomingActive = false;

    @Override
    public void onInitialize() {
        log("Aternium started up!");
        log("Running on Aternium version " + modVersion);
    }

    public static void log(String log) {
        logger.info(logPrefix + " " + log);
    }

    public static MinecraftClient getClient() {
        return client;
    }

    public static String getMinecraftVersion() {
        return minecraftVersion;
    }
}
