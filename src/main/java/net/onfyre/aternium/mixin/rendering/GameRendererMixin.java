package net.onfyre.aternium.mixin.rendering;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.onfyre.aternium.Aternium;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Inject(at = @At("RETURN"), method = "getFov", cancellable = true)
    private void getZoomLevel(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> ci) {
        if(Aternium.zoomingActive) {
            double fov = ci.getReturnValue();
            ci.setReturnValue(fov * 0.2);
        }
    }
}
