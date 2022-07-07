package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity3;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity4;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel3;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel4;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender4 extends GeoEntityRenderer<WolfLikeEntity4> {
    public WolfLikeEntityRender4(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel4());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity4 instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike4/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike4/mob1.png");
    }
}
