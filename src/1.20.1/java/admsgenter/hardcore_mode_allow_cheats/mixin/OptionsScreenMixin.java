package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin {
    @Redirect(at = @At(target = "Lnet/minecraft/client/multiplayer/ClientLevel$ClientLevelData;isHardcore()Z", value = "INVOKE"), method = "createOnlineButton")
    private boolean isHardcore(ClientLevel.ClientLevelData 数据) { return false; }
}