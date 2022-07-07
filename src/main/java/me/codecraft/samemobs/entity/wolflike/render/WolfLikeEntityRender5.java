package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity4;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity5;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel4;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel5;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender5 extends GeoEntityRenderer<WolfLikeEntity5> {
    public WolfLikeEntityRender5(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel5());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity5 instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike5/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike5/mob1.png");
    }
}
