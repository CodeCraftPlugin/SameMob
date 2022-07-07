package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity1;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity2;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel1;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel2;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender1 extends GeoEntityRenderer<WolfLikeEntity1> {
    public WolfLikeEntityRender1(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel1());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity1 instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike1/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike1/mob1.png");
    }
}
