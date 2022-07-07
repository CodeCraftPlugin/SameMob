package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity4;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity6;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel4;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel6;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender6 extends GeoEntityRenderer<WolfLikeEntity6> {
    public WolfLikeEntityRender6(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel6());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity6 instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike6/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike6/mob1.png");
    }
}
