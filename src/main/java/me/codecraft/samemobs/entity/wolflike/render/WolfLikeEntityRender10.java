package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity10;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel10;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender10 extends GeoEntityRenderer<WolfLikeEntity10> {
    public WolfLikeEntityRender10(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel10());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity10 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike10/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike10/mob1.png");
        }
    }
}
