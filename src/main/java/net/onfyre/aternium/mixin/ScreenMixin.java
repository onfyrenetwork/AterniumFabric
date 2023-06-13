package net.onfyre.aternium.mixin;

import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(Screen.class)
public abstract class ScreenMixin extends AbstractParentElement implements Drawable {
    @Shadow protected MinecraftClient client;
    @Shadow protected int width;
    @Shadow protected int height;

    @Inject(at = @At("RETURN"), method = "init")
    private void init(MinecraftClient client, int width, int height, CallbackInfo ci) {
        if((Screen)(Object)this instanceof TitleScreen) {
            for (ClickableWidget button: Screens.getButtons((Screen)(Object)this)) {
                if(buttonMatchesKey(button, "menu.online")) {
                    button.visible = false;
                }

                if (buttonMatchesKey(button, "narrator.button.accessibility")) {
                    button.visible = false;
                }

                if (buttonMatchesKey(button, "narrator.button.language")) {
                    button.visible = false;
                }
            }
        }
    }

    public boolean buttonMatchesKey(ClickableWidget button, String key) {
        Text buttonMessage = button.getMessage();
        Text keyMessage = Text.translatable(key);
        return Objects.equals(buttonMessage, keyMessage);
    }
}
