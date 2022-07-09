package me.codecraft.samemobs.effects;

import me.codecraft.samemobs.SameMobs;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SameMobEffects {
    public static StatusEffect Animation_1;
    public static StatusEffect Animation_2;
    public static StatusEffect Animation_3;

    private static StatusEffect registerStatusEffects(String name,StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(SameMobs.MOD_ID, name), effect);
    }
    public static void register() {
        Animation_1 = registerStatusEffects("extra_animation_1",new AnimationEffect1(StatusEffectCategory.NEUTRAL,1024419));
        Animation_2 = registerStatusEffects("extra_animation_2",new AnimationEffect2(StatusEffectCategory.NEUTRAL,16776960));
        Animation_3 = registerStatusEffects("extra_animation_3",new AnimationEffect3(StatusEffectCategory.NEUTRAL,16711680));
        SameMobs.LOGGER.info("registered all the effect " + SameMobs.MOD_ID);

    }
}
