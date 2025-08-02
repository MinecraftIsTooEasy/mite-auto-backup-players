package net.wensc.mitemod.autobackupplayers.trans;

import net.minecraft.DedicatedServer;
import net.minecraft.server.MinecraftServer;
import net.wensc.mitemod.autobackupplayers.thread.BackupThread;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DedicatedServer.class})
public class InitMixin {
    public InitMixin() {
    }

    @Inject(
            method = {"startServer"},
            at = {@At("RETURN")}
    )
    private void injectInit(CallbackInfoReturnable<Boolean> callback) {
        MinecraftServer server = MinecraftServer.getServer();
        BackupThread.setWorldDir(server.getFolderName(), server);
    }
}
