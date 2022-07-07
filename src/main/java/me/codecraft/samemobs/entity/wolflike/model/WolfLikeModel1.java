package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity1;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WolfLikeModel1 extends AnimatedGeoModel<WolfLikeEntity1> {
    @Override
    public Identifier getModelResource(WolfLikeEntity1 object) {
        return new Identifier(SameMobs.MOD_ID,"geo/wolf_like1.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity1 object) {
        return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike1/mob1.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(WolfLikeEntity1 animatable) {
        return new Identifier(SameMobs.MOD_ID,"animations/wolflike1.animation.json");
    }
}
