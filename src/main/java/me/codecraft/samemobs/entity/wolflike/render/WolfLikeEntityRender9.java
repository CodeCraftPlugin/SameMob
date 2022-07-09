package me.codecraft.samemobs.entity.wolflike.render;

import me.codecraft.samemobs.SameMobs;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity9;
import me.codecraft.samemobs.entity.wolflike.model.WolfLikeEntityModel9;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WolfLikeEntityRender9 extends GeoEntityRenderer<WolfLikeEntity9> {
    public WolfLikeEntityRender9(EntityRendererFactory.Context ctx) {
        super(ctx, new WolfLikeEntityModel9());
    }

    @Override
    public Identifier getTextureResource(WolfLikeEntity9 object) {
        if (object.hasAngerTime()){
           return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike9/angry.png");
        }
        else {
            return new Identifier(SameMobs.MOD_ID,"textures/entity/wolflike9/mob1.png");
        }
    }
}
