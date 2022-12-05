 package dev.zskn.progressions.mixin;

 import dev.zskn.progressions.ProgressionsLimiter;
 import net.minecraft.entity.Entity;
 import net.minecraft.world.World;
 import org.spongepowered.asm.mixin.Mixin;
 import org.spongepowered.asm.mixin.Shadow;
 import org.spongepowered.asm.mixin.injection.At;
 import org.spongepowered.asm.mixin.injection.Inject;
 import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

 @Mixin(value = Entity.class)
public abstract class EntityMixin {

     @Shadow protected int netherPortalTime;

     @Shadow public World world;

     @Inject(method = "tickPortal", at = @At(value = "RETURN"))
     private void tickPortalIfNetherAllowedThroughGamerule(CallbackInfo ci) {
         if(!this.world.getGameRules().getBoolean(ProgressionsLimiter.ALLOW_NETHER)) {
             this.netherPortalTime = 0;
         }
     }
}
