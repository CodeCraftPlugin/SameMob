package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity2;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity3;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel2;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeModel3;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender3 extends GeoEntityRenderer<WolfLikeEntity3> {
    public WolfLikeEntityRender3(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeModel3());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity3 instance) {
        if(instance.hasAngerTime()){
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike3/angry.png");
        }
       return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike3/mob1.png");
    }
}
