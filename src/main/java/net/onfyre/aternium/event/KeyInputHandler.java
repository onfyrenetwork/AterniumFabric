package net.onfyre.aternium.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.onfyre.aternium.Aternium;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY_ATERNIUM = "key.category.aternium";
    public static final String KEY_BINDING_SETTINGS = "key.binding.settings";
    public static final String KEY_BINDING_ZOOM = "key.binding.zoom";

    public static KeyBinding settingKey;
    public static KeyBinding zoomKey;

    public static void registerKeyBindings() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(settingKey.wasPressed()) {
                assert client.player != null;
                client.player.sendMessage(Text.literal("Settings key was pressed!"));
            }

            if(zoomKey.isPressed()) {
                Aternium.zoomingActive = true;
            } else {
                Aternium.zoomingActive = false;
            }
        });
    }

    public static void register() {
        settingKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_BINDING_SETTINGS, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, KEY_CATEGORY_ATERNIUM));
        zoomKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_BINDING_ZOOM, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_ATERNIUM));

        registerKeyBindings();
    }
}
