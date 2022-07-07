package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender extends GeoEntityRenderer<WolfLikeEntity> {
    public WolfLikeEntityRender(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike/mob1.png");
    }
}
