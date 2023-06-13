package net.onfyre.aternium.mixin.guis;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SplashTextRenderer;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Shadow @Nullable private SplashTextRenderer splashText;

    @Mutable
    @Shadow @Final public static Text COPYRIGHT;

    @Inject(at = @At("HEAD"), method = "initWidgetsNormal")
    private void initWidgetsNormal(int y, int spacingY, CallbackInfo ci) {
        splashText = null;
        COPYRIGHT = Text.of("");
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("menu.title.settings"), (button) -> {

        }).dimensions(this.width / 2 - 100, y + spacingY * 2, 200, 20).build());
    }
}
