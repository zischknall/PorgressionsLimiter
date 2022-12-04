package dev.zskn.progressions.mixin;

import dev.zskn.progressions.ProgressionsLimiter;
import net.minecraft.block.WitherSkullBlock;
import net.minecraft.block.entity.SkullBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkullBlock.class)
public abstract class WitherSkullMixin {
    @Inject(method = "onPlaced(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/SkullBlockEntity;)V", at = @At(value = "HEAD"), cancellable = true)
    private static void onPlaced(World world, BlockPos pos, SkullBlockEntity blockEntity, CallbackInfo ci) {
        if(!world.getGameRules().getBoolean(ProgressionsLimiter.ALLOW_WITHER)) {
            ci.cancel();
        }
    }
}
