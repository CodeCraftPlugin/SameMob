package me.codecraft.samemobs.entity;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SameMobsEntity {

    public static final EntityType<WolfLikeEntity1> WOLFLIKEENTITY1 = registery("wolf_like_1", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity1::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity2> WOLFLIKEENTITY2 = registery("wolf_like_2", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity2::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity3> WOLFLIKEENTITY3 = registery("wolf_like_3", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity3::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity4> WOLFLIKEENTITY4 = registery("wolf_like_4", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity4::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity5> WOLFLIKEENTITY5 = registery("wolf_like_5", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity5::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity6> WOLFLIKEENTITY6 = registery("wolf_like_6", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity6::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity7> WOLFLIKEENTITY7 = registery("wolf_like_7", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity7::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity8> WOLFLIKEENTITY8 = registery("wolf_like_8", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity8::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity9> WOLFLIKEENTITY9= registery("wolf_like_9", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity9::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());
    public static final EntityType<WolfLikeEntity10> WOLFLIKEENTITY10= registery("wolf_like_10", FabricEntityTypeBuilder.
            create(SpawnGroup.CREATURE, WolfLikeEntity10::new).dimensions(EntityDimensions.fixed(0.6F,0.85F)).trackRangeBlocks(10)
            .build());

    private static EntityType registery(String name, EntityType entity){
        return Registry.register(Registry.ENTITY_TYPE,new Identifier(SameMobs.MOD_ID,name),entity);
    }
    public static void registerEntity(){
        SameMobs.LOGGER.info("registered all the entities " + SameMobs.MOD_ID);
    }
}
