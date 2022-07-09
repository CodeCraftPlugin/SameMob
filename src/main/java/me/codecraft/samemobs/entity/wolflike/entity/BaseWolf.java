package me.codecraft.samemobs.entity.wolflike.entity;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import me.codecraft.samemobs.effects.SameMobEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BaseWolf extends WolfEntity implements IAnimatable {

    private AnimationFactory factory =new AnimationFactory(this);
    private static boolean animation1;
    private static boolean animation2;
    private static boolean animation3;

    public BaseWolf(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this,"main",1,this::predicate));
        animationData.addAnimationController(new AnimationController(this,"extra",1,this::animation));
    }

    private <E extends IAnimatable> PlayState animation(AnimationEvent<E> event) {
        if (animation1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.extra_animation_1"));
            return PlayState.CONTINUE;
        } if (animation2){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.extra_animation_2"));
            return PlayState.CONTINUE;
        }
        if (animation3){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.extra_animation_3"));
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    @Override
    public void tick() {
        super.tick();
        if(this.hasStatusEffect(SameMobEffects.Animation_1)){
            animation1=true;
            animation2=false;
            animation3=false;
            this.removeStatusEffect(SameMobEffects.Animation_2);
            this.removeStatusEffect(SameMobEffects.Animation_3);
        }else  {
            animation1=false;
            this.removeStatusEffect(SameMobEffects.Animation_1);
        }
        if(this.hasStatusEffect(SameMobEffects.Animation_2)){
            animation2=true;
            animation3=false;
            animation1=false;
            this.removeStatusEffect(SameMobEffects.Animation_1);
            this.removeStatusEffect(SameMobEffects.Animation_3);
        }else {
            animation2=false;
            this.removeStatusEffect(SameMobEffects.Animation_2);
        }
        if(this.hasStatusEffect(SameMobEffects.Animation_3)){
            animation3=true;
            animation2=false;
            animation1=false;
            this.removeStatusEffect(SameMobEffects.Animation_2);
            this.removeStatusEffect(SameMobEffects.Animation_1);
        }else {
            animation3=false;
            this.removeStatusEffect(SameMobEffects.Animation_3);
        }
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
            if (this.isAlive()) {
                if (!animation3 || !animation2 || !animation1) {
                    if (this.isBegging()) {
                        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.beg"));
                        return PlayState.CONTINUE;
                    } else if (this.isInSittingPose()) {
                        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.sitting"));
                        return PlayState.CONTINUE;
                    } else if (event.isMoving()) {
                        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.walk"));
                        if (this.speed == 0.5f) {
                            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.run"));
                            return PlayState.CONTINUE;
                        }
                        return PlayState.CONTINUE;
                    }
                    if (this.hasAngerTime()) {
                        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.attack"));
                        return PlayState.CONTINUE;
                    }
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mob1.idle"));
                    return PlayState.CONTINUE;
                }
            }


        return PlayState.CONTINUE;
    }


}
