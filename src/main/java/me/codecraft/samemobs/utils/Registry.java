package me.codecraft.samemobs.utils;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.SameMobsEntity;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity1;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity2;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity3;
import me.codecraft.samemobs.item.SameMobItem;
import me.codecraft.samemobs.mixin.BrewingRecipeRegistryMixin;
import me.codecraft.samemobs.potions.SameMobPotions;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.potion.Potions;

public class Registry {
    public static void init(){
        registerAttribute();
    }

    private static void registerAttribute() {
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY, WolfLikeEntity.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY1, WolfLikeEntity1.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY2, WolfLikeEntity2.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY3, WolfLikeEntity3.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY4, WolfLikeEntity3.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY5, WolfLikeEntity3.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY6, WolfLikeEntity3.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY7, WolfLikeEntity3.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY8, WolfLikeEntity3.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY9, WolfLikeEntity3.createWolfAttributes());
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, SameMobItem.animation1,
                SameMobPotions.ANIMATION_1);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, SameMobItem.animation2,
                SameMobPotions.ANIMATION_2);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, SameMobItem.animation3,
                SameMobPotions.ANIMATION_3);
    }
}
