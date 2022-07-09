package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity8;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel8;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender8 extends GeoEntityRenderer<WolfLikeEntity8> {
    public WolfLikeEntityRender8(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel8());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity8 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike8/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike8/mob1.png");
        }
    }
}
