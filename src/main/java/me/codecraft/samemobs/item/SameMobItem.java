package me.codecraft.samemobs.item;

import me.codecraft.samemobs.SameMobs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SameMobItem {

    public static final Item animation1 = register("aniamtion_1",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item animation2 = register("aniamtion_2",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item animation3 = register("aniamtion_3",new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    private static Item register(String name,Item item){
        return Registry.register(Registry.ITEM,new Identifier(SameMobs.MOD_ID,name),item);
    }
    public static void registerEntity(){
        SameMobs.LOGGER.info("registered all the items " + SameMobs.MOD_ID);
    }
}
