package me.lukiiy.lowrain.mixin;

import me.lukiiy.lowrain.LowVolumeRain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ClientPlayerEntity;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.List;

@Mixin(Minecraft.class)
public class ClientMixin {
    @Shadow public ClientPlayerEntity player;
    @Unique private static final List<Float> volCycle = Arrays.asList(0.12f, 0.075f, 0.05f, 0.025f, 0.012f);
    @Unique private static int volIdx = 2;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;isWorldRemote()Z", ordinal = 0))
    private void lowrain_key(CallbackInfo info) {
        if (Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_U && Keyboard.isKeyDown(Keyboard.KEY_F3)) {
            volIdx = (volIdx + 1) % volCycle.size();
            LowVolumeRain.Volume = volCycle.get(volIdx);

            this.player.method_490("§e[LowVolumeRain] §fSet the volume to " + LowVolumeRain.Volume + "!");
        }
    }
}
