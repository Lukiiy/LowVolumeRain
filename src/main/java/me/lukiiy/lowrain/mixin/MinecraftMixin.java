package me.lukiiy.lowrain.mixin;

import me.lukiiy.lowrain.LowVolumeRain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.mob.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "setWorld(Lnet/minecraft/world/World;Ljava/lang/String;Lnet/minecraft/entity/mob/player/PlayerEntity;)V", at = @At("HEAD"))
    public void lowRain$reload(World world, String message, PlayerEntity player, CallbackInfo ci) {
        LowVolumeRain.reloadVolume();
    }
}
