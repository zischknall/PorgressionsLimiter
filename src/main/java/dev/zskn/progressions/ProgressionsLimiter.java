package dev.zskn.progressions;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.world.GameRules;

public class ProgressionsLimiter implements ModInitializer {

    public static final GameRules.Key<GameRules.BooleanRule> ALLOW_END = GameRuleRegistry.register("allowEnd", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

    public static final GameRules.Key<GameRules.BooleanRule> ALLOW_WITHER = GameRuleRegistry.register("allowWither", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));

    public static final GameRules.Key<GameRules.BooleanRule> ALLOW_NETHER = GameRuleRegistry.register("allowNether", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.getGameRules().getBoolean(ALLOW_END) && !player.isSpectator() && player.getStackInHand(hand).getItem() == Items.ENDER_EYE && world.getBlockState(hitResult.getBlockPos()).getBlock().getClass() == EndPortalFrameBlock.class) {
                return ActionResult.FAIL;
            }

            return ActionResult.PASS;
        });
    }
}
