package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WorldCreationUiState.class)
public class WorldCreationUiStateMixin {
    /**
     * @author 微小特工007
     * @reason 允许难度与允许作弊修改
     */
    @Overwrite
    public boolean isHardcore() { return false; }
}