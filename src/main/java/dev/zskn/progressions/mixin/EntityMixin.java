 package dev.zskn.progressions.mixin;

 import net.minecraft.entity.Entity;
 import org.spongepowered.asm.mixin.Mixin;
 import org.spongepowered.asm.mixin.Shadow;
 import org.spongepowered.asm.mixin.injection.At;
 import org.spongepowered.asm.mixin.injection.Inject;
 import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

 @Mixin(value = Entity.class)
public abstract class EntityMixin {

     @Shadow protected int netherPortalTime;

     @Inject(method = "tickPortal", at = @At(value = "HEAD"))
     private void tickPortalIfNetherAllowedThroughGamerule(CallbackInfo ci) {
         this.netherPortalTime = 0;
     }
}
