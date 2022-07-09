package me.codecraft.samemobs.utils;

import me.codecraft.samemobs.entity.SameMobsEntity;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity1;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity2;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity3;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

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

}
