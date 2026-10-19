package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
    @Redirect(at = @At(target = "Lnet/minecraft/world/storage/WorldInfo;isHardcore()Z", value = "INVOKE"), method = "tick")
    private boolean isHardcore(WorldInfo 数据) { return false; }
}