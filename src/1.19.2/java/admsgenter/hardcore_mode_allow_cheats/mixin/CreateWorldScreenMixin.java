package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
    @Shadow private CreateWorldScreen.SelectedGameMode gameMode;

    @Redirect(at = @At(opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/client/gui/screens/worldselection/CreateWorldScreen$SelectedGameMode;HARDCORE:Lnet/minecraft/client/gui/screens/worldselection/CreateWorldScreen$SelectedGameMode;", value = "FIELD"), method = "setGameMode")
    private CreateWorldScreen.SelectedGameMode HARDCORE() { return null; }

    @Redirect(at = @At(opcode = Opcodes.GETFIELD, ordinal = 0, target = "Lnet/minecraft/client/gui/screens/worldselection/CreateWorldScreen;hardCore:Z", value = "FIELD"), method = "createLevelSettings")
    private boolean hardCore(CreateWorldScreen 屏幕, boolean 值) { return gameMode == CreateWorldScreen.SelectedGameMode.HARDCORE; }
}