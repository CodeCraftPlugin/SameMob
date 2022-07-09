package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity6;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel5;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel6;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender6 extends GeoEntityRenderer<WolfLikeEntity6> {
    public WolfLikeEntityRender6(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel6());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity6 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike6/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike6/mob1.png");
        }
    }
}
