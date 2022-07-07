 package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity8;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

 public class WolfLikeModel8 extends AnimatedGeoModel<WolfLikeEntity8> {
     @Override
     public Identifier getModelResource(WolfLikeEntity8 object) {
         return new Identifier(SameMobs.MOD_ID,"geo/wolf_like8.geo.json");
     }

     @Override
     public Identifier getTextureResource(WolfLikeEntity8 object) {
         return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike8/mob1.png");
     }

     /**
      * This resource location needs to point to a json file of your animation file,
      * i.e. "geckolib:animations/frog_animation.json"
      *
      * @param animatable
      * @return the animation file location
      */
     @Override
     public Identifier getAnimationResource(WolfLikeEntity8 animatable) {
         return new Identifier(SameMobs.MOD_ID,"animations/wolflike8.animation.json");
     }
 }
