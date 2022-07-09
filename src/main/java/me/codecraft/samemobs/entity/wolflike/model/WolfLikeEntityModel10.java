package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity10;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WolfLikeEntityModel10 extends AnimatedGeoModel<WolfLikeEntity10> {
    @Override
    public Identifier getModelResource(WolfLikeEntity10 object) {
        return new Identifier(SameMobs.MOD_ID,"geo/wolf_like10.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity10 object) {
        return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike10/mob1.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(WolfLikeEntity10 animatable) {
        return new Identifier(SameMobs.MOD_ID,"animations/wolflike10.animation.json");
    }
}
