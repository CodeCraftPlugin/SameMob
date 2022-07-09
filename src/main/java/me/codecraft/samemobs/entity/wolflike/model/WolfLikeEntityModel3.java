package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity3;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WolfLikeEntityModel3 extends AnimatedGeoModel<WolfLikeEntity3> {
    @Override
    public Identifier getModelResource(WolfLikeEntity3 object) {
        return new Identifier(SameMobs.MOD_ID,"geo/wolf_like3.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity3 object) {
        return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike3/mob1.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(WolfLikeEntity3 animatable) {
        return new Identifier(SameMobs.MOD_ID,"animations/wolflike3.animation.json");
    }
}
