package net.onfyre.aternium.mixin.optimization;

import net.minecraft.SharedConstants;
import net.onfyre.aternium.Aternium;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SharedConstants.class)
public class SharedConstantsMixin {
    @Inject(at = @At("HEAD"), method = "enableDataFixerOptimization")
    private static void enableDataFixerOptimizations(CallbackInfo ci) {
        Aternium.log("DataFixer optimizations done!");
    }
}