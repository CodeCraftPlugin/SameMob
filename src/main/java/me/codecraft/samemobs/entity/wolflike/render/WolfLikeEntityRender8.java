package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity8;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel4;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel8;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender8 extends GeoEntityRenderer<WolfLikeEntity8> {
    public WolfLikeEntityRender8(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel8());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity8 instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike8/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike8/mob1.png");
    }
}
