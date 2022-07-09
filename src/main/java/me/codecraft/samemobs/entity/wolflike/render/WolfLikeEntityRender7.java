package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity6;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity7;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel6;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel7;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender7 extends GeoEntityRenderer<WolfLikeEntity7> {
    public WolfLikeEntityRender7(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel7());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity7 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike7/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike7/mob1.png");
        }
    }
}
