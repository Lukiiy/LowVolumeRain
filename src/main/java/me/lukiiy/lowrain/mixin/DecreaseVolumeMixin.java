package me.lukiiy.lowrain.mixin;

import me.lukiiy.lowrain.LowVolumeRain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_555;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(class_555.class)
@Environment(EnvType.CLIENT)
public class DecreaseVolumeMixin {
    @ModifyArg(method = "method_1846", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;method_150(DDDLjava/lang/String;FF)V", ordinal = 0), index = 4)
    private float lowRain$change(float original) {
        return LowVolumeRain.volume;
    }

    @ModifyArg(method = "method_1846", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;method_150(DDDLjava/lang/String;FF)V", ordinal = 1), index = 4)
    private float lowRain$change2(float original) {
        return LowVolumeRain.volume;
    }
}
