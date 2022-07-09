package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity4;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel3;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel4;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender4 extends GeoEntityRenderer<WolfLikeEntity4> {
    public WolfLikeEntityRender4(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel4());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity4 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike4/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike4/mob1.png");
        }
    }
}
