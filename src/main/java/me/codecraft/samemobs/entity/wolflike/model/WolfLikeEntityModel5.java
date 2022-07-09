package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity5;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WolfLikeEntityModel5 extends AnimatedGeoModel<WolfLikeEntity5> {
    @Override
    public Identifier getModelResource(WolfLikeEntity5 object) {
        return new Identifier(SameMobs.MOD_ID,"geo/wolf_like5.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity5 object) {
        return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike5/mob1.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(WolfLikeEntity5 animatable) {
        return new Identifier(SameMobs.MOD_ID,"animations/wolflike5.animation.json");
    }
}
