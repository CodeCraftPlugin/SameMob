package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity1;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel1;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel2;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender1 extends GeoEntityRenderer<WolfLikeEntity1> {
    public WolfLikeEntityRender1(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel1());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity1 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike/mob1.png");
        }
    }
}
