package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.client.gui.screen.OptionsScreen;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin {
    @Redirect(at = @At(target = "Lnet/minecraft/client/world/ClientWorld$ClientWorldInfo;isHardcore()Z", value = "INVOKE"), method = "init")
    private boolean isHardcore(ClientWorld.ClientWorldInfo 数据) { return false; }
}