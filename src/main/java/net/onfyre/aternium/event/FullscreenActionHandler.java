package net.onfyre.aternium.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class FullscreenActionHandler {
    public static void listen() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            client.getWindow().toggleFullscreen();
        });

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            client.getWindow().toggleFullscreen();
            client.getWindow().setWindowedSize(1600, 750);
        });
    }
}
