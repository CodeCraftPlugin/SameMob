package me.codecraft.samemobs.potions;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.effects.SameMobEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SameMobPotions {

    public static Potion ANIMATION_1;
    public static Potion ANIMATION_2;
    public static Potion ANIMATION_3;

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION,new Identifier(SameMobs.MOD_ID,name),potion);
    }
    public static void register(){
        ANIMATION_1 = registerPotion("animation_trigger_1",new Potion(new StatusEffectInstance(SameMobEffects.Animation_1)));
        System.out.println("registered all the potions in the mod by " + SameMobs.MOD_ID);
    }
}
