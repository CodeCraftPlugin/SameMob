 package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity1;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity2;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WolfLikeModel2 extends AnimatedGeoModel<WolfLikeEntity2> {
    @Override
    public Identifier getModelResource(WolfLikeEntity2 object) {
        return new Identifier(SameMobs.MOD_ID,"geo/wolf_like2.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity2 object) {
        return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike2/mob1.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(WolfLikeEntity2 animatable) {
        return new Identifier(SameMobs.MOD_ID,"animations/wolflike2.animation.json");
    }
}
