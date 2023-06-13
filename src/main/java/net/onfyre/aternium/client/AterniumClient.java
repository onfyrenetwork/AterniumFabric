package net.onfyre.aternium.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.onfyre.aternium.event.FullscreenActionHandler;
import net.onfyre.aternium.event.KeyInputHandler;

@Environment(EnvType.CLIENT)
public class AterniumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        FullscreenActionHandler.listen();

        ClientLifecycleEvents.CLIENT_STARTED.register((client) -> {
            client.getWindow().setWindowedSize(1000, 550);
            if (client.getWindow().isFullscreen()) {
                client.getWindow().toggleFullscreen();
            }
        });
    }
}
