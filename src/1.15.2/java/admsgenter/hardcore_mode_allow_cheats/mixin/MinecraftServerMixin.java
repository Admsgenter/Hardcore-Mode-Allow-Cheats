package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.WorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Redirect(at = @At(target = "Lnet/minecraft/world/storage/WorldInfo;isHardcore()Z", value = "INVOKE"), method = "setDifficulty")
    private boolean isHardcore(WorldInfo 数据) { return false; }
}