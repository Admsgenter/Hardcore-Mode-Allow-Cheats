package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.client.gui.screen.CreateWorldScreen;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
    @Shadow private CreateWorldScreen.GameMode gameMode;

    @Redirect(at = @At(opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/client/gui/screen/CreateWorldScreen$GameMode;HARDCORE:Lnet/minecraft/client/gui/screen/CreateWorldScreen$GameMode;", value = "FIELD"), method = "setGameMode")
    private CreateWorldScreen.GameMode HARDCORE() { return null; }

    @Redirect(at = @At(opcode = Opcodes.GETFIELD, ordinal = 1, target = "Lnet/minecraft/client/gui/screen/CreateWorldScreen;hardCore:Z", value = "FIELD"), method = "onCreate")
    private boolean hardCore(CreateWorldScreen 屏幕) { return gameMode == CreateWorldScreen.GameMode.HARDCORE; }
}