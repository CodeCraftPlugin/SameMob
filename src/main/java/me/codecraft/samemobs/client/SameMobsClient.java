package me.codecraft.samemobs.client;

import me.codecraft.samemobs.entity.SameMobsEntity;
import me.codecraft.samemobs.entity.wolflike.render.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class SameMobsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY, WolfLikeEntityRender::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY1, WolfLikeEntityRender1::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY2, WolfLikeEntityRender2::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY3, WolfLikeEntityRender3::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY4, WolfLikeEntityRender4::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY5, WolfLikeEntityRender5::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY6, WolfLikeEntityRender6::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY7, WolfLikeEntityRender7::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY8, WolfLikeEntityRender8::new);
        EntityRendererRegistry.register(SameMobsEntity.WOLFLIKEENTITY9, WolfLikeEntityRender9::new);
    }
}
