 package me.codecraft.samemobs.entity.wolflike.model;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity6;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

 public class WolfLikeModel6 extends AnimatedGeoModel<WolfLikeEntity6> {
     @Override
     public Identifier getModelResource(WolfLikeEntity6 object) {
         return new Identifier(SameMobs.MOD_ID,"geo/wolf_like6.geo.json");
     }

     @Override
     public Identifier getTextureResource(WolfLikeEntity6 object) {
         return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike6/mob1.png");
     }

     /**
      * This resource location needs to point to a json file of your animation file,
      * i.e. "geckolib:animations/frog_animation.json"
      *
      * @param animatable
      * @return the animation file location
      */
     @Override
     public Identifier getAnimationResource(WolfLikeEntity6 animatable) {
         return new Identifier(SameMobs.MOD_ID,"animations/wolflike6.animation.json");
     }
 }
