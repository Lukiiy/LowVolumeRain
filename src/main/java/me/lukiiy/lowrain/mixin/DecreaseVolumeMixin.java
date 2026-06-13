package me.lukiiy.lowrain.mixin;

import me.lukiiy.lowrain.LowVolumeRain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GameRenderer.class)
@Environment(EnvType.CLIENT)
public class DecreaseVolumeMixin {
    @ModifyArg(method = "tickRain", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 0), index = 4)
    private float lowRain$change(float original) {
        return LowVolumeRain.volume;
    }

    @ModifyArg(method = "tickRain", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 1), index = 4)
    private float lowRain$change2(float original) {
        return LowVolumeRain.volume;
    }
}
