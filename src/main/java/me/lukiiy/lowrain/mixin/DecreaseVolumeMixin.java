package me.lukiiy.lowrain.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_555;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(class_555.class)
@Environment(EnvType.CLIENT)
public class DecreaseVolumeMixin {
    @Redirect(method = "method_1846", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;method_150(DDDLjava/lang/String;FF)V"))
    private void lowrain_change(World instance, double e, double f, double string, String g, float h, float v) {
        instance.method_150(e, f, string, g, 0.025f, v);
    }
}
