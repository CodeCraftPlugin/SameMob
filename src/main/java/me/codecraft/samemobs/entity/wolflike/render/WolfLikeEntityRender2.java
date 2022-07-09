package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity2;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel2;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender2 extends GeoEntityRenderer<WolfLikeEntity2> {
    public WolfLikeEntityRender2(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel2());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity2 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike2/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike2/mob1.png");
        }
    }
}
