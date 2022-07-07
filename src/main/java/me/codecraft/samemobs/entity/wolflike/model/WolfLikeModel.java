package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WolfLikeModel extends AnimatedGeoModel<WolfLikeEntity> {
    @Override
    public Identifier getModelResource(WolfLikeEntity object) {
        return new Identifier(SameMobs.MOD_ID,"geo/wolf_like.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity object) {
        return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike/mob1.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(WolfLikeEntity animatable) {
        return new Identifier(SameMobs.MOD_ID,"animations/wolflike.animation.json");
    }
}
