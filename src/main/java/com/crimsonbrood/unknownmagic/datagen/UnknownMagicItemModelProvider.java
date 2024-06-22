package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class UnknownMagicItemModelProvider extends ItemModelProvider {
    public UnknownMagicItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UnknownMagic.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(UnknownMagicItems.RAW_ETHER);
        simpleItem(UnknownMagicItems.ETHER);
        simpleItem(UnknownMagicItems.WHITESTONE);
        simpleItem(UnknownMagicItems.VAROOT_STONE);

        simpleItem(UnknownMagicItems.ETHER_DETECTOR);
        simpleItem(UnknownMagicItems.STRAWBERRY);
        simpleItem(UnknownMagicItems.PINE_CONE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture(
                        "layer0", new ResourceLocation(UnknownMagic.MODID, "item/" + item.getId().getPath())
                );
    }
}
