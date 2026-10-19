package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
    @Redirect(at = @At(target = "Lnet/minecraft/client/gui/screens/worldselection/WorldCreationUiState;isHardcore()Z", value = "INVOKE"), method = "createLevelSettings")
    private boolean isHardcore(WorldCreationUiState 状态) { return 状态.getGameMode() == WorldCreationUiState.SelectedGameMode.HARDCORE; }
}