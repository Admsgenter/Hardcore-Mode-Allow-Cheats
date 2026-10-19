package admsgenter.hardcore_mode_allow_cheats.mixin;

import net.minecraft.client.gui.screen.CreateWorldScreen;
import net.minecraft.client.gui.widget.button.Button;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
    @Shadow private String gameModeName;

    @Redirect(at = @At(opcode = Opcodes.PUTFIELD, target = "Lnet/minecraft/client/gui/widget/button/Button;active:Z", value = "FIELD"), method = "lambda$init$1", remap = false)
    private void active(Button 按钮, boolean 值) {}

    @Redirect(at = @At(opcode = Opcodes.PUTFIELD, target = "Lnet/minecraft/client/gui/screen/CreateWorldScreen;hardCore:Z", value = "FIELD"), method = "lambda$init$1", remap = false)
    private void hardCore(CreateWorldScreen 屏幕, boolean 值) {}

    @Redirect(at = @At(opcode = Opcodes.GETFIELD, ordinal = 0, target = "Lnet/minecraft/client/gui/screen/CreateWorldScreen;hardCore:Z", value = "FIELD"), method = "onCreate")
    private boolean hardCore(CreateWorldScreen 屏幕) { return "hardcore".equals(gameModeName); }
}