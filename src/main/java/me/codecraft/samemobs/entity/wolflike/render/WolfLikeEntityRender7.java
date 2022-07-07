package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity7;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel4;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel7;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender7 extends GeoEntityRenderer<WolfLikeEntity7> {
    public WolfLikeEntityRender7(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel7());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity7 instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike7/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike7/mob1.png");
    }
}
