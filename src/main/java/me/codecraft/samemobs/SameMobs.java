package me.codecraft.samemobs;

import me.codecraft.samemobs.effects.SameMobEffects;
import me.codecraft.samemobs.entity.SameMobsEntity;
import me.codecraft.samemobs.potions.SameMobPotions;
import me.codecraft.samemobs.utils.Registry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SameMobs implements ModInitializer {

    public static final String  MOD_ID = "samemob";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        SameMobsEntity.registerEntity();
        Registry.init();
        SameMobEffects.register();
        SameMobPotions.register();

    }
}
