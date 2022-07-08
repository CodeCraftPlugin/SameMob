package me.codecraft.samemobs.effects;

import me.codecraft.samemobs.SameMobs;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SameMobEffects {
    public static final StatusEffect Animation_1 = registerStatusEffects("extra_animation_1",new AnimationEffect1(StatusEffectCategory.NEUTRAL,1024419));
    public static final StatusEffect Animation_2 = registerStatusEffects("extra_animation_2",new AnimationEffect1(StatusEffectCategory.NEUTRAL,1024419));
    public static final StatusEffect Animation_3 = registerStatusEffects("extra_animation_3",new AnimationEffect1(StatusEffectCategory.NEUTRAL,1024419));

    private static StatusEffect registerStatusEffects(String name,StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(SameMobs.MOD_ID, name), effect);
    }
    public static void register() {
        SameMobs.LOGGER.info("registered all the effect " + SameMobs.MOD_ID);

    }
}
