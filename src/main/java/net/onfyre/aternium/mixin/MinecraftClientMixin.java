package net.onfyre.aternium.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.onfyre.aternium.Aternium;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow @Final private Window window;

    @Inject(at = @At("RETURN"), method = "updateWindowTitle")
    public void updateWindowTitle(CallbackInfo ci) {
        if(this.window == null) {
            return;
        }
        this.window.setTitle("Minecraft " + Aternium.getMinecraftVersion() + " | Aternium Client " + Aternium.modVersion);
    }
}
