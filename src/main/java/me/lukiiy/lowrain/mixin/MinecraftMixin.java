package me.lukiiy.lowrain.mixin;

import me.lukiiy.lowrain.LowVolumeRain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "method_2115", at = @At("HEAD"))
    public void lowRain$reload(World string, String arg2, PlayerEntity par3, CallbackInfo ci) {
        LowVolumeRain.reloadVolume();
    }
}
