package me.codecraft.samemobs.utils;

import me.codecraft.samemobs.entity.SameMobsEntity;
import me.codecraft.samemobs.entity.wolflike.entity.BaseWolf;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class Registry {
    public static void init(){
        registerAttribute();
    }

    private static void registerAttribute() {
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY1, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY2, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY3, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY4, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY5, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY6, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY7, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY8, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY9, BaseWolf.createWolfAttributes());
        FabricDefaultAttributeRegistry.register(SameMobsEntity.WOLFLIKEENTITY10, BaseWolf.createWolfAttributes());
    }

}
